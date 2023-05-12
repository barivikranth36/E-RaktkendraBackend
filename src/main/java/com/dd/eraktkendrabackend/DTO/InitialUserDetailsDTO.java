package com.dd.eraktkendrabackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitialUserDetailsDTO {

    private long userId;

    private String title;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String gender;

    private String phoneNumber;

    private String emailId;

    private String bloodType;

    private String address;

    private String city;

    private long pincode;

    private int credit;
}
