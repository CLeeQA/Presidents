package com.qa.callum.one.Presidents;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PresidentRecordKeeper {

	private final String FILENAME = "C:\\Users\\Admin\\Downloads\\presidents.txt";

	List<President> presidents = new ArrayList<President>();

	public void loadPres() {
		try {
			FileReader fr;
			fr = new FileReader(FILENAME);
			BufferedReader br = new BufferedReader(fr);
			boolean thing = true;

			do {
				String fileContent = br.readLine();
				if (fileContent == null) {
					thing = false;
					break;
				}
				String[] content = null;
				content = fileContent.split(",");

				String name = content[0];
				String birth_date = content[1];
				String birth_place = content[2];
				String death_date = "\tDec 31 2069";
				String death_place = "\tDec 31 2069";
				if (!content[3].equals("\t")) {
					death_date = content[3];
					death_place = content[4];
				}
				if (name.equals("PRESIDENT")) {
					continue;
				}
				President pres = new President(name, birth_date, birth_place, death_date, death_place);
				presidents.add(pres);

			} while (thing);

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String presAlive() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Calendar myCalendar = Calendar.getInstance();
		Calendar compareCalendar = Calendar.getInstance();
		
		
		//GET ALL BIRTHS AND DEATHS
		//iterate
		
		ArrayList<Date> importantDates = new ArrayList<Date>();
		for(President p : presidents)
		{
			importantDates.add(p.getBirthDate());
		}
		for(President p : presidents)
		{
			importantDates.add(p.getDeathDate());
		}
	
		int presCounter = 1;
		
		Date bestYear = null;
		int mostPresses = 0;
		
		for(int i = 0; i < importantDates.size(); i++)
		{
			myCalendar.setTime(importantDates.get(i));
			myCalendar.add(Calendar.SECOND, 1);
			presCounter = 0;
			for (President p : presidents) {
				compareCalendar.setTime(p.getBirthDate());
				if (p.getBirthDate().before(myCalendar.getTime()) && p.getDeathDate().after(myCalendar.getTime())) {
					presCounter++;
				}
			}
			
			if(presCounter > mostPresses)
			{
				mostPresses = presCounter;
				bestYear = myCalendar.getTime();
			}
		}
		
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	    return "The most presidents were alive during the year: " + yearFormat.format(bestYear) + " with "+ mostPresses + " alive at the time.";
	}
	
	public void printPresidents()
	{
		presidents.stream().forEach(System.out::println);
	}
}
