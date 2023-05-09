package com.dd.eraktkendrabackend.Controller;

import com.dd.eraktkendrabackend.DTO.BloodRequestDTO;
import com.dd.eraktkendrabackend.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // -------------------------- Reject blood request from user by fieldworker -----------------------
    @DeleteMapping("/rejectBloodRequest/{userId}")
    public boolean rejectBloodRequest(@PathVariable String userId) {
        return bloodRequestService.revokeBloodRequest(Long.parseLong(userId));
    }

    // --------------------------- Field Worker accepts blood request -------------------------------------
    @DeleteMapping("/acceptBloodRequest/{bloodRequestId}")
    public boolean acceptBloodRequest(@PathVariable String bloodRequestId) {
        return bloodRequestService.acceptBloodRequest(Long.parseLong(bloodRequestId));
    }

    // -------------------------- Get all blood requests ----------------------------------------------
    @GetMapping("/getAllBloodRequests/{bankId}")
    public List<BloodRequestDTO> getAllBloodRequests(@PathVariable String bankId) {
        return bloodRequestService.getAllBloodRequests(Long.parseLong(bankId));
    }
}
