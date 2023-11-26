package com.javarush.quest.ryabov.servlets;

import com.javarush.quest.ryabov.entity.Quest;
import com.javarush.quest.ryabov.services.ServiceQuest;
import jakarta.servlet.RequestDispatcher;
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

        String name = request.getParameter("userName");
        HttpSession session = request.getSession();
        Quest currentQuest = (Quest) session.getAttribute("currentQuest");
        if(currentQuest.getId() == 0) {
            session.setAttribute("userName", name);
        }
        int nextQuestInt = Integer.parseInt(request.getParameter("currentAnswer"));
        List<Quest> questsList = new ServiceQuest().getQuestList();
        Quest nextQuest = questsList.get(nextQuestInt);
        System.out.println(nextQuest.getId());
        request.setAttribute("currentQuest", nextQuest);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        requestDispatcher.forward(request, response);
    }

}

