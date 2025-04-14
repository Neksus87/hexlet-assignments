package exercise.dto;

// BEGIN
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GuestCreateDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @Pattern(regexp = "\\+\\d{11,13}", message = "Phone number must start with + and contain 11-13 digits")
    private String phoneNumber;

    @Pattern(regexp = "\\d{4}", message = "Club card must contain exactly 4 digits")
    private String clubCard;

    @Future(message = "Card validity date must be in the future")
    private LocalDate cardValidUntil;
}
// END
