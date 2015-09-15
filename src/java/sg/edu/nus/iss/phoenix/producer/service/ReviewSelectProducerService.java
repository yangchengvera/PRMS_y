/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.producer.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.producer.dao.ProducerDAO;
import sg.edu.nus.iss.phoenix.producer.entity.Producer;
import sg.edu.nus.iss.phoenix.radioprogram.dao.ProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.radioprogram.service.ReviewSelectProgramService;

/**
 *
 * @author yangcheng
 */
public class ReviewSelectProducerService {
    DAOFactoryImpl factory;
	ProducerDAO rpdao;

	public ReviewSelectProducerService() {
		super();
		// TODO Auto-generated constructor stub
		factory = new DAOFactoryImpl();
		rpdao = factory.getProducerDAO();
	}

	public List<Producer> reviewSelectProducer() {
            List<Producer> data = null;
            try {
                data = rpdao.loadAll();
            } catch (SQLException ex) {
                Logger.getLogger(ReviewSelectProgramService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
	}
        
       
        

    
}
