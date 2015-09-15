/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.producer.delegate;
import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.producer.entity.Producer;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.producer.service.ReviewSelectProducerService;

/**
 *
 * @author yangcheng
 */
public class ReviewSelectProducerDelegate {
     private ReviewSelectProducerService service;
    
	public ReviewSelectProducerDelegate() {
		service = new ReviewSelectProducerService();
	}
	
	public List<Producer> reviewSelectProducer() {
		return service.reviewSelectProducer();	
	}
}
