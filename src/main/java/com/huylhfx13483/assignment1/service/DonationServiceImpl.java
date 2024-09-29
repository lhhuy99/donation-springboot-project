package com.huylhfx13483.assignment1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huylhfx13483.assignment1.entity.Donation;
import com.huylhfx13483.assignment1.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationRepository donationRepository;

	@Override
	public List<Donation> getDonations() {
		return donationRepository.findAll();
	}

	@Override
	public Donation saveDonation(Donation theDonation) {
		return donationRepository.save(theDonation);
	}

	@Override
	public Donation getDonationById(int theId) {
		Optional<Donation> result = donationRepository.findById(theId);

		Donation donation = null;
		if (result.isPresent()) {
			donation = result.get();
		} else {
			throw new RuntimeException("Did not find donation id - " + theId);
		}

		return donation;
	}
}
