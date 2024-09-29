package com.huylhfx13483.assignment1.service;

import java.util.List;

import com.huylhfx13483.assignment1.entity.Donation;
import com.huylhfx13483.assignment1.entity.UserDonation;

public interface UserDonationService {
	public List<UserDonation> getUserDonations();

	public UserDonation saveUserDonation(UserDonation theUserDonation);

	public UserDonation getUserDonationById(int theId);
	
	public List<UserDonation> getUserDonationsByDonation(Donation theDonation);
}
