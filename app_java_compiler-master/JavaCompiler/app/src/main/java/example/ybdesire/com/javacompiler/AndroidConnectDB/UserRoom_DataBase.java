package example.ybdesire.com.javacompiler.AndroidConnectDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User_DataBase.class}, version = 1)
public abstract class UserRoom_DataBase extends RoomDatabase {


    public abstract UserDao UserDao();

    private static volatile UserRoom_DataBase INSTANCE;

    static UserRoom_DataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserRoom_DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoom_DataBase.class, "User_DataBase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
