package com.mywebsite.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = req.getServletContext();
        String rp = sc.getRealPath("storage/test.txt");
        File file = new File(rp);
        BufferedReader br = new BufferedReader(new FileReader(file));
        req.setAttribute("bufread", br.readLine());
        req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }
}
