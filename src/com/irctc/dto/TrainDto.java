package com.irctc.dto;

public class TrainDto {
    private int trainNumber;
    private String trainName;
    private int routeNumber;
    private String source;
    private String destination;
    private int distance;
    private int duration;

    public TrainDto()
    {

    }

    public TrainDto(int trainNumber, String trainName, int routeNumber, String source, String destination, int distance, int duration) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.routeNumber = routeNumber;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.duration = duration;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "TrainDetails{" +
                "trainNumber=" + trainNumber +
                ", trainName='" + trainName + '\'' +
                ", routeNumber=" + routeNumber +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", duration=" + duration +
                '}';
    }
}
