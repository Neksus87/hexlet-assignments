package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ClasspathCodeResolver; // Убедитесь, что это существует в вашей версии JTE


import java.util.List;
import java.util.Optional;

public final class App {
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            init(new TemplateEngine(ClasspathCodeResolver.createDefault())); // Убедитесь, что это работает
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            UsersPage usersPage = new UsersPage(USERS);
            ctx.render("users/index.jte", model(usersPage));
        });

        app.get("/users/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Optional<User> userOptional = USERS.stream().filter(user -> user.getId() == id).findFirst();
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                UserPage userPage = new UserPage(user);
                ctx.render("users/show.jte", model(userPage));
            } else {
                throw new NotFoundResponse("User not found");
            }
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
