package id.starter.perustakaan.controller;

import id.starter.perustakaan.common.RestResult;
import id.starter.perustakaan.entity.Role;
import id.starter.perustakaan.entity.User;
import id.starter.perustakaan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */
@RestController
@RequestMapping("auth")
public class AuthController extends BaseController {
    @Autowired
    private UserService service;

    @PreAuthorize("permitAll()")
    @PostMapping(value = "login")
    public RestResult doLogin(@RequestBody User user){
        return service.login(user);
    }

    @PreAuthorize("permitAll()")
    @PostMapping(value = "register")
    public RestResult doRegister(@RequestBody User param){
        return new RestResult(service.register(param, Role.ROLE_USER));
    }

}
