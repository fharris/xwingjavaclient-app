/* Copyright 2015 Oracle and/or its affiliates. All rights reserved. */
package com.xwing.clientjava;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "XwingServlet",
        urlPatterns = {"/xwing"}
)
public class XwingServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in doGet method .... \n");
      	restcallservice(req,resp,"http://ip.jsontest.com/"); //2 = GET
          
    }
    
    private void restcallservice(HttpServletRequest req, HttpServletResponse resp, String paramApiUrl)
            throws ServletException, IOException {
        
        System.out.println("in RestCallService method .... \n");
        
        JerseyClientGet testerJersey = new JerseyClientGet("http://ip.jsontest.com/");
  	  
  	  	testerJersey.init();
  	         
  	  	forwardToPage(req, resp);
                
    }

    
    private void forwardToPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nextJSP = "/jsp/rest-call.jsp";
    	
        System.out.println("in forwardListEmployees method .... \n");
        
                
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        
        dispatcher.forward(req, resp);
    }
    
    
    
}
