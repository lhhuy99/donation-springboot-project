package com.huylhfx13483.assignment1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huylhfx13483.assignment1.entity.Donation;
import com.huylhfx13483.assignment1.entity.UserDonation;
import com.huylhfx13483.assignment1.repository.UserDonationRepository;

@Service
public class UserDonationServiceImpl implements UserDonationService {

	@Autowired
	private UserDonationRepository userDonationRepository;

	@Override
	public List<UserDonation> getUserDonations() {
		return userDonationRepository.findAll();
	}

	@Override
	public UserDonation saveUserDonation(UserDonation theUserDonation) {
		return userDonationRepository.save(theUserDonation);
	}

	@Override
	public UserDonation getUserDonationById(int theId) {
		Optional<UserDonation> result = userDonationRepository.findById(theId);
		
		UserDonation userDonation = null;
		if (result.isPresent()) {
			userDonation = result.get();
		} else {
			throw new RuntimeException("Did not find user donation id - " + theId);
		}
		
		
		return userDonation;
	}

	@Override
	public List<UserDonation> getUserDonationsByDonation(Donation theDonation) {
		
		return userDonationRepository.findByDonation(theDonation);
	}
}
