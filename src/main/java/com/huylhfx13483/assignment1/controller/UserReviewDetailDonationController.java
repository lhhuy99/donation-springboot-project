package com.huylhfx13483.assignment1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huylhfx13483.assignment1.entity.Donation;
import com.huylhfx13483.assignment1.entity.UserDonation;
import com.huylhfx13483.assignment1.service.DonationService;
import com.huylhfx13483.assignment1.service.UserDonationService;

@Controller
@RequestMapping("/userReviewDetailDonation")
public class UserReviewDetailDonationController {
	
	@Autowired
	private DonationService donationService;
	
	@Autowired
	private UserDonationService userDonationService;
	
	@RequestMapping("/detail/{id}")
	public String showDetail(@PathVariable("id") int theId, Model theModel) {
		
		// get donation
		Donation donation = donationService.getDonationById(theId);
		
		// get user donations of chosen donation
		List<UserDonation> userDonations = userDonationService.getUserDonationsByDonation(donation);
		
		theModel.addAttribute("donation", donation);
		theModel.addAttribute("userDonations", userDonations);
		
		return "public/detail";
	}
}
