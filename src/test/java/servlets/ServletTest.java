package com.javarush.quest.ryabov.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ServletTest {
    private final static String path = "/index.jsp";

    @Test
    public void whenCallStartThenServletReturnStartPage() throws ServletException, IOException {

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        final HttpSession sessionMock = mock(HttpSession.class);
        final ServletContext context = mock(ServletContext.class);
        final InitServlet start = new InitServlet() {
            @Override
            public ServletContext getServletContext() {
                return context;
            }
        };

        when(context.getRequestDispatcher(path)).thenReturn(dispatcher);
        when(request.getSession(true)).thenReturn(sessionMock);
        start.doGet(request, response);

        verify(context, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request, response);
    }
}
