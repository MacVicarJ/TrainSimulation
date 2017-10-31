package edu.wit.dcsn.comp2000.queueapp;

import com.pearson.carrano.ArrayQueue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Station {

	static int currentID;
	int ID, passengerCount;
	ArrayQueue<Passenger> InboundPassengers, OutboundPassengers;


	public Station() {
		ID = ++currentID;
	}

	public ArrayQueue<Passenger> getInboundPassengers() {
		return InboundPassengers;
	}

	public ArrayQueue<Passenger> getOutboundPassengers() {
		return OutboundPassengers;
	}

	public void setPassengerCount(int returningCount) {
		passengerCount = returningCount;
	}

	public void addPassengerToStation(Passenger passenger) {
		if (passenger.getDirection()) {
            InboundPassengers.enqueue( passenger );
        } else {
		    OutboundPassengers.enqueue( passenger );
        }
	}

	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Station " + getID();
	}

}
