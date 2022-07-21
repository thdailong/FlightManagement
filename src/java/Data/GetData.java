/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Connection.ConnectDB;
import Entity.Account;
import Entity.Airport;
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
                String stringTimeFrom = timeFrom.getHours() + ":" + timeFrom.getMinutes();
                String stringTimeTo = timeTo.getHours() + ":" + timeTo.getMinutes();

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
        
        return  list;
    }

    public static void main(String[] args) {
        GetData n = new GetData();
        String us = "manager";
        String pss = "manager";
        Account a = n.getAccount(us, pss);
        System.out.println(a);
    }
}
