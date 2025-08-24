package se.iuh.fit.baituan1;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "password123".equals(password)) {
            out.println("<html>");
            out.println("<head><title>Login Success</title></head>");
            out.println("<body>");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<p>Login successful.</p>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<html>");
            out.println("<head><title>Login Failed</title></head>");
            out.println("<body>");
            out.println("<h1>Login Failed</h1>");
            out.println("<p>Invalid username or password.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}