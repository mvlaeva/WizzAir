package com.example.model;

import com.example.model.exceptions.PassangerException;

public class Passanger {
	private String firstName;
	private String lastName;
	private Gender gender;
	private CabinBaggage cabinBaggage;
	private ChechedInBaggage checkedInBaggage;
	private boolean sportsEquipment;
	private boolean isOnlineCheckIn;
	private String seat;

	public Passanger(String firstName, String lastName, Gender gender, CabinBaggage cabinBaggage,
			ChechedInBaggage checkedInBaggage, boolean sportsEquipment, boolean isOnlineCheckIn, String seat) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.cabinBaggage = cabinBaggage;
		this.checkedInBaggage = checkedInBaggage;
		this.sportsEquipment = sportsEquipment;
		this.isOnlineCheckIn = isOnlineCheckIn;
		this.seat = seat;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws PassangerException {
		if (firstName != null && firstName.trim().length() > 0)
			this.firstName = firstName;
		else
			throw new PassangerException("Invaid first name.");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws PassangerException {
		if (Utility.isValidString(lastName))
			this.lastName = lastName;
		else
			throw new PassangerException("Invaid last name.");
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public CabinBaggage getCabinBaggage() {
		return cabinBaggage;
	}

	public void setCabinBaggage(CabinBaggage cabinBaggage) {
		this.cabinBaggage = cabinBaggage;
	}

	public ChechedInBaggage getCheckedInBaggage() {
		return checkedInBaggage;
	}

	public void setCheckedInBaggage(ChechedInBaggage checkedInBaggage) {
		this.checkedInBaggage = checkedInBaggage;
	}

	public boolean isSportsEquipment() {
		return sportsEquipment;
	}

	public void setSportsEquipment(boolean sportsEquipment) {
		this.sportsEquipment = sportsEquipment;
	}

	public boolean isOnlineCheckIn() {
		return isOnlineCheckIn;
	}

	public void setOnlineCheckIn(boolean isOnlineCheckIn) {
		this.isOnlineCheckIn = isOnlineCheckIn;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) throws PassangerException {
		if (Utility.isValidString(seat))
			this.seat = seat;
		else
			throw new PassangerException("Invalid seat.");
	}

	@Override
	public String toString() {
		return "Passanger [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", cabinBaggage="
				+ cabinBaggage + ", checkedInBaggage=" + checkedInBaggage + ", sportsEquipment=" + sportsEquipment
				+ ", isOnlineCheckIn=" + isOnlineCheckIn + ", seat=" + seat + "]";
	}
}
