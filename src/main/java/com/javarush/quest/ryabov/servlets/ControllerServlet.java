package com.javarush.quest.ryabov.servlets;

import com.javarush.quest.ryabov.entity.Quest;
import com.javarush.quest.ryabov.services.ServiceQuest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        int nextQuestInt = Integer.parseInt(request.getParameter("currentAnswer"));
        List<Quest> questsList = new ServiceQuest().getQuestList();
        Quest nextQuest = questsList.get(nextQuestInt);
        session.setAttribute("currentQuest", nextQuest);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

}

