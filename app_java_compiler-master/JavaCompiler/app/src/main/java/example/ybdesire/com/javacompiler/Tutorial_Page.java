package example.ybdesire.com.javacompiler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class Tutorial_Page extends AppCompatActivity {

    //public String[] str = {"1)intro","2)test","3)print hello world","4)test","5)test2"};
    public String[] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        String result = DBConnector.executeQuery("SELECT Tutorial FROM user.fyp");

        try {

            JSONArray jsonArray = new JSONArray(result);
            str = new String[jsonArray.length()];
            for(int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonData = jsonArray.getJSONObject(i);
                jsonData.getString("Tutorial");

                str[i] = i+1 +" )"+jsonData.getString("Tutorial");
            }
        } catch(Exception e) {
            Log.e("log_tag", e.toString());
        }

        ListView LV = (ListView) findViewById(R.id.LV);
        //ListView 要顯示的內容
        //android.R.layout.simple_list_item_1 為內建樣式，還有其他樣式可自行研究
        ArrayAdapter adapter = new ArrayAdapter(this,  android.R.layout.simple_list_item_1, str);
        LV.setAdapter(adapter);
        LV.setOnItemClickListener(onClickListView);
    }


    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Toast 快顯功能 第三個參數 Toast.LENGTH_SHORT 2秒  LENGTH_LONG 5秒
            Toast.makeText(Tutorial_Page.this,"點選第 "+(position +1) +" 個 \n內容："+str[position], Toast.LENGTH_SHORT).show();
            openListView(String.valueOf(position+1));
        }
    };

    public  void openListView(String post){
        Intent intent = new Intent(this,Tutorial.class);
        intent.putExtra("tutorial",post);
        startActivity(intent);
    }
}
