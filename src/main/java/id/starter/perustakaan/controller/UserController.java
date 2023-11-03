package id.starter.perustakaan.controller;

import id.starter.perustakaan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    private UserService service;

}
