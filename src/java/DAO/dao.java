/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Airport;
import Entity.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author phuoc
 */
public class dao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public void DeleteAirport(String sid) {
        String query = "delete from Airport where ID=?";
        try {
            conn = new ConnectDB().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
            
    }
    public void DeleteSchedule(String sid) {
        String query = "delete from [Schedule] where ID=?";
        try {
            conn = new ConnectDB().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
            
    }
    
    public void AddAirport(String name) {
        String query = "insert into Airport \n" +
        "values(?)";
        try {
            conn = new ConnectDB().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception e) {
        }
            
    }
    
    public void AddSchedule(String from_airport, String to_airport, String start_time, String end_time) {
        String query = "insert into [Schedule] values(?,?,?,?)";
        try {
            conn = new ConnectDB().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, from_airport);
            ps.setString(2, to_airport);
            ps.setString(3, start_time);
            ps.setString(4, end_time);
            ps.executeUpdate();
        } catch (Exception e) {
        }
            
    }
    public ArrayList<Airport> getAirport() {
        try {
            conn = new ConnectDB().connect();
            String sqlAirport = "SELECT * FROM Airport order by Name";
            PreparedStatement statementAirport = conn.prepareStatement(sqlAirport);
            ResultSet rsAirport = statementAirport.executeQuery();
            ArrayList<Airport> listAirport = new ArrayList<Airport>();
            while (rsAirport.next()) {
                Airport tmp = new Airport(rsAirport.getInt("ID"), rsAirport.getString("Name"));
                listAirport.add(tmp);
            }
            return listAirport;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    public ArrayList<Schedule> getSchedule() {
        try {
            conn = new ConnectDB().connect();
            String query = "SELECT * FROM Schedule";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Schedule> ls = new ArrayList<Schedule>();
            while (rs.next()) {
                Schedule tmp = new Schedule(rs.getInt("ID"), rs.getString("FromAirport"), rs.getString("ToAirport"),  rs.getString("TimeFrom"), rs.getString("TimeTo"));
                ls.add(tmp);
            }
            return ls;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    public Schedule getSchedulebyID(String ID) {
        try {
            conn = new ConnectDB().connect();
            String query = "SELECT * FROM Schedule where ID=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            //timefm = DateTimeFormatter.ofPattern("HH:mm:ss");
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            while (rs.next()) {
                String timefrom = parser.format(parser.parse(rs.getString("TimeFrom")));
                String timeto = parser.format(parser.parse(rs.getString("TimeTo")));
                System.out.println(rs.getString("TimeFrom")+ " kkk "+ timefrom);
                return new Schedule(rs.getInt("ID"), rs.getString("FromAirport"), rs.getString("ToAirport"), timefrom, timeto);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public void UpdateSchedule(String ID, String from_airport, String to_airport, String start_time, String end_time) {
        String query = "update [Schedule] set FromAirport =?, ToAirport =?, TimeFrom =?, TimeTo =? where ID = ?";
        try {
            conn = new ConnectDB().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, from_airport);
            ps.setString(2, to_airport);
            ps.setString(3, start_time);
            ps.setString(4, end_time);
            ps.setString(5, ID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
