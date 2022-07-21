/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Thanh Phuc
 */
public class Ticket {
    private int id;
    private String idFlight;
    private String firstName;
    private String lastName;
    private String cccd;
    private int idListTicket;

    public Ticket() {
    }

    public Ticket(int id, String idFlight, String firstName, String lastName, String cccd, int idListTicket) {
        this.id = id;
        this.idFlight = idFlight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cccd = cccd;
        this.idListTicket = idListTicket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(String idFlight) {
        this.idFlight = idFlight;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getIdListTicket() {
        return idListTicket;
    }

    public void setIdListTicket(int idListTicket) {
        this.idListTicket = idListTicket;
    }
    
}
