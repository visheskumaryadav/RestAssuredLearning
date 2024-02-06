package POJOClasses.resources;

import lombok.Data;

import java.util.List;

@Data
public class UserData {

    private List<User> valid;
    private List<User> invalid;
//    private List<User> update;

}

