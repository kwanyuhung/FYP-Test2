package example.ybdesire.com.javacompiler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import example.ybdesire.com.javacompiler.JsonFile.Json_Data_Get;

public class Tutorial_Page extends AppCompatActivity {

    //public String[] str = {"1)intro","2)test","3)print hello world","4)test","5)test2"};
    public String[] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turtorial);


        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("user_db.json");
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json_toSring = new String(buffer, "UTF-8");

            List<String> Tutorial = Json_Data_Get.FindTutorial(json_toSring);

            str = Json_Data_Get.ToArray(Tutorial);

        } catch (IOException e) {
            e.printStackTrace();
        }


        ListView LV = (ListView) findViewById(R.id.LV);
        //ListView 要顯示的內容
        //android.R.layout.simple_list_item_1 為內建樣式，還有其他樣式可自行研究
        ArrayAdapter <String> adapter = new ArrayAdapter <>(this,  android.R.layout.simple_list_item_1, str);
        LV.setAdapter(adapter);
        LV.setOnItemClickListener(onClickListView);
    }


    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Toast 快顯功能 第三個參數 Toast.LENGTH_SHORT 2秒  LENGTH_LONG 5秒
            Toast.makeText(Tutorial_Page.this,"點選第 "+(position +1) +" 個 \n內容："+position, Toast.LENGTH_SHORT).show();
            openListView(position);
        }
    };

    public  void openListView(int post){
        Intent intent = new Intent(this, Note_Page.class);
        intent.putExtra("tutorial",post);
        startActivity(intent);
    }
}
