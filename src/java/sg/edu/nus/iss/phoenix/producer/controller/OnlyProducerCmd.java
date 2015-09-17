/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.producer.controller;

import at.nocturne.api.Action;
import at.nocturne.api.Perform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.producer.delegate.ReviewSelectProducerDelegate;
import sg.edu.nus.iss.phoenix.producer.entity.Producer;
import sg.edu.nus.iss.phoenix.radioprogram.delegate.ReviewSelectProgramDelegate;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author yangcheng
 */



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 @Action("onlypd")
public class OnlyProducerCmd implements Perform {
    @Override
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ReviewSelectProducerDelegate del = new ReviewSelectProducerDelegate();
        List<Producer> data = del.reviewSelectProducer(); 
        List<Producer> data1 = new ArrayList();
        String name = req.getParameter("producer");
        System.out.println(data.size());
        if(data!=null){
        Iterator<Producer> itr=data.iterator();
        while(itr.hasNext()){
            Producer p=itr.next();
        if(p.getName().equals(name))
        {data1.add(p);
            }
        }
        req.setAttribute("pds", data1);
    }       
        
       

        return "/pages/crudpd.jsp";
    }
}
