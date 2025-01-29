package exercise;

import io.javalin.Javalin;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(); // Создаем приложение Javalin и настраиваем его
        // Обработчик GET /phones
        app.get("/phones", ctx -> {
            List<String> phones = Data.getPhones(); // Получаем список телефонов
            ctx.json(phones); // Возвращаем список телефонов в формате JSON
        });

        // Обработчик GET /domains
        app.get("/domains", ctx -> {
            List<String> domains = Data.getDomains(); // Получаем список доменов
            ctx.json(domains); // Возвращаем список доменов в формате JSON
        });

        app.start(7070); // Запускаем сервер на порту 7070
    }
}
