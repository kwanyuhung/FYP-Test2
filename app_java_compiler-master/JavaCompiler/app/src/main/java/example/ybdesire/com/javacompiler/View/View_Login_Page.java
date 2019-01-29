package example.ybdesire.com.javacompiler.View;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;

import example.ybdesire.com.javacompiler.DBConnector;
import example.ybdesire.com.javacompiler.R;

public class View_Login_Page extends AppCompatActivity {

    private AppCompatEditText user_id;
    private AppCompatEditText user_pw;


    private AppCompatTextView create_user;

    private AppCompatButton login_button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);



        Button create_user = (Button)findViewById(R.id.create_user);
        create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo create user page

            }
        });

        Button login_button = (Button)findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo create user page

            }
        });
    }



}
