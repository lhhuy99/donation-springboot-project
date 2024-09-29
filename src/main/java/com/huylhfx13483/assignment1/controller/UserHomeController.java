package com.huylhfx13483.assignment1.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huylhfx13483.assignment1.dto.UserDonationDto;
import com.huylhfx13483.assignment1.entity.Donation;
import com.huylhfx13483.assignment1.entity.UserDonation;
import com.huylhfx13483.assignment1.service.DonationService;

@Controller
@RequestMapping("/userHomePage")
public class UserHomeController {
	
	@Autowired
	private DonationService donationService;

	@GetMapping("/home")
	public String showUserHome(Model theModel) {
		
		List<Donation> donations = donationService.getDonations();
		
		theModel.addAttribute("categories", donations);
		// add userDonation vao model de phuc vu viec quyen gop
		theModel.addAttribute("userDonation", new UserDonation());
		
		return "public/home";
	}
	
	@PostMapping("/donate/{id}")
	public String donate(@PathVariable("id") int theId, @ModelAttribute("userDonation") UserDonationDto userDonation) {
		
		Donation donation = donationService.getDonationById(theId);
		
		// Dinh dang ngay thang theo yyyy-MM-dd
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        // Set thoi gian hien tai khi luu userDonation vao list cua Donation
        UserDonation userDonationEntityDonation = new UserDonation();
        String currentDate = dateFormat.format(new Date());
        userDonationEntityDonation.setCreatedDate(currentDate);
		
        // Them so tien quyen gop cua user vao tong so tien quyen gop cua donation
        int totalMoney = donation.getMoney();
        donation.setMoney(totalMoney + userDonation.getMoney());
        
        // Set cac field cua userDonationEntityDonation sau khi dung UserDonationDto userDonation de hung
        // Dung UserDonationDto sau do set qua UserDonation de tranh truong hop no gan id tu url vao UserDonation
        // Neu co id no se update chu khong add them vao
        userDonationEntityDonation.setName(userDonation.getName());
        userDonationEntityDonation.setMoney(userDonation.getMoney());
        userDonationEntityDonation.setText(userDonation.getText());
        
        // Them userDonation vao list cua Donation trong moi quan he bi-directional
        donation.add(userDonationEntityDonation);
        
        // Luu donation ve database
        donationService.saveDonation(donation);
        
		return "redirect:/userHomePage/home";
	}
	
}
