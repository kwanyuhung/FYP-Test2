package example.ybdesire.com.javacompiler.View;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import example.ybdesire.com.javacompiler.CodeEditText;
import example.ybdesire.com.javacompiler.R;

public class View_Main_Compiler extends AppCompatActivity {

    public String To_json(String T) {
        if (T != null) {
            T = T.replaceAll("\n", "");
            T = T.replaceAll("\"", "\\\\\"");
        }
        return T;
    }

    private void setText(final TextView text, final String value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

    private int Question = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_compiler);

        //Edit Text
        final AppCompatEditText editText = (AppCompatEditText) findViewById(R.id.text_input_code);

        //Buttons
        Button btn = findViewById(R.id.button_tab);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(), "    ");
            }
        });
        btn = findViewById(R.id.button_println);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(), "System.out.println(  )");
            }
        });
        btn = findViewById(R.id.button_quote);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(), "\"");
            }
        });
        btn = findViewById(R.id.button_semi);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(), ";");
            }
        });

        // compile
        btn = findViewById(R.id.button_compile);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        String clientId = "f953642289eac0b6c09700acf13933d4"; //Replace with your client ID
                        String clientSecret = "64d5319179ab4d1ae770f77f5719466720cbbf20e13ec317111c47583e979d35"; //Replace with your client Secret
                        String text = editText.getText().toString();
                        String script = To_json(text);
                        String language = "java";
                        String versionIndex = "2";
                        try {
                            URL url = new URL("https://api.jdoodle.com/v1/execute");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setDoOutput(true);
                            connection.setRequestMethod("POST");
                            connection.setRequestProperty("Content-Type", "application/json");


                            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + script +
                                    "\",\"language\":\"" + language + "\",\"versionIndex\":\"" + versionIndex + "\"} ";

                            OutputStream outputStream = connection.getOutputStream();
                            outputStream.write(input.getBytes());
                            outputStream.flush();

                            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                                throw new RuntimeException("Please check your inputs : HTTP error code : " + connection.getResponseCode());
                            }

                            BufferedReader bufferedReader;
                            bufferedReader = new BufferedReader(new InputStreamReader(
                                    (connection.getInputStream())));

                            String output;
                            System.out.println("Output from JDoodle .... \n");
                            while ((output = bufferedReader.readLine()) != null) {
                                JSONObject Jsonparam;
                                try {
                                    Jsonparam = new JSONObject(output);
                                    Object JoutputJ = Jsonparam.get("output");
                                    TextView txtOutput = findViewById(R.id.txt_output);
                                    setText(txtOutput, JoutputJ.toString());

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }


                            connection.disconnect();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();
                //disable button and modify color
                Button btnc = findViewById(R.id.button_compile);
                btnc.setClickable(false);
                btnc.setBackgroundColor(Color.GRAY);

                //timer for 5s delay and enable button
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Button btncc = findViewById(R.id.button_compile);
                        btncc.setClickable(true);
                        btncc.setBackgroundResource(android.R.drawable.btn_default);
                    }
                }, 5000);


            }
        });


        //init
        String str = "public class Main\n{\n    public static void main(String[] arg)\n    {\n        System.out.println(\"hello world\");\n    }\n }";
        SpannableString ss = CodeEditText.setHighLight(str);
        editText.setText(ss);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int start, int count, int after) {


                if (cs.toString().substring(start, start + 1).equals(" ")) {
                    //Log.d("onTextChanged", "get space");
                    /*
                    SpannableString ss = new SpannableString(cs.toString());
                    String textToSearch = "public";
                    Pattern pattern = Pattern.compile(textToSearch);
                    Matcher matcher = pattern.matcher(ss);
                    while (matcher.find()) {
                        ss.setSpan(new ForegroundColorSpan(Color.RED), matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                    edittext.setText(ss);
                    */
                }

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//                Log.d("DBG", "kwan beforeTextChanged");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("DBG", "kwan afterTextChanged");
                editText.removeTextChangedListener(this);
                String str = editText.getText().toString();

                int po = editText.getSelectionStart();//get cursor
                SpannableString ss = CodeEditText.setHighLight(str);
                editText.setText(ss);

                editText.setSelection(po);//set cursor
                editText.addTextChangedListener(this);

            }

        });
    }
}