package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

// BEGIN
@Getter
public class UsersPage {
    @NonNull private List<User> users;

    public UsersPage(List<User> users) {
        this.users = users;
    }
}
// END