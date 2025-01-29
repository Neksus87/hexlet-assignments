package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {
        // Создаем приложение Javalin
        Javalin app = Javalin.create();

        // Обработчик GET /phones
        app.get("/phones", ctx -> {
            // Получаем список телефонов и возвращаем его в формате JSON
            ctx.json(Data.getPhones());
        });

        // Обработчик GET /domains
        app.get("/domains", ctx -> {
            // Получаем список доменов и возвращаем его в формате JSON
            ctx.json(Data.getDomains());
        });

        return app; // Возвращаем настроенное приложение
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070); // Запуск приложения на порту 7070
    }
}
