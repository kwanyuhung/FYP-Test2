package example.ybdesire.com.javacompiler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class Tutorial extends AppCompatActivity {


    private Button goexcise;
    public String[] str;
    private String getinlistview = "Null";

    private TextView Note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            getinlistview = extras.getString("tutorial");
            //The key argument here must match that used in the other activity
        }



        Note = (TextView) findViewById(R.id.tur);
        //Note.setText(getinlistview);

        try {
            String result = DBConnector.executeQuery("SELECT fyp.note FROM user.fyp where id = " + getinlistview);
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonData = jsonArray.getJSONObject(0);
            Note.setText(jsonData.getString("note"));

        } catch(Exception e) {
            Log.e("log_tag", e.toString());
        }

        goexcise = (Button) findViewById(R.id.excisenow);
        goexcise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView();
            }
        });
    }



    public  void openListView(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("Qustion",getinlistview);
        startActivity(intent);
    }
}
