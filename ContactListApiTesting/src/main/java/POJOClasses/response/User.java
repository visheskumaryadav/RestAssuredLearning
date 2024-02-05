package POJOClasses.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User{
    private String firstName;
    private String lastName;
    private String email;
    @JsonProperty("_id")
    private String id;
    private String __v;
}
