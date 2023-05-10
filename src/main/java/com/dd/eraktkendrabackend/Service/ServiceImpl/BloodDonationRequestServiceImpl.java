package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.AddBloodDTO;
import com.dd.eraktkendrabackend.DTO.BloodDonationRecordDTO;
import com.dd.eraktkendrabackend.DTO.BloodDonationRequestDTO;
import com.dd.eraktkendrabackend.Entity.BloodDonationRecord;
import com.dd.eraktkendrabackend.Entity.BloodDonationRequest;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Repository.BLoodDonationRequestRepository;
import com.dd.eraktkendrabackend.Repository.BloodDonationRecordRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;
import com.dd.eraktkendrabackend.Service.BloodDonationRequestService;
import com.dd.eraktkendrabackend.Service.BloodRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BloodDonationRequestServiceImpl implements BloodDonationRequestService {

    private static final Logger logger = LoggerFactory.getLogger(BloodBankServiceImpl.class);

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

        logger.info("User has requested for blood donation...");
        User user = userRepository.findById(bloodDonationRequestDTO.getUserId()).get();

        BloodDonationRequest bloodDonationRequest = new BloodDonationRequest(
                user,
                bloodDonationRequestDTO.getBloodType(),
                bloodDonationRequestDTO.getBankId()
        );

        try {
            bLoodDonationRequestRepository.save(bloodDonationRequest);
            logger.info("Successfully requested the blood donation requeset");
            return true;
        } catch (Exception e) {
            logger.error("Error occurred while requesting for blood donation");
            return false;
        }
    }


    @Override
    public boolean acceptBloodDonationRequest(long donationRequestId) {
        logger.info("Fieldworker is accepting blood donation request of user...");
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

            logger.info("Successfully accepted blood donation request and updated the bank records");
            // Incrementing user's credit
            User user = bloodDonationRequest.getUser();
            int credit = user.getCredit();
            credit++;
            user.setCredit(credit);
            userRepository.save(user);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error occured while accepting the blood donation request!!!");
            return false;
        }
    }

    @Override
    public boolean revokeBloodDonationRequest(long userId) {
        logger.info("user wants to revoke his blood donation request");
        try {
            BloodDonationRequest bloodDonationRequest = bLoodDonationRequestRepository.findByUser_UserId(userId);
            bLoodDonationRequestRepository.delete(bloodDonationRequest);
            return true;
        } catch (Exception e) {
            logger.error("Error ocured while deleting blood donation request");
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean checkBloodDonationRequest(long userId) {
        logger.info("Checking if blood donation request already present or not.");
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
        logger.info("Get all the blood donation request for the  particular bank");
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

    @Override
    public List<BloodDonationRecordDTO> getBloodDonationHistory(long userId) {
        logger.info("user requesting for his/her blood donation history...");
        List<BloodDonationRecord> bloodDonationRecordList = bloodDonationRecordRepository.findAllByUser_UserId(userId);

        List<BloodDonationRecordDTO> bloodDonationRecordDTOList = new ArrayList<>();

        for(BloodDonationRecord bloodDonationRecord: bloodDonationRecordList) {
            bloodDonationRecordDTOList.add(new BloodDonationRecordDTO(
                    bloodDonationRecord.getDonationRecordId(),
                    bloodDonationRecord.getUser().getUserId(),
                    bloodDonationRecord.getBloodType(),
                    bloodDonationRecord.getBloodBankId(),
                    bloodDonationRecord.getDateOfDonation()
            ));
        }
        return bloodDonationRecordDTOList;
    }
}
