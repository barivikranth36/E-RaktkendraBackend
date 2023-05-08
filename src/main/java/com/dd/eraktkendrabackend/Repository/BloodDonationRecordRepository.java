package com.dd.eraktkendrabackend.Repository;


import com.dd.eraktkendrabackend.Entity.BloodDonationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodDonationRecordRepository extends JpaRepository<BloodDonationRecord, Long> {
}
