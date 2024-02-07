package POJOClasses.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AddUser {
    private User user;
    private String token;

    @Override
    public String toString(){
        return getUser().toString() + getToken();
    }
}



