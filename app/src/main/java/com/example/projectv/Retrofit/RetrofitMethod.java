package com.example.projectv.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitMethod {

    @GET("index.php?route=restapi/categories1")
    Call<RetrofitModel> getCategories();

    @GET("index.php?route=restapi/categories1")
    Call<ChildModel> getsubcat();

    @GET("index.php?route=restapi/categories/productslist")
    Call<ProductModel> getAlldata(@Query("category") String category, @Query("website") String website, @Query("page") String page, @Query("limit") String limit);
}
