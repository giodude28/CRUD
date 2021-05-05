package io.giodude.atry.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.giodude.atry.Adapter.UserAdapter;
import io.giodude.atry.Model.UserModel;
import io.giodude.atry.R;
import io.giodude.atry.ViewModel.UserViewModel;

public class UserView extends AppCompatActivity {
private UserViewModel userViewModel;
private UserAdapter userAdapter;
private List<UserModel> umodel = new ArrayList<>();
private static RecyclerView recyclerView;
private RecyclerView.LayoutManager out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        showusers();

    }


    private void getUsers(List<UserModel> user){
        recyclerView = findViewById(R.id.recyclerview);
        out = new LinearLayoutManager(UserView.this);
        recyclerView.setLayoutManager(out);
        userAdapter = new UserAdapter(UserView.this,user);
        recyclerView.setAdapter(userAdapter);
    }

    private void showusers(){
        userViewModel = ViewModelProviders.of(UserView.this).get(UserViewModel.class);
        userViewModel.init();

        userViewModel.getuser().observe(this, userModels -> {
            getUsers(userModels);
            umodel.addAll(userModels);
            userAdapter.notifyDataSetChanged();
        });
    }

}