package example.ybdesire.com.javacompiler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import example.ybdesire.com.javacompiler.JsonFile.Json_Data_Get;
import example.ybdesire.com.javacompiler.View.View_Gen_Example;
import example.ybdesire.com.javacompiler.View.View_Login_Page;

public class Front_Page extends AppCompatActivity {

    private TextView TV;

    public void openListView() {
        Intent intent = new Intent(this, Tutorial_Page.class);
        startActivity(intent);
    }
    public void login(){
        //go to login
        Intent intent = new Intent(this, View_Login_Page.class);
        startActivity(intent);
    }

    public void Gen(){
        Intent intent = new Intent(this, View_Gen_Example.class);
        startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);


        findViews();
        setListeners();

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());

        Button golearn = (Button) findViewById(R.id.learnnow);
        golearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView();
            }
        });

        Button gen = (Button) findViewById(R.id.Gen);
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gen();
            }
        });

    }

    private Button button_get_record;

    private void findViews() {
        button_get_record = (Button) findViewById(R.id.Login);
    }

    private void setListeners() {
        button_get_record.setOnClickListener(getDBRecord);
    }

    private Button.OnClickListener getDBRecord = new Button.OnClickListener() {
        public void onClick(View v) {
            TextView TV;
            TV = (TextView) findViewById(R.id.String_output);

           /* // TODO Auto-generated method stub
            TableLayout user_list = (TableLayout) findViewById(R.id.user_list);
            user_list.setStretchAllColumns(true);
            TableLayout.LayoutParams row_layout = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
            TableRow.LayoutParams view_layout = new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
            */

            login();
        }
    };
}