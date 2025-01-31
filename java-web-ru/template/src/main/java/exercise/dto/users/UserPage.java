package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

// BEGIN
@Getter
public class UserPage {
    @NonNull private User user;

    public UserPage(User user) {
        this.user = user;
    }
    public String getFirstName() {
        return this.user.getFirstName();
    }
    public String getLastName() {
        return this.user.getLastName();
    }
}
// END
