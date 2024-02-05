package POJOClasses.response;

import lombok.Data;

@Data
public class Login {
    private User user;
    private String token;
}



