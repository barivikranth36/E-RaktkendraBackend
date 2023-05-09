package com.dd.eraktkendrabackend.Controller;

import com.dd.eraktkendrabackend.DTO.BloodDonationRecordDTO;
import com.dd.eraktkendrabackend.DTO.BloodDonationRequestDTO;
import com.dd.eraktkendrabackend.Service.BloodDonationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodDonation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BloodDonationController {

    @Autowired
    private BloodDonationRequestService bloodDonationRequestService;

    // -------------------------- User's blood donation request --------------------------------------------------------
    @PostMapping("/bloodDonationRequest")
    public boolean bloodDonationRequest(@RequestBody BloodDonationRequestDTO bloodDonationRequestDTO){
        return bloodDonationRequestService.bloodDonationRequest(bloodDonationRequestDTO);
    }

    // ----------------------------- Revoke blood donation request -----------------------------------------
    @DeleteMapping("/revokeBloodDonationRequest/{userId}")
    public boolean revokeBloodDonationRequest(@PathVariable String userId) {
        return bloodDonationRequestService.revokeBloodDonationRequest(Long.parseLong(userId));
    }

    // ---------------------------- Check for blood Donation request --------------------------
    @GetMapping("/checkBloodDonationRequest/{userId}")
    public boolean checkBloodDonationRequest(@PathVariable String userId) {
        return bloodDonationRequestService.checkBloodDonationRequest(Long.parseLong(userId));
    }

    // ------------------------------ Field Worker accepts user's blood request ----------------------------------------
    @DeleteMapping("/acceptBloodDonationRequest/{donationRequestId}")
    public boolean acceptBloodDonationRequest(@PathVariable String donationRequestId) {
        return bloodDonationRequestService.acceptBloodDonationRequest(Long.parseLong(donationRequestId));
    }

    // -------------------------------- Field worker rejects user's donation request -----------------------------
    @DeleteMapping("/deleteBloodDonationRequest/{userId}")
    public boolean deleteBloodDonationRequest(@PathVariable String userId) {
        return bloodDonationRequestService.revokeBloodDonationRequest(Long.parseLong(userId));
    }

    // -------------------------- Get list of all blood donation requests ----------------------------------------
    @GetMapping("/getAllBloodDonationRequests/{bankId}")
    public List<BloodDonationRequestDTO> getAllBloodDonationRequests(@PathVariable String bankId) {
        return bloodDonationRequestService.getAllBloodDonationRequests(Long.parseLong(bankId));
    }

    // --------------------------------- Get blood donation history ----------------------
    @GetMapping("/getBloodDonationHistory/{userId}")
    public List<BloodDonationRecordDTO> getBloodDonationHistory(@PathVariable String userId) {
        return bloodDonationRequestService.getBloodDonationHistory(Long.parseLong(userId));
    }

}
