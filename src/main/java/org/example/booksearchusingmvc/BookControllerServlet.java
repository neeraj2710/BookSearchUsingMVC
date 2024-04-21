package org.example.booksearchusingmvc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.print.Book;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookControllerServlet", value = "/BookControllerServlet")
public class BookControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");

        if(subject.isEmpty()) {
            resp.sendRedirect("error.html");
        }

        else{
            try {
                List<BookPojo> bookList = BookModel.getAllBooksBySubject(subject);
                RequestDispatcher rd = null;
                if(bookList.isEmpty()) {
                    rd = req.getRequestDispatcher("noBooks.jsp");
                    req.setAttribute("subject",subject);
                    rd.forward(req, resp);
                }
                else {
                    rd = req.getRequestDispatcher("showBooks.jsp");
                    req.setAttribute("bookList",bookList);
                    req.setAttribute("subject",subject);
                    rd.forward(req, resp);
                }
            }catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}