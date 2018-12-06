package com.qa.callum.one.Presidents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class President {

	private String name;
	private Date birthDate;
	private String birthPlace;
	private Date deathDate;
	private String deathPlace;

	public President(String name, String birthDate, String birthPlace, String deathDate, String deathPlace) {
		this.name = name;
		this.birthDate = parseDate(birthDate);
		this.birthPlace = birthPlace;
		if (deathDate != null) {
			this.deathDate = parseDate(deathDate);
		}
		this.deathPlace = deathPlace;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public Date parseDate(String stringDate) {
		Date newDate = null;

		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

		String[] dateBits = stringDate.split(" ");

		String month = dateBits[0].substring(1, dateBits[2].length());
		month = monthToNum(month);
		String year = dateBits[2];
		String day = dateBits[1];

		stringDate = month + "-" + day + "-" + year;
		try {
			newDate = format.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}

	public String monthToNum(String month) {
		switch (month) {
		case "Jan":
			return "01";
		case "Feb":
			return "02";
		case "Mar":
			return "03";
		case "Apr":
			return "04";
		case "May":
			return "05";
		case "Jun":
			return "06";
		case "Jul":
			return "07";
		case "Aug":
			return "08";
		case "Sep":
			return "09";
		case "Oct":
			return "10";
		case "Nov":
			return "11";
		case "Dec":
			return "12";
		default:
			return "errror";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathPlace() {
		return deathPlace;
	}

	public void setDeathPlace(String deathPlace) {
		this.deathPlace = deathPlace;
	}

}
