package com.dd.eraktkendrabackend.Repository;

import com.dd.eraktkendrabackend.Entity.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {
}
