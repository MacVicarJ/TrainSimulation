package edu.wit.dcsn.comp2000.queueapp;
//my class
//-Roman
import java.io.File;
import java.io.FileWriter;
import java.io.FileIOException;

public class Logger{
	public void toStringPassenger(Passenger passenger) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Passenger ID: ", passenger.ID);
	}
	public void toStringTrain(Train train) throws IOException{
		java.io.File file = new java.io.File("TrainSimulation.log");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print("Train ID: ", train.ID);
	}
	
}

