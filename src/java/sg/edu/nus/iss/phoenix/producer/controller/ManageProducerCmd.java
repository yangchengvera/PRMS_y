/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.producer.controller;

import at.nocturne.api.Action;
import at.nocturne.api.Perform;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


/**
 *
 * @author boonkui
 */
 @Action("managepd")
public class ManageProducerCmd implements Perform {
    @Override
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ReviewSelectProducerDelegate del = new ReviewSelectProducerDelegate();
        List<Producer> data = del.reviewSelectProducer();
        System.out.println(data.size());
//        if(data!=null){
//        Iterator<Producer> itr=data.iterator();{
//        while(itr.hasNext()){
//            Producer p=itr.next();
//        System.out.println("data::"+p.getName()+p.getAddress()+p.getdatejoin());
//        }
//    }
//        }
        req.setAttribute("pds", data);

        return "/pages/crudpd.jsp";
    }
}
