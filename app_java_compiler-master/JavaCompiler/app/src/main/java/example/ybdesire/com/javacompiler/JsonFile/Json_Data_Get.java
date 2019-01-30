package example.ybdesire.com.javacompiler.JsonFile;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.api.client.json.Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public  class Json_Data_Get{



   public static List<String> FindTutorial(String Json){

        List<String> fyp = new ArrayList <>();

        try {
            JSONObject person = new JSONObject(Json);
            JSONArray infArray = person.getJSONArray("fyp");
            for (int i = 0; i < infArray.length(); i++) {
                JSONObject inf_Array = infArray.getJSONObject(i);
                String child_Array = inf_Array.getString("Tutorial");
                fyp.add(child_Array);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fyp;
    }

    public static List<String> FindNote(String Json){

        List<String> fyp = new ArrayList <>();

        try {
            JSONObject person = new JSONObject(Json);
            JSONArray infArray = person.getJSONArray("fyp");
            for (int i = 0; i < infArray.length(); i++) {
                JSONObject inf_Array = infArray.getJSONObject(i);
                String child_Array = inf_Array.getString("note");
                fyp.add(child_Array);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fyp;
    }

    public static List<String> FindExcise(String Json){

        List<String> fyp = new ArrayList <>();

        try {
            JSONObject person = new JSONObject(Json);
            JSONArray infArray = person.getJSONArray("fyp");
            for (int i = 0; i < infArray.length(); i++) {
                JSONObject inf_Array = infArray.getJSONObject(i);
                String child_Array = inf_Array.getString("excise");
                fyp.add(child_Array);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fyp;
    }



   public static String[] ToArray(List<String> List){
       String[] result =  new String[List.size()];

       for(int i = 0 ; i< List.size();i++){
           result[i] = List.get(i);
       }

       return  result;
   }
}
