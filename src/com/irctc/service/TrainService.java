package com.irctc.service;

import com.irctc.dto.*;
import com.irctc.exception.*;

import java.sql.*;
import java.util.*;

public interface TrainService {
    public int addTrain(TrainDto train) throws SQLException;
    public TrainDto findTrainByNumber(int trainNumber) throws TrainNumberNotExistException;
    public List<TrainDto> findTrainBySourceAndDestination(String source, String destination);
    public List<TrainDto> getAllTrains() throws SQLException;
    public String deleteTrainByNumber(int trainNumber) throws SQLException, TrainNumberNotExistException;
    public int updateTrainByNumber(TrainDto trainDto) throws SQLException;
}
