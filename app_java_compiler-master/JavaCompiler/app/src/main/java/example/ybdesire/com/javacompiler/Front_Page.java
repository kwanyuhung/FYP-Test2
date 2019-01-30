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

import example.ybdesire.com.javacompiler.JsonFile.Json_Data_Get;

public class Front_Page extends AppCompatActivity {

    private TextView TV;

    public void openListView() {
        Intent intent = new Intent(this, Tutorial_Page.class);
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

    }

    private Button button_get_record;

    private void findViews() {
        button_get_record = (Button) findViewById(R.id.get_record);
    }

    private void setListeners() {
        button_get_record.setOnClickListener(getDBRecord);
    }

    private Button.OnClickListener getDBRecord = new Button.OnClickListener() {
        public void onClick(View v) {
            TextView TV;
            TV = (TextView) findViewById(R.id.String_output);

            // TODO Auto-generated method stub
            TableLayout user_list = (TableLayout) findViewById(R.id.user_list);
            user_list.setStretchAllColumns(true);
            TableLayout.LayoutParams row_layout = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
            TableRow.LayoutParams view_layout = new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);

//            try {
//                String result = DBConnector.executeQuery("SELECT * FROM animals");
//                TV.setText(result);
//                /*
//                    SQL 結果有多筆資料時使用JSONArray
//                    只有一筆資料時直接建立JSONObject物件
//                    JSONObject jsonData = new JSONObject(result);
//                */
//                JSONArray jsonArray = new JSONArray(result);
//                for (int i = 0; i < jsonArray.length(); i++) {
//
//                    JSONObject jsonData = jsonArray.getJSONObject(i);
//                    TableRow tr = new TableRow(Front_Page.this);
//                    tr.setLayoutParams(row_layout);
//                    tr.setGravity(Gravity.CENTER_HORIZONTAL);
//
//                    TextView user_acc = new TextView(Front_Page.this);
//                    user_acc.setText(jsonData.getString("name "));
//                    user_acc.setLayoutParams(view_layout);
//
//                    tr.addView(user_acc);
//                    user_list.addView(tr);
//                }
//            } catch (Exception e) {
//                Log.e("log_tag", e.toString());
//            }

            InputStream inputStream = null;
            try {
                inputStream = getAssets().open("user_db.json");
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                inputStream.close();
                String json_toSring = new String(buffer, "UTF-8");
                try {
                    JSONObject person = new JSONObject(json_toSring);
                    JSONArray infArray = person.getJSONArray("animals");
                    String[] result = new String[infArray.length()];
                    for (int i = 0; i < infArray.length(); i++) {
                        JSONObject inf_Array = infArray.getJSONObject(i);
                        result[i] = inf_Array.toString();
                        Log.e("read ","find header"+ result[i]);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //String[] data = Json_Data_Get.JsonFileRead("header", inputStream);

        }
    };
}