package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.FieldWorkerDTO;
import com.dd.eraktkendrabackend.DTO.InitialUserDetailsDTO;
import com.dd.eraktkendrabackend.DTO.JwtRequest;
import com.dd.eraktkendrabackend.Entity.FieldWorker;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Repository.FieldWorkerRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;
import com.dd.eraktkendrabackend.Service.MyInitialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyInitialServiceImpl implements MyInitialService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FieldWorkerRepository fieldWorkerRepository;

    @Override
    public InitialUserDetailsDTO getUser(JwtRequest jwtRequest) {

        User user = userRepository.findByEmailId(jwtRequest.getUsername());
        if(user != null) {
            return new InitialUserDetailsDTO(
                    user.getUserId(),
                    user.getTitle(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getDob(),
                    user.getGender(),
                    user.getPhoneNumber(),
                    user.getEmailId(),
                    user.getBloodType(),
                    user.getAddress(),
                    user.getCity(),
                    user.getPincode(),
                    user.getCredit()
            );
        } else return null;
    }

    @Override
    public FieldWorkerDTO getFieldWorker(JwtRequest jwtRequest) {
        FieldWorker fieldWorker = fieldWorkerRepository.findByEmailId(jwtRequest.getUsername());
        if(fieldWorker != null) {
            return new FieldWorkerDTO(
                    fieldWorker.getWorkerId(),
                    fieldWorker.getTitle(),
                    fieldWorker.getFirstName(),
                    fieldWorker.getLastName(),
                    fieldWorker.getDob(),
                    fieldWorker.getGender(),
                    fieldWorker.getPhoneNumber(),
                    fieldWorker.getEmailId(),
                    fieldWorker.getAddress(),
                    fieldWorker.getCity(),
                    fieldWorker.getPincode(),
                    fieldWorker.getBloodBank().getBloodBankId()
            );
        } else return null;
    }
}
