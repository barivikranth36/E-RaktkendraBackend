package com.dd.eraktkendrabackend.Service;

import com.dd.eraktkendrabackend.DTO.BloodRequestDTO;

public interface BloodRequestService {

    // ------------------------------ User requests for blood ------------------------------------------
    boolean bloodRequestByUser(BloodRequestDTO bloodRequestDTO);

    // ------------------------------ Revoke blood request -------------------------------------
    boolean revokeBloodRequest(long userId);
}
