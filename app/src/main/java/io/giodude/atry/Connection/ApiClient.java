package io.giodude.atry.Connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL ="http://192.168.41.20";
    private static ApiClient apiClient;
    private Retrofit retrofit;

    public ApiClient(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance(){
        if (apiClient == null){
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public ApiInterface getApiInterface(){
        return retrofit.create(ApiInterface.class);
    }

    public static ApiInterface retrofitBuilderUser(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.USERLIST_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiInterface apiCall = retrofit.create(ApiInterface.class);

        return apiCall;
    }

    public static ApiInterface retrofitBuilderProduct(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.PRODUCTLIST_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiInterface apiCall = retrofit.create(ApiInterface.class);

        return apiCall;
    }


}
