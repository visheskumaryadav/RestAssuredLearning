package utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonToList {

    private  List<JSONObject> convert(JSONArray arr){

        List<JSONObject> list=new ArrayList<>();
        for(int i=0;i<arr.length();i++){
            list.add((JSONObject) arr.get(i));
        }
        return list;
    }

/*
/home/developer/Documents/API_TESTING/RestAssured/ContactListApiTesting

 */
    
}
