package example.ybdesire.com.javacompiler.AndroidConnectDB;

import android.support.annotation.NonNull;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;

@Entity(tableName = "User_table")
public class User_DataBase {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "User_DataBase")
    private String User;

    public User_DataBase(@NonNull String User_DataBase) {this.User = User_DataBase;}

    public String getWord(){return this.User;}
}

