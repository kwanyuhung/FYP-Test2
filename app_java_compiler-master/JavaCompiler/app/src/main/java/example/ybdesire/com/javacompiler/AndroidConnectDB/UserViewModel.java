package example.ybdesire.com.javacompiler.AndroidConnectDB;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;

    private LiveData<List<User>> mAllUsers;

    public UserViewModel (Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllWords();
    }

    LiveData<List<User>> getAllWords() { return mAllUsers; }

    public void insert(User word) { mRepository.insert(word); }
}
