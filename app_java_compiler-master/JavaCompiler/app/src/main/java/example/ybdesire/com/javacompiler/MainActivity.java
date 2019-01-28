package example.ybdesire.com.javacompiler;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.*;

public class MainActivity extends AppCompatActivity {

    public  String Tojson(String T){
        if(T!=null){
            T= T.replaceAll("\n","");
            T= T.replaceAll("\"","\\\\\"");
        }
        return T;
    }

    private void setText(final TextView text,final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

    private String Question = "Null";


    public  void checkAnswer(String answer){
        try {
            String result = DBConnector.executeQuery("SELECT fyp.note FROM user.fyp where id = " );//+ getinlistview);
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonData = jsonArray.getJSONObject(0);
        } catch(Exception e) {
            Log.e("log_tag", e.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excises);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Question = extras.getString("Qustion");
            //The key argument here must match that used in the other activity
        }


        TextView q = (TextView) findViewById(R.id.excise);

        try {
            String result = DBConnector.executeQuery("SELECT fyp.excise FROM user.fyp where id = " + Question);
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonData = jsonArray.getJSONObject(0);
            q.setText(jsonData.getString("excise"));
        } catch(Exception e) {
            Log.e("log_tag", e.toString());
        }



        //Edit Text
        final AppCompatEditText editText = (AppCompatEditText) findViewById(R.id.text_input_code);

        //Buttons
        Button btn=findViewById(R.id.button_tab);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(), "    ");
            }
        });
        btn=findViewById(R.id.button_println);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(), "System.out.println(  )");
            }
        });
        btn=findViewById(R.id.button_quote);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(), "\"");
            }
        });
        btn=findViewById(R.id.button_semi);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(), ";");
            }
        });
        // compile
        btn=findViewById(R.id.button_compile);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        String clientId = "f953642289eac0b6c09700acf13933d4"; //Replace with your client ID
                        String clientSecret = "64d5319179ab4d1ae770f77f5719466720cbbf20e13ec317111c47583e979d35"; //Replace with your client Secret
                        String text = editText.getText().toString();
                        String script = Tojson(text);
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
                            while ((output = bufferedReader.readLine()) != null) {
                                JSONObject Jsonparam;
                                try {
                                    Jsonparam = new JSONObject(output);
                                    Object JoutputJ = Jsonparam.get("output");
                                    TextView txtOutput=findViewById(R.id.txt_output);
                                    setText(txtOutput,JoutputJ.toString());



                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }


                            connection.disconnect();
                        }
                            catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                });

                thread.start();
                //disable button and modify color
                Button btnc=findViewById(R.id.button_compile);
                btnc.setClickable(false);
                btnc.setBackgroundColor(Color.GRAY);

                //timer for 5s delay and enable button
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Button btncc=findViewById(R.id.button_compile);
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
                

                if(cs.toString().substring(start,start+1).equals(" "))
                {
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
                //Log.d("DBG", "beforeTextChanged");
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Log.d("DBG", "afterTextChanged");
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
