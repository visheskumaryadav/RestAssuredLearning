package endPoints;

public class EndPoints {
    public static String baseUrl="https://thinking-tester-contact-list.herokuapp.com/";

    public static String addUser(){
        return "users";
    }
    public static String getUserProfile(){
        return "users/me";
    }
    public static String deleteUser(){
        return "users/me";
    }
    public static String login(){
        return "users/login";
    }
    public static String logout(){
        return "users/logout";
    }
    public static String updateUser(){
        return "users/me";
    }
}
