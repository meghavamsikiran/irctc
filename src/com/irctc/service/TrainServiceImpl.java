package com.irctc.service;

import com.irctc.dao.*;
import com.irctc.dto.*;
import com.irctc.exception.*;

import java.sql.*;
import java.util.*;

public class TrainServiceImpl implements TrainService {

    private TrainDao trainDao;
    @Override
    public int addTrain(TrainDto trainDto) throws SQLException {
        trainDao = new TrainDaoImpl();
        int result = trainDao.addTrain(trainDto);
        return result;
    }

    @Override
    public TrainDto findTrainByNumber(int trainNumber) throws TrainNumberNotExistException {
        trainDao = new TrainDaoImpl();
    TrainDto trainDto = trainDao.findTrainByNumber(trainNumber);
    if(trainDto==null)
    {
        throw new TrainNumberNotExistException("train number is not exist in the db");
    }
    return trainDto;
    }

    @Override
    public List<TrainDto> findTrainBySourceAndDestination(String source, String destination) {
        trainDao = new TrainDaoImpl();
        return trainDao.findTrainBySourceAndDestination(source, destination);
    }

    @Override
    public List<TrainDto> getAllTrains() throws SQLException {
        trainDao = new TrainDaoImpl();
        return trainDao.getAllTrains();
    }

    @Override
    public String deleteTrainByNumber(int trainNumber) throws SQLException, TrainNumberNotExistException {
        trainDao = new TrainDaoImpl();
        String success = "Train Deleted Successfully!";
        String failed = "Failed to delete train!";

        if(trainDao.deleteTrainByNumber(trainNumber)==0)
        {
            throw new TrainNumberNotExistException("No train with that trainId found!");
        }
        return success;
    }

    @Override
    public int updateTrainByNumber(TrainDto trainDto) throws SQLException {
        trainDao = new TrainDaoImpl();
        int result = trainDao.updateTrainByNumber(trainDto);

        return result;
    }
}
