package com.dd.eraktkendrabackend.Repository;

import com.dd.eraktkendrabackend.Entity.BloodDonationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BLoodDonationRequestRepository extends JpaRepository<BloodDonationRequest,Long> {

    BloodDonationRequest findByUser_UserId(long userId);

    List<BloodDonationRequest> findAllByBankId(long bankId);
}
