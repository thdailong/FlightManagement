/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Connection.ConnectDB;
import Entity.Account;
import Entity.Airport;
import Entity.Flight;
import Entity.ListTicket;
import Entity.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thdai
 */
public class GetData {

    private Connection con = ConnectDB.connect();

    public ArrayList<Airport> getAirport() {
        try {
            String sqlAirport = "SELECT * FROM Airport";
            PreparedStatement statementAirport = con.prepareStatement(sqlAirport);
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
    
    public String DataListAirport(int id) {
        ArrayList<Airport> arrAirport = getAirport();
        String res = "";
        for (int i = 0; i < arrAirport.size(); ++i) {
            if (arrAirport.get(i).getID() == id) {
                res+= "<option value='" + arrAirport.get(i).getID() + "' selected>" + arrAirport.get(i).getName() + "</option>";
            }
            else {
                res+= "<option value='" + arrAirport.get(i).getID() + "'>" + arrAirport.get(i).getName() + "</option>";
            }
        }
        return res;
    }

    public ArrayList<Schedule> getSchedule(int IDFrom, int IDTo) {
        try {
            ArrayList<Airport> listAirport = getAirport();
            ArrayList<Schedule> listSchedule = new ArrayList<>();

            String sql = "Select * from Schedule";
            if (IDFrom != -1 && IDTo != -1) {
                sql = "Select * from Schedule WHERE FromAirport = " + IDFrom + " AND ToAirport = " + IDTo;
            }
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");

            while (rs.next()) {
                Date timeFrom = parser.parse(rs.getString("TimeFrom"));
                Date timeTo = parser.parse(rs.getString("TimeTo"));
                String Depart = "";
                String Arrive = "";
                for (int i = 0; i < listAirport.size(); ++i) {
                    if (rs.getInt("FromAirport") == listAirport.get(i).getID()) {
                        Depart = listAirport.get(i).getName();
                    }
                    if (rs.getInt("ToAirport") == listAirport.get(i).getID()) {
                        Arrive = listAirport.get(i).getName();
                    }
                }
                String middle = "";
                if (timeFrom.getMinutes() < 10) middle = "0";
                String stringTimeFrom = timeFrom.getHours() + ":" + middle + timeFrom.getMinutes();
                
                if (timeFrom.getMinutes() < 10) middle = "0";
                else middle="";
                String stringTimeTo = timeTo.getHours() + ":" + middle + timeTo.getMinutes();

                Schedule tmp = new Schedule(rs.getInt("ID"), Depart, Arrive, stringTimeFrom, stringTimeTo);
                listSchedule.add(tmp);
            }
            return listSchedule;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public Account getAccount(String us, String pss) {
        String query = "select * from Account where username =?  and password=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, us);
            ps.setString(2, pss);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account ac = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
                return ac;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<ListTicket> getInfor(String id) {
        String query = "select FirstName,LastName,Days from ListTicket l, Account a \n"
                + "where a.ID = l.IDUser and iduser=?";
        List<ListTicket> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ListTicket(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                )
                );
            }
        } catch (Exception e) {
        }

        return list;
    }

    public ArrayList<Flight> getAllFlight() {
        String query = "select * from Flight";
        ArrayList<Flight> res = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight tmpFlight = new Flight(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
                res.add(tmpFlight);
            }
            return res;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<Flight> getAllFlightOnDate(String date) {
        String query = "select * from Flight WHERE date = ?";
        ArrayList<Flight> res = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight tmpFlight = new Flight(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
                System.out.println(tmpFlight.getDate());
                res.add(tmpFlight);
            }
            return res;
        } catch (Exception e) {
        }
        return null;
    }

    public int getListTicketsNewest() {
        String query = "select * from ListTicket";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            while (rs.next()) {
                if (id < rs.getInt(1)) id = rs.getInt(1);
            }
            return id;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public Schedule getScheduleOnID(String ID) {
        String query = "select * from Schedule WHERE ID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            while (rs.next()) {
                Date timeFrom = parser.parse(rs.getString(4));
                Date timeTo = parser.parse(rs.getString(5));
                String middle = "";
                if (timeFrom.getMinutes() < 10) middle = "0";
                String stringTimeFrom = timeFrom.getHours() + ":" + middle + timeFrom.getMinutes();
                
                if (timeFrom.getMinutes() < 10) middle = "0";
                else middle="";
                String stringTimeTo = timeTo.getHours() + ":" + middle + timeTo.getMinutes();
                
                return new Schedule(rs.getInt(1), rs.getString(2), rs.getString(3), stringTimeFrom, stringTimeTo);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public int getSeatRemainingOnSID_date(String ID, String date) {
        String query = "select * from Flight WHERE IDSchedule = ? AND date = ?";
        int res = 200;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ID);
            ps.setString(2, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(3);
            }
            return res;
        } catch (Exception e) {
        }
        return -1;
    }
    
    public void insertSeatRemainingOnSID_date(String ID, String date, int seatRemaining) {
        String query = "insert into Flight values(?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ID+"_"+date);
            ps.setString(2, ID);
            ps.setInt(3, seatRemaining);
            ps.setString(4, date);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void setSeatRemainingOnSID_date(String ID, String date, int seatRemaining) {
        String query = "update [Flight] set SeatRemaining =? where date=? AND IDSchedule = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, seatRemaining);
            ps.setString(2, date);
            ps.setString(3, ID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        GetData n = new GetData();
        ArrayList<Flight> ar = n.getAllFlightOnDate("2022-01-05");
        System.out.print(ar.size());
    }
}
