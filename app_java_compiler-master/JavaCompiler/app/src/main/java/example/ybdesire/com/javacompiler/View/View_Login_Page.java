package example.ybdesire.com.javacompiler.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import example.ybdesire.com.javacompiler.DBConnector;
import example.ybdesire.com.javacompiler.JsonFile.Json_Data_Get;
import example.ybdesire.com.javacompiler.R;
import example.ybdesire.com.javacompiler.Tutorial_Page;

public class View_Login_Page extends AppCompatActivity {


    private AppCompatEditText user_id;
    private AppCompatEditText user_pw;

    private AppCompatTextView status;

    private AppCompatTextView create_user;

    private AppCompatButton login_button;

    public void openListView() {
        Intent intent = new Intent(this, Tutorial_Page.class);
        startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        user_id = (AppCompatEditText)findViewById(R.id.user_id);
        user_pw = (AppCompatEditText)findViewById(R.id.user_pw);

        status = (AppCompatTextView)findViewById(R.id.status);


//        Button create_user = (Button)findViewById(R.id.create_user);
//        create_user.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //todo create user page
//
//            }
//        });

        Button login_button = (Button)findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo create user page

                if(!user_id.getText().toString().equals("") && !user_pw.getText().toString().equals("")){
                    InputStream inputStream = null;
                    try {
                        inputStream = getAssets().open("user_db.json");
                        InputStreamReader streamReader = new InputStreamReader(inputStream);
                        int size = inputStream.available();
                        byte[] buffer = new byte[size];
                        inputStream.read(buffer);
                        inputStream.close();
                        String json_toSring = new String(buffer, "UTF-8");

                        boolean checkLogin = Json_Data_Get.CheckLogin(json_toSring,user_id.getEditableText().toString(),user_pw.getEditableText().toString());
                        if(checkLogin){
                            status.setText("Login success");
                            Toast.makeText(View_Login_Page.this,"Login success",Toast.LENGTH_SHORT).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    openListView();
                                }
                            }, 1000);
                        }else {
                            status.setText("Login Fail");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }else {
                    status.setText("You are not input your ID & PW");
                }

            }
        });
    }



}
