package id.starter.perustakaan.service;

import id.starter.perustakaan.common.RestResult;
import id.starter.perustakaan.common.StatusCode;
import id.starter.perustakaan.dao.BaseDao;
import id.starter.perustakaan.dao.UserDao;
import id.starter.perustakaan.entity.Role;
import id.starter.perustakaan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */
@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserDao dao;

    @Override
    protected BaseDao<User> getDAO(){
        return dao;
    }

    @Autowired
    private JwtTokenService jwtTokenService;

    /*public UserService() {
    }**/

    @Transactional
    public User register(User param, Role role) {
        User reference = dao.findOne(new User(param.getUsername()));

        if (reference != null) {
             param.setUsername("not available");
            return param;
        }else{
            param.setRole(role);
            param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

            dao.save(param);

            return param;
        }
    }

    @Transactional
    public RestResult login(User param){
        RestResult result = new RestResult(StatusCode.PASSWORD_OR_USER_NOT_REGISTERED);

        User currentUser = dao.findOne(param);

        if (currentUser == null){
            return result;
        }else if(currentUser.getPassword() != null && BCrypt.checkpw(param.getPassword(), currentUser.getPassword())) {
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

            currentUser.setToken(jwtTokenService.generateToken(userDetails));

            result.setData(currentUser);
            result.setStatus(StatusCode.LOGIN_SUCCESS);
        }else{
            result.setStatus(StatusCode.LOGIN_FAILED);
        }

        return result;
    }
}
