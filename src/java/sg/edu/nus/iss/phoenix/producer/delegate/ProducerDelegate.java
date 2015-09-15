/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.producer.delegate;

import sg.edu.nus.iss.phoenix.producer.entity.Producer;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.radioprogram.service.ProgramService;

/**
 *
 * @author yangcheng
 */

public class ProducerDelegate {
/*	
	public ArrayList<RadioProgram> searchPrograms(RPSearchObject rpso) {
		RadioProgram rp = new RadioProgram(rpso.getName());
		rp.setDescription(rpso.getDescription());
		ProgramService service = new ProgramService();
		return service.searchPrograms(rp);	
	}
	
	public ArrayList<RadioProgram> findRPByCriteria(RPSearchObject rpso) {
		RadioProgram rp = new RadioProgram(rpso.getName());
		rp.setDescription(rpso.getDescription());
		ProgramService service = new ProgramService();
		return service.searchPrograms(rp);	
	}
	
	public RadioProgram findRP(String rpName) {
		RadioProgram rp = new RadioProgram(rpName);
		ProgramService service = new ProgramService();
		return (service.searchPrograms(rp)).get(0);	
		
	}
	public ArrayList<RadioProgram> findAllRP() {
		ProgramService service = new ProgramService();
		return service.findAllRP();
		
	}
*/	
	/*public void processCreate(Producer rp) {
		Producer service = new ProducerService();
		service.processCreate(rp);
		
	}
	public void processModify(Producer rp) {
		ProducerService service = new ProducerService();
		service.processModify(rp);
		
	}

	public void processDelete(String name) {
		ProducerService service = new ProducerService();
		service.processDelete(name);
	}*/
}