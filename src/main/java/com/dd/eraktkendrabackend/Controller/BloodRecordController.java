package com.dd.eraktkendrabackend.Controller;

import com.dd.eraktkendrabackend.DTO.BloodRecordDTO;
import com.dd.eraktkendrabackend.Service.BloodRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodRecord")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BloodRecordController {

    @Autowired
    private BloodRecordService bloodRecordService;

    // -------------------------- Get blood quantity and cost details based on blood_bank_id ---------------------------
    @GetMapping("/getBloodRecord/{bloodBankId}")
    public List<BloodRecordDTO> getBloodRecord(@PathVariable String bloodBankId) {
        return bloodRecordService.getBloodRecord(Long.parseLong(bloodBankId));
    }

    // --------------------------- Get the info of all available bloodb
}
