<%@page import="com.javarush.quest.ryabov.entity.Quest" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Квест Атака Титанов</title>
    <link rel="stylesheet" href="/style.css">
</head>
<style>
    body {
        background-image: url('${pageContext.request.contextPath}/images/background.jpg');
        background-size: cover;
        background-position: top;
        background-repeat: no-repeat;
    }
</style>

<%
    Quest quest = (Quest) session.getAttribute("currentQuest");
%>

<div class="mainText">


    <%= quest.getQuestText()%>


    <div class="firstButton">

        <form action="/controller" method="get">
            <button class="firstButtonStyle" name="currentAnswer" value="<%=quest.getNextFirst()%>"><%=quest.getFirstButtonText()%></button>
        </form>

    </div>

    <div class="secondButton">

        <form action="/controller" method="get">
            <button class="secondButtonStyle" name="currentAnswer" value="<%=quest.getNextSecond()%>"><%=quest.getSecondButtonText()%></button>
        </form>
    </div>

    <div class="restart">
        <% if (quest.getId() > 0)  { %>
        <form action="/restart" method="get">
            <button class="changePlayerStyle">Перезапустить квест</button>
        </form>
        <% } %>
    </div>

</div>

<% session.setAttribute("currentQuest", quest);%>

</body>

</html>