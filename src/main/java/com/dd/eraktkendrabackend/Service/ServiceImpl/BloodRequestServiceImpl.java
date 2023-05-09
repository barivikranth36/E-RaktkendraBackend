package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.BloodRecordDTO;
import com.dd.eraktkendrabackend.DTO.BloodRequestDTO;
import com.dd.eraktkendrabackend.Entity.*;
import com.dd.eraktkendrabackend.Repository.*;
import com.dd.eraktkendrabackend.Service.BloodRecordService;
import com.dd.eraktkendrabackend.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodRequestServiceImpl implements BloodRequestService {

    @Autowired
    private BloodRecordService bloodRecordService;

    @Autowired
    private BloodRecordRepository bloodRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @Autowired
    private BloodRequestRecordRepository bloodRequestRecordRepository;

    @Override
    public boolean bloodRequestByUser(BloodRequestDTO bloodRequestDTO) {
        List<BloodRecordDTO> bloodRecordDTOList = bloodRecordService.getBloodRecord(bloodRequestDTO
                .getBloodBankId());

        BloodBank bloodBank = bloodBankRepository.findById(bloodRequestDTO.getBloodBankId()).get();

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
                        totalCost,
                        bloodBank
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

    @Override
    public boolean acceptBloodRequest(long bloodRequestId) {
         /* - Create object of BloodRequestRecord class and fill the values.
            - Remove the entry from BloodRequest table
            - decrease the quantity of blood in blood record of that bloodbank
         */
        BloodRequest bloodRequest = bloodRequestRepository.findById(bloodRequestId).get();

        BloodRequestRecord bloodRequestRecord = new BloodRequestRecord(
                bloodRequest.getUser(),
                bloodRequest.getBloodType(),
                bloodRequest.getQuantity(),
                bloodRequest.getTotalCost(),
                bloodRequest.getBloodBank().getBloodBankId()
        );

        try {
            // Deleting record from Blood request table
            bloodRequestRepository.delete(bloodRequest);

            // Saving blood request record to database
            bloodRequestRecordRepository.save(bloodRequestRecord);

            // Decrementing from Blood record table
            BloodRecord bloodRecord = bloodRecordRepository.findBloodRecordByBloodBank_BloodBankIdAndAndBloodType(
                    bloodRequestRecord.getBankId(),
                    bloodRequestRecord.getBloodType()
            );
            long quantity = bloodRecord.getQuantity();
            quantity -= bloodRequestRecord.getQuantity();

            bloodRecord.setQuantity(quantity);
            bloodRecordRepository.save(bloodRecord);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<BloodRequestDTO> getAllBloodRequests(long bankId) {
        List<BloodRequest> bloodRequestList = bloodRequestRepository.findAllByBloodBank_BloodBankId(bankId);

        List<BloodRequestDTO> bloodRequestDTOList = new ArrayList<>();
        for(BloodRequest bloodRequest: bloodRequestList) {
            bloodRequestDTOList.add(new BloodRequestDTO(
                    bloodRequest.getBloodRequestId(),
                    bloodRequest.getBloodBank().getBloodBankId(),
                    bloodRequest.getBloodType(),
                    bloodRequest.getUser().getUserId(),
                    bloodRequest.getQuantity(),
                    bloodRequest.getTotalCost()
            ));
        }

        return bloodRequestDTOList;
    }
}
