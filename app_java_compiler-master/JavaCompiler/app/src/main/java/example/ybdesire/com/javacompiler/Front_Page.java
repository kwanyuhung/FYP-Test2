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
import org.json.JSONObject;

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

            try {
                String result = DBConnector.executeQuery("SELECT * FROM animals");
                TV.setText(result);
                /*
                    SQL 結果有多筆資料時使用JSONArray
                    只有一筆資料時直接建立JSONObject物件
                    JSONObject jsonData = new JSONObject(result);
                */
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonData = jsonArray.getJSONObject(i);
                    TableRow tr = new TableRow(Front_Page.this);
                    tr.setLayoutParams(row_layout);
                    tr.setGravity(Gravity.CENTER_HORIZONTAL);

                    TextView user_acc = new TextView(Front_Page.this);
                    user_acc.setText(jsonData.getString("name "));
                    user_acc.setLayoutParams(view_layout);

                    tr.addView(user_acc);
                    user_list.addView(tr);
                }
            } catch (Exception e) {
                Log.e("log_tag", e.toString());
            }
        }
    };
}