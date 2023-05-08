package com.dd.eraktkendrabackend.Repository;

import com.dd.eraktkendrabackend.Entity.BloodRequestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRequestRecordRepository extends JpaRepository<BloodRequestRecord, Long> {
}
