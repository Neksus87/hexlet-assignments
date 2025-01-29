package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            // Получаем параметры page и per из строки запроса
            String pageParam = ctx.queryParam("page");
            String perParam = ctx.queryParam("per");

            int page = (pageParam == null || pageParam.isEmpty()) ? 1 : Integer.parseInt(pageParam);
            int per = (perParam == null || perParam.isEmpty()) ? 5 : Integer.parseInt(perParam);

            // Вычисляем количество пользователей на странице
            int start = (page - 1) * per;
            int end = Math.min(start + per, USERS.size());

            // Обработка случая, когда страница выходит за пределы
            if (start >= USERS.size()) {
                ctx.json(List.of()); // Возвращаем пустой список, если запрашиваемая страница пуста
                return;
            }

            // Возвращаем пользователи в виде JSON
            ctx.json(USERS.subList(start, end));
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
