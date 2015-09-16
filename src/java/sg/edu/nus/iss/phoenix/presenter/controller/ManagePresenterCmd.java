/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.presenter.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import at.nocturne.api.Action;
import at.nocturne.api.Perform;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.presenter.delegate.ReviewSelectPresenterDelegate;
import sg.edu.nus.iss.phoenix.presenter.entity.Presenter;
/**
 *
 * @author angxiaolu
 */
@Action("adminpresenter")
public class ManagePresenterCmd implements Perform{
    @Override
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ReviewSelectPresenterDelegate del = new ReviewSelectPresenterDelegate();
        List<Presenter> datas = del.reviewSelectPresenter();
        List<Presenter> data = del.reviewPresenter(req.getParameter("presenterName"));
        req.setAttribute("prs", datas);
        req.setAttribute("pr",data);
        System.out.println(req.getParameter("presenterName"));
        String a = req.getParameter("presenterName");
        
        return "/pages/crudpresenter.jsp";
    }
}





