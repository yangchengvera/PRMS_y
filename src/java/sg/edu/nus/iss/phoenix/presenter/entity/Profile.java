/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.presenter.entity;

/**
 *
 * @author angxiaolu
 */
public class Profile implements Cloneable{
    
   
    
    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the returned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Profile cloned = new Profile();
      

        return cloned;
    }
    
}
