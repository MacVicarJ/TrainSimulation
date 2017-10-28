package edu.wit.dcsn.comp2000.queueapp;
import java.io.IOException;
import java.io.File;


public class Logger{
	public void toStringNewPassenger(Passenger passenger, Station station) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Passenger "+ passenger.getID());
		output.println(" enters platform at station"+station.getID());
	}
	public void toStringBoardingPassenger(Passenger passenger, Station station, Train train) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Passenger "+ passenger.getID());
		output.print(" boards train "+ train.getID());
		output.println(" at station "+ station.getID());
	}
	public void toStringPassengerArrival(Passenger passenger, Station station, Train train) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Passenger "+ passenger.getID());
		output.print(" leaves train "+ train.getID());
		output.println(" at station "+ station.getID());
	}
	public void toStringTrainArrival(Train train, Station station) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Train "+ train.getID());
		output.println(" Arrives at Station "+station.getID());
	}
	public void toStringTrainDeparture(Train train, Station station) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Train "+ train.ID);
		output.println(" Departs from Station "+station.getID());
	}
	
}

