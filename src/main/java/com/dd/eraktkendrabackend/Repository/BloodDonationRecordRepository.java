package com.dd.eraktkendrabackend.Repository;


import com.dd.eraktkendrabackend.Entity.BloodDonationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodDonationRecordRepository extends JpaRepository<BloodDonationRecord, Long> {

    List<BloodDonationRecord> findAllByUser_UserId(long userId);
}
