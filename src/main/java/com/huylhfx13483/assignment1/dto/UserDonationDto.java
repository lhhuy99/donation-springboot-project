package com.huylhfx13483.assignment1.dto;

public class UserDonationDto {

	private String createdDate;

	private Integer money;

	private String name;

	private Integer status;

	private String text;

	public UserDonationDto() {

	}

	public UserDonationDto(String createdDate , int money, String name, int status, String text) {
		this.createdDate = createdDate;
		this.money = money;
		this.name = name;
		this.status = status;
		this.text = text;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
