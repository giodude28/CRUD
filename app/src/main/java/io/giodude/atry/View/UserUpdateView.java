package io.giodude.atry.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.giodude.atry.Connection.ApiClient;
import io.giodude.atry.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserUpdateView extends AppCompatActivity {
EditText fn,mn,ln;
Button btnup;
String id;
//Intent i = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update_view);
        fn = findViewById(R.id.fidupdate);
        mn = findViewById(R.id.midupdate);
        ln = findViewById(R.id.lidupdate);
//        String ff =
        fn.setText(getIntent().getStringExtra("firstname"));
        mn.setText(getIntent().getStringExtra("middlename"));
        ln.setText(getIntent().getStringExtra("lastname"));
        id = getIntent().getStringExtra("userid");

        btnup = findViewById(R.id.btnupdate);

        btnup.setOnClickListener(v -> updateData());
    }


    public void updateData(){
        String first = fn.getText().toString().trim();
        String middle = mn.getText().toString().trim();
        String last = ln.getText().toString().trim();

        if (first.isEmpty()){
            fn.setError("Enter Name");
            fn.requestFocus();
            return;
        }
        if (middle.isEmpty()){
            mn.setError("Enter Name");
            mn.requestFocus();
            return;
        }
        if (last.isEmpty()){
            ln.setError("Enter Name");
            ln.requestFocus();
            return;
        }


        Call<ResponseBody> call = ApiClient.getInstance().getApiInterface().updateUser(id,first,middle,last);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("Data","Updated");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}