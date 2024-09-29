package com.huylhfx13483.assignment1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huylhfx13483.assignment1.entity.Donation;
import com.huylhfx13483.assignment1.service.DonationService;

@Controller
@RequestMapping("/adminDonationPage")
public class AdminDonationController {

	@Autowired
	private DonationService donationService;

	// donation management
	@GetMapping("/donations")
	public String listDonation(Model theModel) {

		// get donations from dao
		List<Donation> theDonations = donationService.getDonations();

		// add donations, saveDonation to model
		theModel.addAttribute("donations", theDonations);

		theModel.addAttribute("saveDonation", new Donation());

//			return "admin/donation";
		return "admin/donation";
	}

	@PostMapping("/saveDonation")
	public String saveDonation(@ModelAttribute("saveDonation") Donation theDonation) {

		// add donation
		donationService.saveDonation(theDonation);

		return "redirect:/adminDonationPage/donations";
	}

	@PostMapping("/changeStatus")
	public String changeStatus(@RequestParam("idD") int theId) {

		// Get the donation from database
		Donation theDonation = donationService.getDonationById(theId);

		// change status and save to database
		if (theDonation.getStatus() == 1) {
			theDonation.setStatus(2);
			donationService.saveDonation(theDonation);
		} else if (theDonation.getStatus() == 2) {
			theDonation.setStatus(3);
			donationService.saveDonation(theDonation);
		} else if (theDonation.getStatus() == 3) {
			theDonation.setStatus(4);
			donationService.saveDonation(theDonation);
		}

		return "redirect:/adminDonationPage/donations";
	}

	@PostMapping("/delete")
	public String deleteDonation(@RequestParam("idD") int theId) {

		// Get the donation from database
		Donation theDonation = donationService.getDonationById(theId);

		// if display == 1 donation will display on screen
		// if display != 1 hidden on screen
		if (theDonation.getDisplay() == 1) {
			theDonation.setDisplay(0);
			donationService.saveDonation(theDonation);
		}

		return "redirect:/adminDonationPage/donations";
	}

	@PostMapping("/updateDonation")
	public String updateDonation(@ModelAttribute("saveDonation") Donation theDonation, @RequestParam("id") int theId,
			Model theModel) {

		// Get the donation from database
		Donation tempDonation = donationService.getDonationById(theId);

		// Set id, money, status and display of theDonation from tempDonation
		theDonation.setId(tempDonation.getId());
		theDonation.setMoney(tempDonation.getMoney());
		theDonation.setStatus(tempDonation.getStatus());
		theDonation.setDisplay(tempDonation.getDisplay());

		// Save theDonation into database
		donationService.saveDonation(theDonation);

		return "redirect:/adminDonationPage/donations";
	}
}
