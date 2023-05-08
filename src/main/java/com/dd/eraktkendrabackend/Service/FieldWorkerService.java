package com.dd.eraktkendrabackend.Service;

import com.dd.eraktkendrabackend.DTO.FieldWorkerDTO;
import com.dd.eraktkendrabackend.DTO.LoginDTO;

public interface FieldWorkerService {

    FieldWorkerDTO registerFieldWorker(FieldWorkerDTO fieldWorkerDTO);
    FieldWorkerDTO fieldWorkerLogin(LoginDTO loginDTO);
}
