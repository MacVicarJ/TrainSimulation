package edu.wit.dcsn.comp2000.queueapp;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.pearson.carrano.ArrayQueue;

public class TrainRoute {
	//train route contains train tracks and stations list
	private ArrayList<Station> stations;
	private int stationCount;
	private ArrayList<Tracks> tracks;


	public TrainRoute(ArrayList<Station> stations, ArrayList<Train> trains){
		this.stations = new ArrayList<Station>();
		this.stations = stations;
		tracks = setUpTracks(stations);
		tracks = setUpTrains(tracks, trains);
		stationCount = stations.size();
	}
	
	public void disembarkPassengers(PrintWriter writer) {
		for(Tracks track : tracks) {
			//check if train is boarding
			if (track.getStatus().equalsIgnoreCase("boarding")) {
				//current position of the train
				writer.println("Train is at station: " + track.getStation().getStationName());
				writer.println("Doors opening... Passengers getting off...");
				//passenger ending stationID
				int endStationID = track.getStation().getStationID();
				//take off passenger from the train
				track.getTrain().disembarkPassengers(endStationID, writer);
			}
		}
	}
	
	public void boardPassengers(PrintWriter writer) {
		int returningCount = 0;

		for(Tracks track : tracks) {
			if (track.getStatus().equalsIgnoreCase("boarding")) {
				writer.println("Boarding Passengers...");
				//get the station
				Station station = track.getStation();
				//get passengers in current sataion
				ArrayQueue<Passenger> passengers = station.getPassengers();
				ArrayQueue<Passenger> passengersAtStation = new ArrayQueue<Passenger>();
				Train train = track.getTrain();
				while(!passengers.isEmpty()){
					Passenger passenger = passengers.dequeue();
					//if passenger at the station, add them to the train
					if (passenger.getStartStationID() == station.getStationID()){
						writer.println("Passenger " + passenger.getName() + " boarded train");
						train.addPassengerToTrain(passenger);
					} else {
						returningCount++;
						passengersAtStation.enqueue(passenger);
					}
				}
				//passenger at the station
				station.setStationPassengers(passengersAtStation);
				station.setPassengerCount(returningCount);
				//current boarding station
				track.setStation(station);
				//set train
				track.setTrain(train);
				writer.println("Closing Doors...");
			}
		}
		
	}
	
	public void move() {
		//stop trains
		for(Tracks track : tracks) {
			track.cancelMoved();
		}
		for(int i = 0; i < tracks.size(); i++) {
			Tracks track = tracks.get(i);
			if((track.getStatus() == "Train" || track.getStatus() == "Boarding") && track.moved() == false) {
				Train train = track.getTrain();
				//get direction of the train
				String direction = train.getDirection();
				//remove train from the track and station
				track.removeTrain();
				//train moving forward
				if(direction.equalsIgnoreCase("forwards")){
					if(i == tracks.size() - 1) {
						tracks.get(0).setTrain(train);
						tracks = moveUntilNoTrain(tracks, train, "forwards", 0);
					} else{
						tracks = moveUntilNoTrain(tracks, train, "forwards", i + 1);
					}
				} else if (direction.equalsIgnoreCase("backwards")) {
					if(i == 0) {
						tracks = moveUntilNoTrain(tracks, train, "forwards", tracks.size() - 1);
					} else{
						tracks = moveUntilNoTrain(tracks, train, "forwards", i - 1);
					}
				}
			}
		}
		for(Tracks track : tracks) {
			track.cancelMoved();
		}
	}
	
	private ArrayList<Tracks> moveUntilNoTrain(ArrayList<Tracks> tracks, Train train, String direction, int position) {
		//if the train satus is forward,
		if(direction.equalsIgnoreCase("forwards")) {
			for(position = position; position < tracks.size(); position++) {
				if(tracks.get(position).getStatus() != "Boarding" || tracks.get(position).getStatus() != "Train") {
					tracks.get(position).setTrain(train);
					return tracks;
				} 
				if(position == tracks.size()){
					position = 0;
				}
			}
		}
		//if the status is backward
		else if (direction.equalsIgnoreCase("backwards")) {
			for(position = position; position < tracks.size(); position--) {
				if(tracks.get(position).getStatus() != "Boarding" || tracks.get(position).getStatus() != "Train") {
					tracks.get(position).setTrain(train);
					return tracks;
				} 
				if(position == 0){
					position = tracks.size();
				}
			}
		}
		return null;
	}

	public void printRouteStatus(){
		for(Tracks track : tracks) {
			System.out.println(track.getStatus());
		}
	}
	//set up trains in teh tracks
	private ArrayList<Tracks> setUpTrains(ArrayList<Tracks> tracks, ArrayList<Train> trains) {
		for(Tracks track : tracks) {
			//if no train in the track, set train
			if(track.getStatus() == "Empty" && !trains.isEmpty()) {
				Train train = trains.get(0);
				track.setTrain(train);
				trains.remove(0);
			}
		}
		return tracks;
	}

	private ArrayList<Tracks> setUpTracks(ArrayList<Station> stations) {
		ArrayList<Tracks> tracks = new ArrayList<Tracks>();
		int trackID = 0;
		int distanceToNext = 0;
		int move = 0;
		//connect stations to station tracks
		for(Station station : stations) {
			tracks.add(new Tracks(trackID));
			tracks.get(trackID).setStation(station);
			distanceToNext = station.getDistanceToNext();
			trackID++;
			for(move = 0; move < distanceToNext; move = move + 100) {
				tracks.add(new Tracks(trackID));
				trackID++;
			}
		}
		return tracks;
	}
	//list of passengers boarding from the station
	public boolean addPassengerToStation(Passenger passenger, int stationID) {
		boolean added = false;
		for (Tracks track : tracks) {
			if(track.getStatus() == "Station") {
				Station station = track.getStation();
				if(station.getStationID() == stationID){
					station.addPassengerToStation(passenger);
					track.setStation(station);
				}
			}
		}
		return added;
	}

	public void check() {
		for(Tracks track : tracks) {
			if(track.getStatus().equals("Boarding") || track.getStatus().equals("Station")){
				System.out.println("Current Passengers at: " + track.getStation().getStationName() + " is " + track.getStation().getPassengerCount());
			}
		}
	}
}
