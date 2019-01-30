package example.ybdesire.com.javacompiler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import example.ybdesire.com.javacompiler.JsonFile.Json_Data_Get;

public class Note_Page extends AppCompatActivity {


    public String[] str;
    private int getInListView = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note);


        TextView note = (TextView) findViewById(R.id.tur);


        //json
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("user_db.json");
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json_toSring = new String(buffer, "UTF-8");

            List<String> Tutorial = Json_Data_Get.FindNote(json_toSring);

            note.setText(Tutorial.get(getInListView));

        } catch (IOException e) {
            e.printStackTrace();
        }




        Button goExcise = (Button) findViewById(R.id.excisenow);
        goExcise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView();
            }
        });
    }



    public  void openListView(){
        Intent intent = new Intent(this, Excises_Java_Compiler.class);
        intent.putExtra("Qustion",getInListView);
        startActivity(intent);
    }
}
