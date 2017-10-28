package edu.wit.dcsn.comp2000.queueapp;
//my class
//-Roman
import java.io.File;
import java.io.FileWriter;
import java.io.FileIOException;

public class Logger{
	public void toStringNewPassenger(Passenger passenger, Station station) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Passenger ", passenger.ID);
		output.println(" enters platform at station",station.ID)
	}
	public void toStringBoardingPassenger(Passenger passenger, Station station, Train train) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Passenger ", passenger.ID);
		output.print(" boards train ", train.ID);
		output.println(" at station ", station.ID);
	}
	public void toStringPassengerArrival(Passenger passenger, Station station, Train train) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Passenger ", passenger.ID);
		output.print(" leaves train ", train.ID);
		output.println(" at station ", station.ID);
	}
	public void toStringTrainArrival(Train train, Station station) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Train ", train.ID);
		output.println(" Arrives at Station ",station.ID);
	}
	public void toStringTrainDeparture(Train train, Station station) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Train ", train.ID);
		output.println(" Departs from Station ",station.ID);
	}
	
}

