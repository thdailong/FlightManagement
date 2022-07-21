/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.ListTicket;
import Entity.Ticket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thanh Phuc
 */
public class DAO extends DBContext {

    public ArrayList<ListTicket> getAll() {
        ArrayList<ListTicket> list = new ArrayList();
        try {
            String sql = "select * from ListTicket";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new ListTicket(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return list;
    }

    public ArrayList<Ticket> getTicket() {
        ArrayList<Ticket> list = new ArrayList<>();
        try {
            String sql = "select * from ticket";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Ticket> getTicketDetail(Integer id) {
        ArrayList<Ticket> list = new ArrayList();
        try {
            String sql = "select t.ID, t.IDFlight, t.FirstName, t.LastName, t.CCCD, t.IDListTicket from Ticket t\n"
                    + "inner join ListTicket l\n"
                    + "on t.IDListTicket = l.ID\n"
                    + "where l.ID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (Exception e) {
            System.out.println("");
        }
        return list;
    }
}
