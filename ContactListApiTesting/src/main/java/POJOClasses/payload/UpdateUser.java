package POJOClasses.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UpdateUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
