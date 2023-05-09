package com.dd.eraktkendrabackend.Service;

import com.dd.eraktkendrabackend.DTO.BloodRequestDTO;

import java.util.List;

public interface BloodRequestService {

    // ------------------------------ User requests for blood ------------------------------------------
    boolean bloodRequestByUser(BloodRequestDTO bloodRequestDTO);

    // ------------------------------ Revoke blood request -------------------------------------
    boolean revokeBloodRequest(long userId);

    // -------------------------- Accept blood request -----------------------------------------------
    boolean acceptBloodRequest(long bloodRequestId);

    // ------------------------------ Get list of all blood request for a particular bank -----------------------
    List<BloodRequestDTO> getAllBloodRequests(long bankId);
}
