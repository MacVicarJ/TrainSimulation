package edu.wit.dcsn.comp2000.queueapp;

public class Passenger {

	static int currentID;
    int ID, startStationID;

	/**
	 * True = Inbound
	 * False = Outbound
	 */
	private boolean direction;

	public Passenger(boolean dir) {
		this.direction = dir;
		ID = ++currentID;
	}

	public boolean getDirection() {
		return this.direction;
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
