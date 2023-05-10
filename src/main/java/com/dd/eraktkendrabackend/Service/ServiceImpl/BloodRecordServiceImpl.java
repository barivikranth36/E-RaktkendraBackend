package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.AddBloodDTO;
import com.dd.eraktkendrabackend.DTO.BloodRecordDTO;
import com.dd.eraktkendrabackend.Entity.BloodRecord;
import com.dd.eraktkendrabackend.Repository.BloodRecordRepository;
import com.dd.eraktkendrabackend.Service.BloodRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodRecordServiceImpl implements BloodRecordService {

    private static final Logger logger = LoggerFactory.getLogger(BloodRecordServiceImpl.class);

    @Autowired
    private BloodRecordRepository bloodRecordRepository;

    @Override
    public boolean addBlood(AddBloodDTO addBloodDTO) {
        logger.info("Adding blood to the bank...");
        BloodRecord bloodRecord = bloodRecordRepository.findBloodRecordByBloodBank_BloodBankIdAndAndBloodType(
                addBloodDTO.getBloodBankId(),
                addBloodDTO.getBloodType()
        );
        long quantity = bloodRecord.getQuantity();
        quantity++;
        bloodRecord.setQuantity(quantity);
        try {
            bloodRecordRepository.save(bloodRecord);
            return true;
        } catch (Exception e) {
            logger.error("Error ocurred while adding blood to a specific bank...");
            return false;
        }
    }

    @Override
    public List<BloodRecordDTO> getBloodRecord(long bloodBankId) {
        logger.info("Getting all the blood records of a particular bank.");
        List<BloodRecord> bloodRecordList = bloodRecordRepository.findAllByBloodBank_BloodBankId(bloodBankId);

        List<BloodRecordDTO> bloodRecordDTOList = new ArrayList<>();

        for(BloodRecord bloodRecord: bloodRecordList) {
            bloodRecordDTOList.add(new BloodRecordDTO(
                    bloodRecord.getBloodType(),
                    bloodRecord.getQuantity(),
                    bloodRecord.getCostPerUnit(),
                    bloodRecord.getBloodBank().getBloodBankId()
            ));
        }

        return bloodRecordDTOList;
    }
}
