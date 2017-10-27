package edu.wit.dcsn.comp2000.queueapp;

import com.pearson.carrano.ArrayQueue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Station {

	static int currentID;
	int ID, passengerCount;
	ArrayQueue<Passenger> stationPassengers, InboundQueue, OutboundQueue;

	public Station() {
		ID = ++currentID;
	}

	public ArrayQueue<Passenger> getPassengers() {
		return stationPassengers;
	}

	public void setPassengerCount(int returningCount) {
		passengerCount = returningCount;
	}

	public int getDistanceToNext() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	public void addPassengerToStation(Passenger passenger) {
		stationPassengers.enqueue( passenger );
	}

	public void setStationPassengers( ArrayQueue<Passenger> stationPassengers ) {
		this.stationPassengers = stationPassengers;
	}

	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Station " + getID();
	}


	//two queues of inbound and outbound lines





}
