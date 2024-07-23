package com.irctc.dao;

import com.irctc.config.*;
import com.irctc.dto.*;
import com.irctc.exception.*;

import java.sql.*;
import java.util.*;

public class TrainDaoImpl implements TrainDao {
    @Override
    public int addTrain(TrainDto trainDto) throws SQLException {
        Connection connection = DBConnectionUtil.establishConnection();
        PreparedStatement pstmt = connection.prepareStatement("insert into traindetails values(?, ?, ?, ?, ?, ?, ?)");
        pstmt.setInt(1, trainDto.getTrainNumber());
        pstmt.setString(2, trainDto.getTrainName());
        pstmt.setInt(3, trainDto.getRouteNumber());
        pstmt.setString(4, trainDto.getSource());
        pstmt.setString(5, trainDto.getDestination());
        pstmt.setInt(6, trainDto.getDistance());
        pstmt.setInt(7, trainDto.getDuration());
        int status = pstmt.executeUpdate();
        if (status != 0) {
            System.out.println("Train Details Added Successfully!");
        } else {
            System.out.println("Failed to Add Train Details!");
        }

        return status;
    }

    @Override
    public TrainDto findTrainByNumber(int trainNumber)  {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        TrainDto trainDto = null;

        try {
            connection = DBConnectionUtil.establishConnection();
            pstmt = connection.prepareStatement("select * from traindetails where trainnumber=?");
            pstmt.setInt(1, trainNumber);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                trainDto = new TrainDto();
                trainDto.setTrainNumber(resultSet.getInt(1));
                trainDto.setTrainName(resultSet.getString(2));
                trainDto.setRouteNumber(resultSet.getInt(3));
                trainDto.setSource(resultSet.getString(4));
                trainDto.setDestination(resultSet.getString(5));
                trainDto.setDistance(resultSet.getInt(6));
                trainDto.setDuration(resultSet.getInt(7));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return trainDto;
    }

    @Override
    public List<TrainDto> findTrainBySourceAndDestination(String source, String destination) {
        Connection connection= null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        TrainDto trainDto = null;
        List<TrainDto> trainDtoList = new ArrayList<>();
        try {
            connection = DBConnectionUtil.establishConnection();
            pstmt = connection.prepareStatement("select * from traindetails where source=? and destination=?");
            pstmt.setString(1, source);
            pstmt.setString(2, destination);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()) {
                trainDto = new TrainDto();
                trainDto.setTrainNumber(resultSet.getInt(1));
                trainDto.setTrainName(resultSet.getString(2));
                trainDto.setRouteNumber(resultSet.getInt(3));
                trainDto.setSource(resultSet.getString(4));
                trainDto.setDestination(resultSet.getString(5));
                trainDto.setDistance(resultSet.getInt(6));
                trainDto.setDuration(resultSet.getInt(7));
                trainDtoList.add(trainDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trainDtoList;
    }

    @Override
    public List<TrainDto> getAllTrains() throws SQLException {
        Connection connection = DBConnectionUtil.establishConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from traindetails");
        List<TrainDto> trainDtoList = new ArrayList<>();
        while(rs.next())
        {
            TrainDto trainDto = new TrainDto();
            trainDto.setTrainNumber(rs.getInt(1));
            trainDto.setTrainName(rs.getString(2));
            trainDto.setRouteNumber(rs.getInt(3));
            trainDto.setSource(rs.getString(4));
            trainDto.setDestination(rs.getString(5));
            trainDto.setDistance(rs.getInt(6));
            trainDto.setDuration(rs.getInt(7));
            trainDtoList.add(trainDto);
        }
        return trainDtoList;
    }

    @Override
    public int deleteTrainByNumber(int trainNumber) throws SQLException {
        Connection connection = DBConnectionUtil.establishConnection();
        PreparedStatement pstmt = connection.prepareStatement("delete from traindetails where trainnumber=?");
        pstmt.setInt(1, trainNumber);
        int res = pstmt.executeUpdate();
        return res;
    }

    @Override
    public int updateTrainByNumber(TrainDto trainDto) throws SQLException {
        Connection connection = DBConnectionUtil.establishConnection();
        PreparedStatement pstmt = connection.prepareStatement("update traindetails set source=?, destination=? where trainnumber=?");
        pstmt.setString(1, trainDto.getSource());
        pstmt.setString(2, trainDto.getDestination());
        pstmt.setInt(3, trainDto.getTrainNumber());
        int result = pstmt.executeUpdate();

        return result;
    }
}
