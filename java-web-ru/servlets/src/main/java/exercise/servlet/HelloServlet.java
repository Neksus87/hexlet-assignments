package exercise.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Установим тип содержимого ответа
        res.setContentType("text/plain");

        // Извлекаем параметр "name" из строки запроса
        String name = req.getParameter("name");

        // Если параметр не передан, задаём значение по умолчанию
        if (name == null || name.isEmpty()) {
            name = "Guest";
        }

        // Формируем ответ
        res.getWriter().write("Hello, " + name + "!");
    }
    // END
}
