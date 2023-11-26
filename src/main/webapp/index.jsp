<%@page import="com.javarush.quest.ryabov.entity.Quest" %>
<%@ page import="com.javarush.quest.ryabov.services.ServiceQuest" %>
<%@ page import="java.util.Objects" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Квест Атака Титанов</title>
    <link rel="stylesheet" href="/style.css">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <script src="<c:url value="/static/script.js"/>"></script>
</head>
<body class="mainBody">
<%
    Quest quest = (Quest) session.getAttribute("currentQuest");
%>

<div class="mainText">

    <%= quest.getQuestText()%>
    <%
        if (quest.getId() == 0) { %>
    <form action="/controller" method="get">
        <input class="input" placeholder="Введите имя" type="text" name="userName">
        <p><input class="newGame" type="submit" name="currentAnswer" value="0"></p>
    </form>

    <% } %>

    <div class="leftButton">
        <% if (quest.getId() > 0)  { %>
        <form action="/controller" method="get">
            <button class="leftButtonStyle" name="currentAnswer" value="<%=quest.getNextLeft()%>"><%=quest.getLeftButtonText()%></button>
        </form>
        <% } %>
    </div>

    <div class="rightButton">
        <% if ((quest.getId()) > 0) { %>
        <form action="/controller" method="get">
            <button class="rightButtonStyle" name="currentAnswer" value="<%=quest.getNextRight()%>"><%=quest.getRightButtonText()%></button>
        </form>
        <% } %>
    </div>

    <div class="changePlayer">
        <% if (quest.getId() > 0)  { %>
        <form action="/restart" method="get">
            <button class="changePlayerStyle">Выбрать другое имя</button>
        </form>
        <% } %>
    </div>
    <div class="userName">
        <% if (quest.getId() > 0)  { %>
        <%String username = session.getAttribute("userName").toString();%>
        <% session.setAttribute("userName", username);%>
        <h2><%=username%></h2>
        <% } %>
    </div>
</div>

<% session.setAttribute("currentQuest", quest);%>

</body>

</html>