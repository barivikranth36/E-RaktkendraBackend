package com.dd.eraktkendrabackend.Controller;

import com.dd.eraktkendrabackend.DTO.BloodRequestDTO;
import com.dd.eraktkendrabackend.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bloodRequest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;

    // Request for blood by providing userId, BloodType, Quantity, BankId
    @PostMapping("/bloodRequestByUser")
    public boolean bloodRequestByUser(@RequestBody BloodRequestDTO bloodRequestDTO) {
        return bloodRequestService.bloodRequestByUser(bloodRequestDTO);
    }

    // --------------------------------- Revoke the blood request -----------------------------------
    @DeleteMapping("/revokeBloodRequest/{userId}")
    public boolean revokeBloodRequest(@PathVariable String userId) {
//        return true;
        return bloodRequestService.revokeBloodRequest(Long.parseLong(userId));
    }
}
