package POJOClasses.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data @AllArgsConstructor
public class AddUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
