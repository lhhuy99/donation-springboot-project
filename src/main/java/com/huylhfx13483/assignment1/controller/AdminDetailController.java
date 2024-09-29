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

@Controller
@RequestMapping("/adminDetailPage")
public class AdminDetailController {

	@Autowired
	private DonationService donationService;

	@RequestMapping("/detail/{id}")
	public String showDetail(@PathVariable("id") int theId, Model theModel) {

		// get donation from database
		Donation theDonation = donationService.getDonationById(theId);
		
		// get user donations of chosen donation
		List<UserDonation> userDonations = theDonation.getUserDonations();

		theModel.addAttribute("donationDetail", theDonation);
		theModel.addAttribute("userDonations", userDonations);

		return "admin/detail";
	}
	
	
}
