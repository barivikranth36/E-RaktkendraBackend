package com.dd.eraktkendrabackend.Controller;

import com.dd.eraktkendrabackend.DTO.LoginDTO;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;

    //------------------------------------------------ add user --------------------------------------------------------
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    // ------------------------------------------- user Login ---------------------------------------------------------------
    @GetMapping("/userLogin")
    public User userLogin(@RequestBody LoginDTO loginDTO) {
        return userService.userLogin(loginDTO);
    }

}
