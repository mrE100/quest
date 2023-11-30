package com.javarush.quest.ryabov.servlets;

import java.io.*;

import com.javarush.quest.ryabov.entity.Quest;
import com.javarush.quest.ryabov.services.ServiceQuest;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession currentSession = request.getSession(true);
        Quest quest = new ServiceQuest().startQuest();
        currentSession.setAttribute("currentQuest", quest);
        currentSession.setAttribute("userName", "DefaultName");
        ServletContext context = getServletContext();
        context.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}