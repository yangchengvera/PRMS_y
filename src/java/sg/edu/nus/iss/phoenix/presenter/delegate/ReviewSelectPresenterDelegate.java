/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.presenter.delegate;

import java.util.List;
import sg.edu.nus.iss.phoenix.presenter.entity.Presenter;
import sg.edu.nus.iss.phoenix.presenter.service.ReviewSelectPresenterService;
/**
 *
 * @author angxiaolu
 */
public class ReviewSelectPresenterDelegate {
        private ReviewSelectPresenterService service;
    
	public ReviewSelectPresenterDelegate() {
		service = new ReviewSelectPresenterService();
	}
	
	public List<Presenter> reviewSelectPresenter() {
		return service.reviewSelectPresenter();	
	}
        public List<Presenter> reviewPresenter(String presenterName){
            return service.reviewPresenter(presenterName);
        }
}

