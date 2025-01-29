package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        // Обработчик для динамического маршрута /companies/{id}
        app.get("/companies/{id}", ctx -> {
            String id = ctx.pathParam("id"); // Получаем id из URL
            Map<String, String> company = COMPANIES.stream()
                    .filter(c -> c.get("id").equals(id)) // Найти компанию по id
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("Company not found")); // Если не найдено, выбросить 404 с сообщением

            ctx.json(company); // Возвращаем найденную компанию в формате JSON
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
