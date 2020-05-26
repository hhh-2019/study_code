package com.servlet;

import com.dao.User;
import com.daomen.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //中文乱码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cherkCode = request.getParameter("cherkCode");

        //3.获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");
        //先后先判断呀正码是否正确
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(cherkCode)){
            UserDao user_dao = new UserDao();
            user_dao.setUsername(username);
            user_dao.setPassword(password);
            User user = new User();
            UserDao login = user.login(user_dao);
            if(login.getUsername().equals(username)&& login.getPassword().equals(password)){
                session.setAttribute("user",username);
                //重定向到session
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            }else{
                //登陆失败
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            //验证码不一致
            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
