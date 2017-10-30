package edu.wit.dcsn.comp2000.queueapp;

import java.io.PrintWriter;

public class Train extends TrainRoute {

    private int capacity;
    private int direction;
    private int speed;
    private int id;

    public Train(int capacity, int direction, int speed, int id) {
        this.capacity = capacity;
        this.direction = direction;
        this.speed = speed;
        this.id = id;

    }

    public boolean trainStop(){

        for(Tracks track : tracks) {
            track.cancelMoved();
        }
        return true;



    }

    public boolean trainStart(){
        if(closeDoor()) {
            disembarkPassengers();
            boardPassengers();
            move();
            return true;

        }

        return false;
    }

    public boolean openDoor(){
        if(trainStop()){
            disembarkPassengers();
            boardPassengers();
            return true;

        }

        return false;
    }

    public boolean closeDoor(){
        openDoor();
        trainStart();

        return true;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public int getId() {
        return id;
    }
}