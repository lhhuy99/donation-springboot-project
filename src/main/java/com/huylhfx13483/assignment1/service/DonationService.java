package com.huylhfx13483.assignment1.service;

import java.util.List;

import com.huylhfx13483.assignment1.entity.Donation;

public interface DonationService {

	public List<Donation> getDonations();

	public Donation saveDonation(Donation theDonation);

	public Donation getDonationById(int theId);
}
