/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.presenter.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author angxiaolu
 */
public class Presenter implements Cloneable, Serializable{
    
    private String name;
    private String address;
    private Date joinDate;
    private String profile;
    
    public Presenter () {

    }
    public Presenter (String nameIn) {

        this.name = nameIn;

    }
    public String getName() {
          return this.name;
    }
    public void setName(String nameIn) {
          this.name = nameIn;
    }
    public String getAddress() {
          return this.address;
    }
    public void setAddress(String addressIn) {
          this.address = addressIn;
    }
    public Date getJoinDate() {
          return this.joinDate;
    }
    public void setJoinDate(Date joinDateIn) {
          this.joinDate = joinDateIn;
    }
    public String getProfile(){
        return this.profile;
    }
    public void setProfile(String profileIn){
         this.profile=profileIn;
    }
    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variables, without going trough the 
     * individual set-methods.
     */

    public void setAll(String nameIn,
          String addressIn,
          Date joinDateIn,
          String profileIn) {
          this.name = nameIn;
          this.address = addressIn;
          this.joinDate = joinDateIn;
          this.profile = profileIn;
    }
    /** 
     * hasEqualMapping-method will compare two RadioProgram instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Presenter valueObject) {

          if (this.name == null) {
                    if (valueObject.getName() != null)
                           return(false);
          } else if (!this.name.equals(valueObject.getName())) {
                    return(false);
          }
          if (this.address == null) {
                    if (valueObject.getAddress() != null)
                           return(false);
          } else if (!this.address.equals(valueObject.getAddress())) {
                    return(false);
          }
          if (this.joinDate == null) {
                    if (valueObject.getJoinDate() != null)
                           return(false);
          } else if (!this.joinDate.equals(valueObject.getJoinDate())) {
                    return(false);
          }
          if (this.profile == null) {
                    if (valueObject.getProfile() != null)
                           return(false);
          } else if (!this.profile.equals(valueObject.getProfile())) {
                    return(false);
          }
          

          return true; 
    }
    
    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in text log.
     */
    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("\nPresenter class, mapping to table presenter\n");
        out.append("Persistent attributes: \n"); 
        out.append("name = " + this.name + "\n"); 
        out.append("address = " + this.address + "\n"); 
        out.append("joinDate = " + this.joinDate + "\n"); 
        return out.toString();
    }
    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the returned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Presenter cloned = new Presenter();

        if (this.name != null)
             cloned.setName(new String(this.name)); 
        if (this.address != null)
             cloned.setAddress(new String(this.address)); 
        if (this.joinDate != null)
             cloned.setJoinDate((Date)this.joinDate.clone()); 
        if (this.profile != null)
             cloned.setProfile(new String(this.profile));        

        return cloned;
    }
}
