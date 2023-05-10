package com.dd.eraktkendrabackend.Controller;

import com.dd.eraktkendrabackend.DTO.BloodRequestDTO;
import com.dd.eraktkendrabackend.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodRequest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;

    // Request for blood by providing userId, BloodType, Quantity, BankId
    @PreAuthorize("hasRole(ROLE_USER)")
    @PostMapping("/bloodRequestByUser")
    public boolean bloodRequestByUser(@RequestBody BloodRequestDTO bloodRequestDTO) {
        return bloodRequestService.bloodRequestByUser(bloodRequestDTO);
    }

    // ---------------------- Check if blood request exist or not on user side ----------------------------
    @PreAuthorize("hasRole(ROLE_USER)")
    @GetMapping("/checkBloodRequest/{userId}")
    public boolean checkBloodRequest(@PathVariable String userId) {
        return bloodRequestService.checkBloodRequest(Long.parseLong(userId));
    }

    // --------------------------------- Revoke the blood request -----------------------------------
    @PreAuthorize("hasRole(ROLE_USER)")
    @DeleteMapping("/revokeBloodRequest/{userId}")
    public boolean revokeBloodRequest(@PathVariable String userId) {
//        return true;
        return bloodRequestService.revokeBloodRequest(Long.parseLong(userId));
    }

    // -------------------------- Reject blood request from user by fieldworker -----------------------
    @PreAuthorize("hasRole(ROLE_FIELDWORKER)")
    @DeleteMapping("/rejectBloodRequest/{userId}")
    public boolean rejectBloodRequest(@PathVariable String userId) {
        return bloodRequestService.revokeBloodRequest(Long.parseLong(userId));
    }

    // --------------------------- Field Worker accepts blood request -------------------------------------
    @PreAuthorize("hasRole(ROLE_FIELDWORKER)")
    @DeleteMapping("/acceptBloodRequest/{bloodRequestId}")
    public boolean acceptBloodRequest(@PathVariable String bloodRequestId) {
        return bloodRequestService.acceptBloodRequest(Long.parseLong(bloodRequestId));
    }

    // -------------------------- Get all blood requests ----------------------------------------------
    @PreAuthorize("hasRole(ROLE_FIELDWORKER)")
    @GetMapping("/getAllBloodRequests/{bankId}")
    public List<BloodRequestDTO> getAllBloodRequests(@PathVariable String bankId) {
        return bloodRequestService.getAllBloodRequests(Long.parseLong(bankId));
    }
}
