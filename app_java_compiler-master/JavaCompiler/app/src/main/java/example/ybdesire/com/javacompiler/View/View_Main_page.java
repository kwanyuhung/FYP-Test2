package example.ybdesire.com.javacompiler.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

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

        ImageButton compiler = findViewById(R.id.compiler);
        compiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(View_Main_Compiler.class);
            }
        });

        ImageButton performance = findViewById(R.id.work);
        performance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(View_performance.class);
            }
        });

        ImageButton tutorial = findViewById(R.id.tutorial);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(Tutorial_Page.class);
            }
        });
    }
}
