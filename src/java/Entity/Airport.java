/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author thdai
 */
public class Airport {
    private int ID;
    private String Name;

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Airport{" + "ID=" + ID + ", Name=" + Name + '}';
    }

    public String getName() {
        return Name;
    }

    public Airport(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }
    
}
