package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.LoginDTO;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Repository.BLoodDonationRequestRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;
import com.dd.eraktkendrabackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BLoodDonationRequestRepository bLoodDonationRequestRepository;
    @Override
    public User addUser(User user) {
            return userRepository.save(user);
    }

    @Override
    public User userLogin(LoginDTO loginDTO) {
        User user = userRepository.findByEmailId(loginDTO.getUsername());
        if((user != null) && user.getPassword().equals(loginDTO.getPassword())) {
            System.out.println(user);
            return user;
        }
        else
            return null;
    }


}
