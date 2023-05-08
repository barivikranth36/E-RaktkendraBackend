package com.dd.eraktkendrabackend.Controller;

import com.dd.eraktkendrabackend.DTO.FieldWorkerDTO;
import com.dd.eraktkendrabackend.DTO.LoginDTO;
import com.dd.eraktkendrabackend.Service.FieldWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class FieldWorkerController {
    @Autowired
    private FieldWorkerService fieldWorkerService;

    // ----------------------------- Register Field Worker -------------------------------------
    @PostMapping("/registerFieldWorker")
    public FieldWorkerDTO registerFieldWorker(@RequestBody FieldWorkerDTO fieldWorkerDTO) {
        return fieldWorkerService.registerFieldWorker(fieldWorkerDTO);
    }

    //------------------------------------------------ worker login ----------------------------------------------------
    @GetMapping("/workerLogin")
    public FieldWorkerDTO fieldWorkerLogin(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO.toString());
        FieldWorkerDTO fieldWorkerDTO = fieldWorkerService.fieldWorkerLogin(loginDTO);
        return fieldWorkerDTO;
//        return workerService.workerLogin(loginDTO);
    }
}
