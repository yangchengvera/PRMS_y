/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.producer.entity;

import java.io.Serializable;
import java.sql.Date;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;

/**
 *
 * @author yangcheng
 */
public class Producer extends User implements Cloneable, Serializable {

    /**
	 * eclipse identifier
	 */
	private static final long serialVersionUID = -5500218812568593553L;
	
	/** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String name;
    private String address;
    private Date datejoin;



    /** 
     * Constructors. 
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Producer() {

    }

    public Producer (String nameIn) {

          this.name = nameIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getName() {
          return this.name;
    }
    public void setName(String nameIn) {
          this.name = nameIn;
    }

    public String getAddress() {
          return this.address;
    }
    public void setAddress(String address) {
          this.address = address;
    }

    public Date getdatejoin() {
          return this.datejoin;
    }
    public void setdatejoin(Date datejoinin) {
          this.datejoin = datejoinin;
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
          Date typicalDurationIn) {
          this.name = nameIn;
          this.address = addressIn;
          this.datejoin = typicalDurationIn;
    }


    /** 
     * hasEqualMapping-method will compare two RadioProgram instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Producer valueObject) {

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
          if (this.datejoin == null) {
                    if (valueObject.getdatejoin() != null)
                           return(false);
          } else if (!this.datejoin.equals(valueObject.getdatejoin())) {
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
        out.append("\nRadioProgram class, mapping to table radio-program\n");
        out.append("Persistent attributes: \n"); 
        out.append("name = " + this.name + "\n"); 
        out.append("address = " + this.address + "\n"); 
        out.append("datejoin = " + this.datejoin + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the returned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
       Producer cloned = new Producer();

        if (this.name != null)
             cloned.setName(new String(this.name)); 
        if (this.address != null)
             cloned.setAddress(new String(this.address)); 
        if (this.datejoin != null)
             cloned.setdatejoin((Date)this.datejoin.clone()); 
        return cloned;
    }



}
    
