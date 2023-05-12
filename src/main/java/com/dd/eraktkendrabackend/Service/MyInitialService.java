package com.dd.eraktkendrabackend.Service;

import com.dd.eraktkendrabackend.DTO.FieldWorkerDTO;
import com.dd.eraktkendrabackend.DTO.InitialUserDetailsDTO;
import com.dd.eraktkendrabackend.DTO.JwtRequest;

public interface MyInitialService {

    // -------------------------- get user details ------------------------------------
    InitialUserDetailsDTO getUser(JwtRequest jwtRequest);

    // ----------------------- Get field worker details ---------------------------------
    FieldWorkerDTO getFieldWorker(JwtRequest jwtRequest);
}
