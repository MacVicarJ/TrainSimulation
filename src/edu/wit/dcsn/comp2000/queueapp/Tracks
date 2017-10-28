

public class Tracks {
	private String status;
	private Train train;
	private int trackID;
	private boolean moved;
	private Station station;
	
	public Tracks(int trackID){
		this.trackID = trackID;
		moved = false;
		status = "Empty";
	}
	
	public void cancelMoved() {
		moved = false;
	}
	
	public void setStation(Station station) {
		this.station = station;
		this.status = "Station";
	}
	
	public Station getStation() {
		return station;
	}
		
	public void setTrain(Train train) {
		this.train = train;
		this.moved = true;
		if(this.status == "Station" || this.status == "Boarding") {
			this.status = "Boarding";
		} else {
			this.status = "Train";
		}
		
	}
	
	public Train getTrain() {
		return train;
	}
	
	public void removeTrain() {
		this.train = null;
		if(this.status == "Station" || this.status == "Boarding") {
			this.status = "Station";
		} else {
			this.status = "Empty";
		}
	}
	
	public String getStatus() {
		return status;
	}
	
	public boolean moved(){
		return moved;
	}
	

}
