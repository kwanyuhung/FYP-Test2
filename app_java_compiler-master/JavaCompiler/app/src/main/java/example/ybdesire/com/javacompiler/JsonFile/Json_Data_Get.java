package example.ybdesire.com.javacompiler.JsonFile;

import android.content.res.AssetManager;
import android.renderscript.ScriptGroup;
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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import example.ybdesire.com.javacompiler.Json.Utils_Access;

public abstract class Json_Data_Get extends Utils_Access {


    public static String tryget(InputStream inputStream) {
        String json_toSring = null;
        try {
//            inputStream = getAssets().open("user_db.json");
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json_toSring = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json_toSring;
    }


    public static List<String> get(String json_value, InputStream inputStream) {
        String json_toSring = tryget(inputStream);

        List<String> fyp = new ArrayList<>();

        try {
            JSONObject person = new JSONObject(json_toSring);
            JSONArray infArray = person.getJSONArray("fyp");
            for (int i = 0; i < infArray.length(); i++) {
                JSONObject inf_Array = infArray.getJSONObject(i);
                String child_Array = inf_Array.getString(json_value);
                fyp.add(child_Array);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fyp;
    }


    public static List<String> getJsonArray(String json_value, InputStream inputStream, int count) {
        String json_toSring = tryget(inputStream);


        ArrayList<String> content = new ArrayList<>();
        try {
            JSONObject person = new JSONObject(json_toSring);
            JSONArray infArray = person.getJSONArray("fyp");

            JSONObject inf_Array = infArray.getJSONObject(count);
            JSONArray child_Array = inf_Array.getJSONArray(json_value); //note
            if(child_Array!=null){
                for (int i= 0; i < child_Array.length();i++) {
                    JSONObject contentData = child_Array.getJSONObject(i);

                    content.add(contentData.getString("Content"));
                }
                return content;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean CheckLogin(String Json, String id, String pw) {

        String userID;
        String userPw;

        try {
            JSONObject person = new JSONObject(Json);
            JSONArray infArray = person.getJSONArray("user");
            for (int i = 0; i < infArray.length(); i++) {
                JSONObject inf_Array = infArray.getJSONObject(i);
                userID = inf_Array.getString("account");
                userPw = inf_Array.getString("account");
                if (userID.equals(id) && userPw.equals(pw)) {
                    return true;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> FindTutorial(String Json) {

        List<String> fyp = new ArrayList<>();

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

    public static List<String> FindNote(String Json) {

        List<String> fyp = new ArrayList<>();

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

    public static List<String> FindExcise(String Json) {

        List<String> fyp = new ArrayList<>();

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

    public static List<Boolean> FindClear(String Json) {

        List<Boolean> fyp = new ArrayList<>();

        try {
            JSONObject person = new JSONObject(Json);
            JSONArray infArray = person.getJSONArray("fyp");
            for (int i = 0; i < infArray.length(); i++) {
                JSONObject inf_Array = infArray.getJSONObject(i);
                Boolean child_Array = inf_Array.getBoolean("clear");
                fyp.add(child_Array);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fyp;
    }


    public static String[] ToArray(List<String> List) {
        String[] result = new String[List.size()];

        for (int i = 0; i < List.size(); i++) {
            result[i] = List.get(i);
        }

        return result;
    }
}
