package io.giodude.atry.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.atry.Connection.Repositories;
import io.giodude.atry.Model.UserModel;

public class UserViewModel extends ViewModel {

    private MutableLiveData<List<UserModel>> user;
    public Repositories repositories;

    public void init(){
        if (user != null){
            return;
        }
        repositories = Repositories.getInstance();
        user = repositories.getUSER();
    }

    public LiveData<List<UserModel>> getuser(){
        return user;
    }
}
