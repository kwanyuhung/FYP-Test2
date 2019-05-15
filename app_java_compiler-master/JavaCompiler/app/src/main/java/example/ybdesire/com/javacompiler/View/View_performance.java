package example.ybdesire.com.javacompiler.View;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.List;

import example.ybdesire.com.javacompiler.JsonFile.Json_Data_Get;
import example.ybdesire.com.javacompiler.R;
import example.ybdesire.com.javacompiler.Tutorial_Page;

public class View_performance extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);

//
//        try {
//            List<String> list = Json_Data_Get.get("clear", getAssets().open("user_db.json"));
//            Log.e("s","kwan test1 "+list.toString());
//            Json_Data_Get.setComplete("clear", getAssets().open("user_db.json"));
//            List<String> list2 = Json_Data_Get.get("clear", getAssets().open("user_db.json"));
//            Log.e("s","kwan test2 "+list2.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
