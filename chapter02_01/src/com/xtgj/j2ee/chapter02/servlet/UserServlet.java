package com.xtgj.j2ee.chapter02.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtgj.j2ee.chapter02.user.biz.UserManager;

public class UserServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cahce");
        PrintWriter out = response.getWriter();
        String text = "";
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        if (pwd.isEmpty()) {
            UserManager m = new UserManager();
            try {
                if (m.check(uname)) {
                    text = "true";
                    out.print(text);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.close();
        } else {
            UserManager m = new UserManager();
            try {
                if (m.register(uname, pwd)) {
                    text = "true";
                    out.print(text);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
