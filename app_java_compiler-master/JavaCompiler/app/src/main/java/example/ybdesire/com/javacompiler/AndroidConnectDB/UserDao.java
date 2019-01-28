package example.ybdesire.com.javacompiler.AndroidConnectDB;

import android.arch.lifecycle.LiveData;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * from User_table ORDER BY User_DataBase ASC")
    LiveData<List<User_DataBase>> getAlphabetizedWords();

    // We do not need a conflict strategy, because the word is our primary key, and you cannot
    // add two items with the same primary key to the database. If the table has more than one
    // column, you can use @Insert(onConflict = OnConflictStrategy.REPLACE) to update a row.
    @Insert
    void insert(User_DataBase user_dataBase);

    @Query("DELETE FROM User_table")
    void deleteAll();
}
