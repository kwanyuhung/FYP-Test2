package example.ybdesire.com.javacompiler.AndroidConnectDB;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;

    private LiveData<List<User_DataBase>> mAllUsers;

    public UserViewModel (Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllWords();
    }

    LiveData<List<User_DataBase>> getAllWords() { return mAllUsers; }

    public void insert(User_DataBase word) { mRepository.insert(word); }
}
