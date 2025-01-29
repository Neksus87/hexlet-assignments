package exercise;

import io.javalin.Javalin;
import io.javalin.http.JsonMapper;
import com.google.gson.Gson;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        public static Javalin getApp() {
            // Создаем приложение Javalin
            Javalin app = Javalin.create();

            // Обработчик GET /phones
            app.get("/phones", ctx -> {
                // Получаем список телефонов
                List<String> phones = Data.getPhones();
                // Возвращаем список телефонов в формате JSON
                ctx.json(phones);
            });

            // Обработчик GET /domains
            app.get("/domains", ctx -> {
                // Получаем список доменных имен
                List<String> domains = Data.getDomains();
                // Возвращаем список доменных имен в формате JSON
                ctx.json(domains);
            });

            return app; // Возвращаем экземпляр Javalin
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
