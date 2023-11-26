package com.javarush.quest.ryabov.servlets;

import java.io.*;

import com.javarush.quest.ryabov.entity.Quest;
import com.javarush.quest.ryabov.services.ServiceQuest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession currentSession = request.getSession(true);
        Quest quest = new ServiceQuest().startQuest();
        request.setAttribute("currentQuest", quest);
        request.setAttribute("userName", "DefaultName");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);

    }

}