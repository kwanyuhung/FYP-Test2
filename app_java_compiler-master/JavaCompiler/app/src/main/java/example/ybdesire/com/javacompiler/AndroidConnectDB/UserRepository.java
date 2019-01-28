package example.ybdesire.com.javacompiler.AndroidConnectDB;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import androidx.room.RoomDatabase;

public class UserRepository {


    private UserDao mUserDao;
    private LiveData<List<User_DataBase>> mAllUsers;

    UserRepository(Application application) {
        UserRoom_DataBase db = UserRoom_DataBase.getDatabase(application);
        mUserDao = db.UserDao();
        mAllUsers = mUserDao.getAllWords();
    }

    LiveData<List<User_DataBase>> getAllWords() {
        return mAllUsers;
    }


    public void insert (User_DataBase user_dataBase) {
        new insertAsyncTask(mUserDao).execute(user_dataBase);
    }

    private static class insertAsyncTask extends AsyncTask<User_DataBase, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User_DataBase... user_dataBases) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
