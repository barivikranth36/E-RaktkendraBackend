package com.dd.eraktkendrabackend.Service;

import com.dd.eraktkendrabackend.DTO.AddBloodDTO;
import com.dd.eraktkendrabackend.DTO.BloodRecordDTO;

import java.util.List;

public interface BloodRecordService {

    // ----------------------- Add blood to a particular blood_group of particular blood_bank --------------------------
    boolean addBlood(AddBloodDTO addBloodDTO);

    // ---------------------------- Get Blood records of a particular blood_bank ---------------------------------------
    List<BloodRecordDTO> getBloodRecord(long bloodBankId);
}
