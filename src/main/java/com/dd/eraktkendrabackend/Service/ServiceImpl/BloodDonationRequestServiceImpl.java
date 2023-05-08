package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.AddBloodDTO;
import com.dd.eraktkendrabackend.DTO.BloodDonationRequestDTO;
import com.dd.eraktkendrabackend.Entity.BloodDonationRecord;
import com.dd.eraktkendrabackend.Entity.BloodDonationRequest;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Repository.BLoodDonationRequestRepository;
import com.dd.eraktkendrabackend.Repository.BloodDonationRecordRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;
import com.dd.eraktkendrabackend.Service.BloodDonationRequestService;
import com.dd.eraktkendrabackend.Service.BloodRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BloodDonationRequestServiceImpl implements BloodDonationRequestService {

    @Autowired
    private BLoodDonationRequestRepository bLoodDonationRequestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BloodDonationRecordRepository bloodDonationRecordRepository;

    @Autowired
    private BloodRecordService bloodRecordService;

    @Override
    public boolean bloodDonationRequest(BloodDonationRequestDTO bloodDonationRequestDTO) {

        User user = userRepository.findById(bloodDonationRequestDTO.getUserId()).get();

        BloodDonationRequest bloodDonationRequest = new BloodDonationRequest(
                user,
                bloodDonationRequestDTO.getBloodType(),
                bloodDonationRequestDTO.getBankId()
        );

        try {
            bLoodDonationRequestRepository.save(bloodDonationRequest);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public boolean acceptBloodDonationRequest(long donationRequestId) {
        BloodDonationRequest bloodDonationRequest = bLoodDonationRequestRepository.findById(donationRequestId).get();

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = dateFormat.format(new Date());
            Date currentDateObject = dateFormat.parse(currentDate);

            BloodDonationRecord bloodDonationRecord = new BloodDonationRecord(
                    bloodDonationRequest.getUser(),
                    bloodDonationRequest.getBloodType(),
                    bloodDonationRequest.getBankId(),
                    currentDateObject
            );
            bloodDonationRecordRepository.save(bloodDonationRecord);
            bLoodDonationRequestRepository.delete(bloodDonationRequest);
            // Updating blood unit in that particular blood bank
            AddBloodDTO addBloodDTO = new AddBloodDTO(bloodDonationRequest.getBankId(),
                    bloodDonationRequest.getBloodType());
            bloodRecordService.addBlood(addBloodDTO);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean revokeBloodDonationRequest(long userId) {
        try {
            BloodDonationRequest bloodDonationRequest = bLoodDonationRequestRepository.findByUser_UserId(userId);
            bLoodDonationRequestRepository.delete(bloodDonationRequest);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean checkBloodDonationRequest(long userId) {
        try {
            BloodDonationRequest bloodDonationRequest = bLoodDonationRequestRepository.findByUser_UserId(userId);
            if(bloodDonationRequest != null)
                return true;
            else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<BloodDonationRequestDTO> getAllBloodDonationRequests(long bankId) {
        List<BloodDonationRequest> bloodDonationRequestList = bLoodDonationRequestRepository
                .findAllByBankId(bankId);

        try {
            List<BloodDonationRequestDTO> bloodDonationRequestDTOList = new ArrayList<>();
            for (BloodDonationRequest bloodDonationRequest : bloodDonationRequestList) {
                bloodDonationRequestDTOList.add(new BloodDonationRequestDTO(
                        bloodDonationRequest.getDonationRequestId(),
                        bloodDonationRequest.getBankId(),
                        bloodDonationRequest.getBloodType(),
                        bloodDonationRequest.getUser().getUserId()
                ));
            }
            return bloodDonationRequestDTOList;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
