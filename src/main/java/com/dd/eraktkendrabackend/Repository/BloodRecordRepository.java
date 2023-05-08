package com.dd.eraktkendrabackend.Repository;

import com.dd.eraktkendrabackend.Entity.BloodRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodRecordRepository extends JpaRepository<BloodRecord, Long> {

    BloodRecord findBloodRecordByBloodBank_BloodBankIdAndAndBloodType(long bloodBankId, String bloodType);

    List<BloodRecord> findAllByBloodBank_BloodBankId(long bloodBankId);
}
