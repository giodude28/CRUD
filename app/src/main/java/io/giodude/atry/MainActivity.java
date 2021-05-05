package io.giodude.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.giodude.atry.Connection.ApiClient;
import io.giodude.atry.Connection.ApiInterface;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText f,m,l;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f = findViewById(R.id.fid);
        m = findViewById(R.id.mid);
        l = findViewById(R.id.lid);
        b = findViewById(R.id.btn);

        b.setOnClickListener(v -> {
        insertdata();
        });
    }
    private void insertdata(){
        String first = f.getText().toString().trim();
        String middle = m.getText().toString().trim();
        String last = l.getText().toString().trim();

        if (first.isEmpty()){
            f.setError("Enter Name");
            f.requestFocus();
            return;
        }
        if (middle.isEmpty()){
            f.setError("Enter Name");
            f.requestFocus();
            return;
        }
        if (last.isEmpty()){
            f.setError("Enter Name");
            f.requestFocus();
            return;
        }

        Call<ResponseBody> call = ApiClient.getInstance().getApiInterface().Insertdata(first,middle,last);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("Data","Registered");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}