package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.BloodRecordDTO;
import com.dd.eraktkendrabackend.DTO.BloodRequestDTO;
import com.dd.eraktkendrabackend.Entity.BloodRequest;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Repository.BloodRequestRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;
import com.dd.eraktkendrabackend.Service.BloodRecordService;
import com.dd.eraktkendrabackend.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodRequestServiceImpl implements BloodRequestService {

    @Autowired
    private BloodRecordService bloodRecordService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    @Override
    public boolean bloodRequestByUser(BloodRequestDTO bloodRequestDTO) {
        List<BloodRecordDTO> bloodRecordDTOList = bloodRecordService.getBloodRecord(bloodRequestDTO
                .getBloodBankId());

        User user = userRepository.findById(bloodRequestDTO.getUserId()).get();

        BloodRequest bloodRequest;
        long totalCost = 0;

        for(BloodRecordDTO bloodRecordDTO: bloodRecordDTOList) {
            if((bloodRecordDTO.getBloodType().equals(bloodRequestDTO.getBloodType())) &&
                    (bloodRecordDTO.getQuantity() >= bloodRequestDTO.getQuantity())) {

                totalCost = bloodRequestDTO.getQuantity() * bloodRecordDTO.getCostPerUnit();

                bloodRequest = new BloodRequest(
                        user,
                        bloodRequestDTO.getBloodType(),
                        bloodRequestDTO.getQuantity(),
                        totalCost
                );

                // Saving to blood request table
                bloodRequestRepository.save(bloodRequest);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean revokeBloodRequest(long userId) {
        try {
            BloodRequest bloodRequest = bloodRequestRepository.findBloodRequestByUser_UserId(userId);
            bloodRequestRepository.delete(bloodRequest);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
