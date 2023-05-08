package com.dd.eraktkendrabackend.Service;


import com.dd.eraktkendrabackend.DTO.LoginDTO;
import com.dd.eraktkendrabackend.Entity.User;

public interface UserService {
    User addUser(User user);

    User userLogin(LoginDTO loginDTO);
}
