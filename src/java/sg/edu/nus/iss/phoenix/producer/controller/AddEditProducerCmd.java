/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.producer.controller;

import at.nocturne.api.Perform;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yangcheng
 */
public class AddEditProducerCmd implements Perform {

    @Override
    @SuppressWarnings("empty-statement")
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
       return "/pages/setuppd.jsp"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
