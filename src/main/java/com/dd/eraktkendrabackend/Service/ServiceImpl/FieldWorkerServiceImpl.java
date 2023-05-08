package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.FieldWorkerDTO;
import com.dd.eraktkendrabackend.DTO.LoginDTO;
import com.dd.eraktkendrabackend.Entity.BloodBank;
import com.dd.eraktkendrabackend.Entity.FieldWorker;
import com.dd.eraktkendrabackend.Repository.BloodBankRepository;
import com.dd.eraktkendrabackend.Repository.FieldWorkerRepository;
import com.dd.eraktkendrabackend.Service.FieldWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldWorkerServiceImpl implements FieldWorkerService {
    @Autowired
    private FieldWorkerRepository fieldWorkerRepository;

    @Autowired
    private BloodBankRepository bloodBankRepository;


    @Override
    public FieldWorkerDTO registerFieldWorker(FieldWorkerDTO fieldWorkerDTO) {

        BloodBank bloodBank = bloodBankRepository.findById(fieldWorkerDTO.getBloodBankId()).get();

        FieldWorker fieldWorker = new FieldWorker(
                fieldWorkerDTO.getTitle(),
                fieldWorkerDTO.getFirstName(),
                fieldWorkerDTO.getLastName(),
                fieldWorkerDTO.getDob(),
                fieldWorkerDTO.getGender(),
                fieldWorkerDTO.getPhoneNumber(),
                fieldWorkerDTO.getEmailId(),
                fieldWorkerDTO.getPassword(),
                fieldWorkerDTO.getAddress(),
                fieldWorkerDTO.getCity(),
                fieldWorkerDTO.getPincode(),
                bloodBank
        );

        fieldWorkerRepository.save(fieldWorker);
        return fieldWorkerDTO;
    }

    @Override
    public FieldWorkerDTO fieldWorkerLogin(LoginDTO loginDTO) {
        FieldWorker fieldWorker = fieldWorkerRepository.findByEmailId(loginDTO.getUsername());
        if((fieldWorker != null) && fieldWorker.getPassword().equals(loginDTO.getPassword())) {
//            System.out.println(fieldWorker);
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
        }
        else
            return null;
    }
}
