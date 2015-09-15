/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.presenter.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.presenter.dao.PresenterDAO;
import sg.edu.nus.iss.phoenix.presenter.entity.Presenter;
/**
 *
 * @author angxiaolu
 */
public class ReviewSelectPresenterService {
    DAOFactoryImpl factory;
    PresenterDAO prdao;
    
    public ReviewSelectPresenterService(){
        super();
        factory = new DAOFactoryImpl();
        prdao = factory.getPresenterDAO();
    }
    public List<Presenter> reviewSelectPresenter(){
        List<Presenter> data = null;
        try{
            data = prdao.loadAll();
        }catch (SQLException ex){
            Logger.getLogger(ReviewSelectPresenterService.class.getName()).log(Level.SEVERE,null,ex);
        }
        return data;
    }
    
}
