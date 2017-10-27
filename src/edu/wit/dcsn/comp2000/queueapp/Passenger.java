package edu.wit.dcsn.comp2000.queueapp;

public class Passenger {

	static int currentID;
    int ID, startStationID;

	public Passenger() {
		ID = ++currentID;
	}

	public int getStartStationID() {
		return startStationID;
	}

	public int getID() {
		return ID;
	}
	
	@Override
	public String toString() {
		return "Passenger " + getID();
	}

}
