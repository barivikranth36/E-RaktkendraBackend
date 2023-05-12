package com.dd.eraktkendrabackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseFieldWorker {

    private String jwtToken;

    private FieldWorkerDTO fieldWorkerDTO;
}
