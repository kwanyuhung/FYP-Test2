package example.ybdesire.com.javacompiler.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.ybdesire.com.javacompiler.Note_Page;
import example.ybdesire.com.javacompiler.R;
import example.ybdesire.com.javacompiler.Tutorial_Page;

public class View_Main_page extends AppCompatActivity {


    public void openListView(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button gomuitplechoice = findViewById(R.id.tutorial);
        gomuitplechoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(Note_Page.class);
            }
        });

//        Button compiler = findViewById(R.id.button_compiler);
//        compiler.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openListView();
//            }
//        });

//        Button tutorial = findViewById(R.id.tutorial);
//        tutorial.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openListView(Tutorial_Page.class);
//            }
//        });


//        Button work = findViewById(R.id.work);
//        work.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               openListView();
//            }
//        });

//        Button my_information = findViewById(R.id.information);
//        my_information.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openListView();
//            }
//        });
    }
}
