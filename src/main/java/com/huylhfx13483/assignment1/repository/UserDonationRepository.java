package com.huylhfx13483.assignment1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huylhfx13483.assignment1.entity.Donation;
import com.huylhfx13483.assignment1.entity.UserDonation;

@Repository
public interface UserDonationRepository extends JpaRepository<UserDonation, Integer> {
	List<UserDonation> findByDonation(Donation theDonation);
}
