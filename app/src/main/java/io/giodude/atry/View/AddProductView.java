package io.giodude.atry.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import io.giodude.atry.Connection.ApiClient;
import io.giodude.atry.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductView extends AppCompatActivity {
EditText pname,size;
Spinner spin1,spin2;
Object test1,test2;
Button btns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_view);
        pname = findViewById(R.id.productName);
        size = findViewById(R.id.productSize);
        spin1 = findViewById(R.id.spinType);
        spin2 = findViewById(R.id.spinmeasure);
        btns = findViewById(R.id.btn);
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(AddProductView.this, R.array.Category, R.layout.support_simple_spinner_dropdown_item);
        categoryAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin1.setAdapter(categoryAdapter);
       spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               test1 = parent.getItemAtPosition(position);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
        ArrayAdapter<CharSequence> measureAdapter = ArrayAdapter.createFromResource(this, R.array.Measure, R.layout.support_simple_spinner_dropdown_item);
        measureAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin2.setAdapter(measureAdapter);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                test2 = parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btns.setOnClickListener(v -> {
            insertdata();
        });
    }

    private void insertdata(){
        String pnames = pname.getText().toString().trim();
        String psize = size.getText().toString().trim();
        String ppsize = psize + test2.toString();
        String pcat = test1.toString();

        if (pnames.isEmpty()){
            pname.setError("Enter Name");
            pname.requestFocus();
            return;
        }
        if (ppsize.isEmpty()){
            size.setError("Enter Name");
            size.requestFocus();
            return;
        }

        Call<ResponseBody> call = ApiClient.getInstance().getApiInterface().Insertdata(pnames,pcat,ppsize);
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