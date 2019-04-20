package example.ybdesire.com.javacompiler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import example.ybdesire.com.javacompiler.Adapter.Adapter_Note_Content;
import example.ybdesire.com.javacompiler.JsonFile.Json_Data_Get;
import example.ybdesire.com.javacompiler.View.View_MC_Question;

public class Note_Page extends AppCompatActivity {

    private ArrayList<String> note_content = new ArrayList<>();
    RecyclerView mRecyclerView;

    public String[] str;
    private int getInListView = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        mRecyclerView = (RecyclerView) findViewById(R.id.note);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            getInListView = extras.getInt("tutorial");
            //The key argument here must match that used in the other activity
        }


        try {
            List<String> Note = Json_Data_Get.getJsonArray("note", getAssets().open("user_db.json"), getInListView);
//            String PageCount = Note.get(getInListView);

            if(Note!=null) {
                for (String note_data : Note) {
                    note_content.add(note_data);
                }
            }
//            noteData.add(d.toString());
//            note_text.add(Note.get(getInListView));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Adapter_Note_Content Content_Adapter = new Adapter_Note_Content(this, note_content);
//        Adapter_Note_Image Image_Adapter = new Adapter_Note_Image(this,note_image);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(Content_Adapter);


        Button gomuitplechoice = (Button) findViewById(R.id.MC);
        gomuitplechoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MChoice();
            }
        });

        Button goExcise = (Button) findViewById(R.id.exercise_now);
        goExcise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView();
            }
        });
    }


    public void openListView() {
        Intent intent = new Intent(this, Excises_Java_Compiler.class);
        intent.putExtra("Qustion", getInListView);
        startActivity(intent);
    }

    public void MChoice() {
        Intent intent = new Intent(this, View_MC_Question.class);
        intent.putExtra("Qustion", getInListView);
        startActivity(intent);
    }

}
