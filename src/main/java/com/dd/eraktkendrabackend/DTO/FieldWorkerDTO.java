package com.dd.eraktkendrabackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldWorkerDTO {

    private long workerId;

    private String title;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String gender;

    private String phoneNumber;

    private String emailId;

    private String address;

    private String city;

    private String password;

    private long pincode;

    private long bloodBankId;

    // ---------------------------------- Constructor ------------------------------------------

    public FieldWorkerDTO(long workerId, String title, String firstName, String lastName, Date dob, String gender, String phoneNumber, String emailId, String address, String city, long pincode, long bloodBankId) {
        this.workerId = workerId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.bloodBankId = bloodBankId;
    }
}
