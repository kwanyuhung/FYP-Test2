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
    private String TAG = "输出";

    private ArrayList<String> note_text = new ArrayList<>();
    private ArrayList<Integer> note_image = new ArrayList<>();
    RecyclerView mRecyclerView;

    public String[] str;
    private int getInListView = 0;

    public void MChoice() {
        Intent intent = new Intent(this, View_MC_Question.class);
        startActivity(intent);
    }


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
                    note_text.add(note_data);
                }
            }
//            noteData.add(d.toString());
//            note_text.add(Note.get(getInListView));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Adapter_Note_Content Content_Adapter = new Adapter_Note_Content(this, note_text);
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


//    private void databaseOp() {
//
//        AppDatabase fyp = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Fyp").build();
//        FYP_Dao fyp_dao = fyp.getUserFYPDao();
//
//        //写数据库
//        Log.d(TAG, "开始写入数据...");
//        writeDatabase(fyp_dao, "张三", "18");
//        writeDatabase(fyp_dao, "李四", "19");
//        Log.d(TAG, "写入数据库完毕.");
//
//        //读数据库
//        Log.d(TAG, "第1次读数据库");
//        readDatabase(fyp_dao);
//
//        //更新数据库
//        updateUser(fyp_dao);
//
//        //读数据库
//        Log.d(TAG, "第2次读数据库");
//        readDatabase(fyp_dao);
//
//        //删除数据，根据主键id
//        deleteUser(fyp_dao, 1);
//
//        //读数据库
//        Log.d(TAG, "第3次读数据库");
//        readDatabase(fyp_dao);
//
//        Log.d(TAG, "========================");
//        Log.d(TAG, "本轮数据库操作事务全部结束");
//        Log.d(TAG, "========================");
//
//
//
//    }


//    private void readDatabase(FYP_Dao dao) {
//        Log.d(TAG, "读数据库...");
//        List<FYP> users = dao.getUserList();
//        for (FYP u : users) {
//            Log.d(TAG, u.get_id() + "," + u.getName() + "," + u.getAge());
//        }
//        Log.d(TAG, "读数据库完毕.");
//    }
//
//    private void writeDatabase(FYP_Dao dao, String name, String age) {
//        FYP user = new FYP();
//        user.setName(name);
//        user.setAge(age);
//        dao.addUser(user);
//    }
//
//    private void updateUser(FYP_Dao dao) {
//        Log.d(TAG, "更新数据库...");
////        FYP u = new FYP();
////        u.id = 2;
////        u.name = "赵五";
////        u.age = 20;
////        u.updateTime = System.currentTimeMillis();
////        dao.updateUser(u);
//        Log.d(TAG, "更新数据库完毕.");
//    }
//
//    private void deleteUser(FYP_Dao dao, int id) {
////        Log.d(TAG, "删除数据库...");
////        User u = new User();
////        u.id = id;
////        dao.deleteUser(u);
////        Log.d(TAG, "删除数据库完毕.");
//    }

}
