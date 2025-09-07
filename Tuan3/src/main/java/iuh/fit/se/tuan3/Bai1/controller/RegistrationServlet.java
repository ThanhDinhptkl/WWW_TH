package iuh.fit.se.tuan3.Bai1.controller;

import iuh.fit.se.tuan3.Bai1.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration-form")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String dateOfBirth = day + "/" + month + "/" + year;  // Ghép DOB
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobileNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String cityCode = request.getParameter("cityCode");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String[] hobbies = request.getParameterValues("hobbies");  // Mảng
        String[] courses = request.getParameterValues("courses");

        // Qualifications (ghép đơn giản)
        String classX = "Class X: Board=" + request.getParameter("classXBoard") +
                ", %=" + request.getParameter("classXPercentage") +
                ", Year=" + request.getParameter("classXYear");
        String classXII = "Class XII: Board=" + request.getParameter("classXIIBoard") +
                ", %=" + request.getParameter("classXIIPercentage") +
                ", Year=" + request.getParameter("classXIIYear");
        String masters = "Masters: Board=" + request.getParameter("mastersBoard") +
                ", %=" + request.getParameter("mastersPercentage") +
                ", Year=" + request.getParameter("mastersYear");
        String qualifications = classX + "; " + classXII + "; " + masters;

        // Tạo Student object
        iuh.fit.se.tuan3.Bai1.entity.Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dateOfBirth);
        student.setEmail(email);
        student.setMobileNumber(mobileNumber);
        ((Student) student).setGender(gender);
        student.setAddress(address);
        student.setCityCode(cityCode);
        student.setPinCode(pinCode);
        student.setState(state);
        student.setCountry(country);
        student.setHobbies(hobbies);
        student.setQualifications(qualifications);
        request.setAttribute("student", student);
        request.getRequestDispatcher("result-form.jsp").forward(request, response);
    }
}