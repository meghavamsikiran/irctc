package com.irctc.io;

import com.irctc.dao.*;
import com.irctc.dto.*;
import com.irctc.exception.*;
import com.irctc.service.*;

import java.sql.*;
import java.util.*;

public class TrainManagement {
    public static void main(String[] args) throws SQLException, TrainNumberNotExistException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Add Train");
        System.out.println("2. FindTrainByNumber");
        System.out.println("3. Find train by source and destination");
        System.out.println("4. Get all running trains details.");
        System.out.println("5. Delete a train");
        System.out.println("6. Update train details by train number: ");
        System.out.println("Enter Choice: ");
        int ch = sc.nextInt();

        switch(ch) {
            case 1:
                    addTrain();
                break;
            case 2:
                    findTrainByNumber();
                break;
            case 3:
                findTrainBySourceAndDestination();
                break;
            case 4:
                getAllTrains();
                break;
            case 5:
                    deleteTrainByNumber();
                break;
            case 6: updateTrainByNumber();
                break;
            default:
                System.out.println("Invalid Input!");
                break;
        }
    }

    public static void addTrain() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter train number: ");
        int trainNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter train name: ");
        String trainName = sc.nextLine();
        System.out.println("Enter route number: ");
        int routeNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter source station: ");
        String source = sc.nextLine();
        System.out.println("Enter destination station: ");
        String destination = sc.nextLine();
        System.out.println("Enter distance: ");
        int distance = sc.nextInt();
        System.out.println("Enter duration: ");
        int duration = sc.nextInt();
        TrainDto trainDto = new TrainDto();
        trainDto.setTrainNumber(trainNumber);
        trainDto.setTrainName(trainName);
        trainDto.setRouteNumber(routeNumber);
        trainDto.setSource(source);
        trainDto.setDestination(destination);
        trainDto.setDistance(distance);
        trainDto.setDuration(duration);
        TrainService traineService = new TrainServiceImpl();
        traineService.addTrain(trainDto);
    }

    public static void findTrainByNumber() throws TrainNumberNotExistException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter train number you want to find: ");
        int trainNumber = sc.nextInt();
        TrainService traineService = new TrainServiceImpl();

        System.out.println(traineService.findTrainByNumber(trainNumber));
    }

    public static void findTrainBySourceAndDestination() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter train source: ");
        String source = sc.nextLine();
        System.out.println("Enter train destination: ");
        String destination = sc.nextLine();
        TrainService trainService = new TrainServiceImpl();
        List<TrainDto> list = trainService.findTrainBySourceAndDestination(source, destination);
        if(list.size()>0)
        {
            for(TrainDto trainDto: list)
            {
                System.out.println(trainDto);
            }
        }
        else
        {
            System.out.println("No Trains Found!");
        }
    }

    public static void getAllTrains() throws SQLException {
        TrainService trainService = new TrainServiceImpl();
        List<TrainDto> trainDtoList = trainService.getAllTrains();
        for(TrainDto trainDto : trainDtoList)
        {
            System.out.println(trainDto);
        }
    }
    public static void deleteTrainByNumber() throws SQLException, TrainNumberNotExistException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter trainNumber");
        int trainNumber = sc.nextInt();

        TrainService trainService = new TrainServiceImpl();
        System.out.println(trainService.deleteTrainByNumber(trainNumber));
    }

    public static void updateTrainByNumber() throws SQLException, TrainNumberNotExistException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter trainNumber: ");
        int trainNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new Source station: ");
        String source = sc.nextLine();
        System.out.println("Enter new destination: ");
        String destination = sc.nextLine();
        TrainService trainService = new TrainServiceImpl();
        TrainDto oldDetails = trainService.findTrainByNumber(trainNumber);
        oldDetails.setSource(source);
        oldDetails.setDestination(destination);
        int result = trainService.updateTrainByNumber(oldDetails);
        if(result>0)
        {
            System.out.println("Train details updated successfully!");
        }
        else {
            System.out.println("Failed to update train details.");
        }
    }
}
