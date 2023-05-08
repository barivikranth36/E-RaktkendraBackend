package com.dd.eraktkendrabackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workerId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "emailId", nullable = false, unique = true)
    private String emailId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "pincode", nullable = false)
    private long pincode;

    //One to One Mapping of bloodBank
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bloodBankId", referencedColumnName = "bloodBankId")
    private BloodBank bloodBank;


    // ----------------------------------- Constructor -------------------------------------------------

    public FieldWorker(String title, String firstName, String lastName, Date dob, String gender, String phoneNumber, String emailId, String password, String address, String city, long pincode, BloodBank bloodBank) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.password = password;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.bloodBank = bloodBank;
    }
}
