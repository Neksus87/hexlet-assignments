package exercise;

import io.javalin.Javalin;
import io.javalin.http.JsonMapper;
import com.google.gson.Gson;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(config -> {
            // Настройка JSON маппера с использованием Gson
            config.jsonMapper(new JsonMapper() {
                private final Gson gson = new Gson();

                @Override
                public String toJson(Object obj) {
                    return gson.toJson(obj);
                }

                @Override
                public <T> T fromJson(String json, Class<T> targetClass) {
                    return gson.fromJson(json, targetClass);
                }
            });
        });

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
