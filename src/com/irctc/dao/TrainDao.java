package com.irctc.dao;

import com.irctc.dto.*;
import com.irctc.exception.*;

import java.sql.*;
import java.util.*;

public interface TrainDao {

    public int addTrain(TrainDto train) throws SQLException;
    public TrainDto findTrainByNumber(int trainNumber) ;
    public List<TrainDto> findTrainBySourceAndDestination(String source, String destination);
    public List<TrainDto> getAllTrains() throws SQLException;
    public int deleteTrainByNumber(int trainNumber) throws SQLException;
    public int updateTrainByNumber(TrainDto trainDto) throws SQLException;
}
