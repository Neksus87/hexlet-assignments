package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        // Обработчик для отображения списка пользователей
        app.get("/users", ctx -> {
            List<User> users = USERS; // Получаем список пользователей
            ctx.render("users/index.jte", model("users", new UsersPage(users))); // Отображаем страницу со списком пользователей
        });

        // Обработчик для отображения конкретного пользователя
        app.get("/users/:id", ctx -> {
            long id = Long.parseLong(ctx.param("id"));
            User user = USERS.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
            if (user == null) {
                throw new NotFoundResponse("User not found");
            }
            ctx.render("users/show.jte", model("user", new UserPage(user))); // Отображаем страницу с данными конкретного пользователя
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
