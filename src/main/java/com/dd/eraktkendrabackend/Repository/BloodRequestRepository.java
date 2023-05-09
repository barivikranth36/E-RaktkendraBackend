package com.dd.eraktkendrabackend.Repository;

import com.dd.eraktkendrabackend.Entity.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {
    BloodRequest findBloodRequestByUser_UserId(long userId);

    List<BloodRequest> findAllByBloodBank_BloodBankId(long bankId);
}
