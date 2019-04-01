package example.ybdesire.com.javacompiler.Json;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FYP_Dao {

    @Query("select * FROM Table_FYP")
    public List<FYP> getUserList();

    @Query("select * FROM Table_FYP WHERE name = :name")
    FYP getUserByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(FYP userEntity);

    @Delete()
    void deleteUser(FYP userEntity);

}
