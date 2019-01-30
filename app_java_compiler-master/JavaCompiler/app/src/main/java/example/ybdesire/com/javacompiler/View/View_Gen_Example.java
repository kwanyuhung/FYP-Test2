package example.ybdesire.com.javacompiler.View;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import java.util.Random;

import example.ybdesire.com.javacompiler.R;

public class View_Gen_Example  extends AppCompatActivity {





    private AppCompatTextView shape;
    private AppCompatTextView cal;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_question);


        shape = (AppCompatTextView)findViewById(R.id.shape);
        cal = (AppCompatTextView)findViewById(R.id.cal);

        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');

        //rect
        int width = r.nextInt(6) + 5; // 5 -10
        int height = r.nextInt(6) +5;

        String Rect = "";

        for (int w = 1; w <= width; w++)
        {
            for (int h = 1; h <= height; h++)
            {
                Rect.concat(String.valueOf(c));
            }
            Rect.concat("\n");
        }

        shape.setText(Rect);

    }
}
