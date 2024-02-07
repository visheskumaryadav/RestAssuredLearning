package POJOClasses.resources;

import POJOClasses.payload.Login;
import lombok.Data;

import java.util.List;

@Data
public class LoggedInUserData {
    private Login valid;
    private List<Login> invalid;
}
