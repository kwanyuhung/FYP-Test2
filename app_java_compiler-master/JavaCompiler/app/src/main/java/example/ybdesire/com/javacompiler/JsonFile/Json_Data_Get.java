package example.ybdesire.com.javacompiler.JsonFile;

import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public  class Json_Data_Get{



    public static String[] JsonFileRead(String name, InputStream inputStream) {
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                // stringBuilder.append(line);
                stringBuilder.append(line);
            }
            reader.close();
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONObject person = new JSONObject(stringBuilder.toString());
            JSONArray infArray = person.getJSONArray(name);
            String[] result = new String[infArray.length()];
            for (int i = 0; i < infArray.length(); i++) {
                JSONObject inf_Array = infArray.getJSONObject(i);
                result[i] = inf_Array.toString();
            }
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
