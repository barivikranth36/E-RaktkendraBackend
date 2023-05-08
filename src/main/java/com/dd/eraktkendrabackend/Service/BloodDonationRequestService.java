package com.dd.eraktkendrabackend.Service;


import com.dd.eraktkendrabackend.DTO.BloodDonationRequestDTO;

import java.util.List;

public interface BloodDonationRequestService {

    // ------------------------------ Request Blood Donation -----------------------------------
    boolean bloodDonationRequest(BloodDonationRequestDTO bloodDonationRequestDTO);

    // ------------------- Field Worker accepts user's donation request --------------------------
    boolean acceptBloodDonationRequest(long donationRequestId);

    // ------------------- Revoke blood donation request by user ----------------------------------
    boolean revokeBloodDonationRequest(long userId);

    // ----------------------- Check if blood doantion request exist or not -----------------------
    // Returns true if blood request already present else false.
    boolean checkBloodDonationRequest(long userId);

    // -------------------- Get list of all blood donation request for a particular blood bank ------------
    List<BloodDonationRequestDTO> getAllBloodDonationRequests(long bankId);
}
