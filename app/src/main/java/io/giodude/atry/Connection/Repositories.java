package io.giodude.atry.Connection;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.giodude.atry.Model.ProductModel;
import io.giodude.atry.Model.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories {

    private static Repositories instance;
    static ApiClient rfit = new ApiClient();

    public static Repositories getInstance(){
        if (instance == null){
            instance = new Repositories();
        }
        return instance;
    }

    public MutableLiveData<List<UserModel>> getUSER(){
        final MutableLiveData<List<UserModel>> userData = new MutableLiveData<>();
        Call<List<UserModel>> call = rfit.retrofitBuilderUser().getUsers();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                try {
                    List<UserModel> userList = response.body();
                    userData.setValue(userList);
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });
        return userData;
    }


    public MutableLiveData<List<ProductModel>> getProduct(){
        final MutableLiveData<List<ProductModel>> productData = new MutableLiveData<>();
        Call<List<ProductModel>> call = rfit.retrofitBuilderProduct().getProducts();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                List<ProductModel> productList = response.body();
                productData.setValue(productList);
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                productData.setValue(null);
            }
        });
        return productData;
    }
}
