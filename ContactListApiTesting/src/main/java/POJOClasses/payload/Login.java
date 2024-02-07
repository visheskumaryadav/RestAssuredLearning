package POJOClasses.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Login {
    private String email;
    private String password;
}
