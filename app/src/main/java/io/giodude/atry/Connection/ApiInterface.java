package io.giodude.atry.Connection;

import android.renderscript.Sampler;

import java.util.List;

import io.giodude.atry.Model.ProductModel;
import io.giodude.atry.Model.UserModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

   @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseBody>Insertdata(
            @Field("ProductName")String first,
            @Field("ProductCategory")String middle,
            @Field("UnitSize")String last
    );

   String USERLIST_URL ="http://192.168.41.20/";

   @GET("retrieve.php")
    Call<List<UserModel>> getUsers();

    String PRODUCTLIST_URL ="http://192.168.41.20/";

    @GET("retrieve.php")
    Call<List<ProductModel>> getProducts();

   @FormUrlEncoded
    @POST("update.php")
    Call<ResponseBody> updateUser(
            @Field("UserID")String userid,
            @Field("Firstname")String fname,
            @Field("Middlename")String mname,
            @Field("Lastname")String lname
        );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseBody> deleteUser(
            @Field("UserID")String userid
    );

}
