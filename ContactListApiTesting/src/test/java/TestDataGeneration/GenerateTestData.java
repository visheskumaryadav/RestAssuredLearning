package TestDataGeneration;

import POJOClasses.payload.Login;
import POJOClasses.resources.Config;
import POJOClasses.resources.LoggedInUserData;
import POJOClasses.resources.User;
import POJOClasses.resources.UserData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class GenerateTestData {

   private static  GenerateTestData generateTestData;
    @Getter
    private Config configData;
    private UserData userData;
    @Getter
    private LoggedInUserData loggedInUser;
    @Getter
    private final List<User> validUserData;
    @Getter
    private final List<User> inValidUserData;
    private  GenerateTestData() {
        setUpUserDataFileConnection();
      validUserData=  collectValidUserData();
      inValidUserData=  collectInvalidUserData();
    }

    public static GenerateTestData setUp(){
        if (generateTestData == null) {
            generateTestData = new GenerateTestData();
        }
        return generateTestData;
    }

    private List<User> collectInvalidUserData() {
        return userData.getInvalid();
    }

    private List<User> collectValidUserData() {
        return userData.getValid();
    }

    /*
    setUpConfigurationFileConnection: Reading the configuration file using jackson dependency
     */
    private void setUpConfigurationFileConnection() {
        String configFilePath = System.getProperty("user.dir") + "/resources/ConfigurationFiles/configuration.json";
        File configFile = new File(configFilePath);
        try {
            if (!configFile.exists()) {
                throw new FileNotFoundException("Configuration file is not present......");
            } else {
                ObjectMapper mapper = new ObjectMapper();
                configData = mapper.readValue(configFile, Config.class);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

        private void setUpUserDataFileConnection () {
            setUpConfigurationFileConnection();
            if(configData!=null){
                File userDataFile = new File(System.getProperty("user.dir")+configData.getUserDataPath());
                File loggedInUserDataFile=new File(System.getProperty("user.dir")+configData.getLoggedInUserDataPath());
                try {
                    if (!userDataFile.exists() || !loggedInUserDataFile.exists()) {
                        throw new FileNotFoundException("User data file or logged-in user file is not present......");
                    } else {
                        ObjectMapper mapper = new ObjectMapper();
                        userData = mapper.readValue(userDataFile, UserData.class);
                        loggedInUser=mapper.readValue(loggedInUserDataFile, LoggedInUserData.class);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    public static void main(String[] args) {
        Login user=GenerateTestData.setUp().getLoggedInUser().getValid();
        System.out.println(user);
    }
}



