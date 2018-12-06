package com.qa.callum.one.Presidents;

public class Main {

	public static void main(String[] args) {

		PresidentRecordKeeper prk = new PresidentRecordKeeper();
		
		prk.loadPres();
		
		System.out.println(prk.presAlive());
		
	}

}
