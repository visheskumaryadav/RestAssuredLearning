package POJOClasses.resources;

import lombok.Data;

@Data
public class Config {
    private String baseUrl;
    private String userDataPath;
    private String loggedInUserDataPath;
    private String firstName;
    private String lastName;
}
