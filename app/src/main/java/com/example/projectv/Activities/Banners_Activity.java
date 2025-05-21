package com.example.projectv.Activities;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectv.AdaptersandModela.CategoryModel;
import com.example.projectv.AdaptersandModela.ChildItemthree;
import com.example.projectv.AdaptersandModela.RetrofitAdapter;
import com.example.projectv.AdaptersandModela.RetrofitItemthree;
import com.example.projectv.Retrofit.ChildModel;
import com.example.projectv.Retrofit.Childadapter;
import com.example.projectv.R;
import com.example.projectv.Retrofit.ProductModel;
import com.example.projectv.Retrofit.RetrofitMethod;
import com.example.projectv.Retrofit.RetrofitModel;
import com.example.projectv.Retrofit.Retrofiturl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Banners_Activity extends AppCompatActivity {
    ImageView img_close;
    TextView txt_title1;
    String parent_id = "";
    String Name = "";

    RecyclerView recyclerview;
    Childadapter childAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banners);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            parent_id = b.getString("parent_id");
            Name = b.getString("Name");
        }

        txt_title1 = findViewById(R.id.txt_title1);
        img_close = findViewById(R.id.img_close);
        recyclerview = findViewById(R.id.recyclerview);
        txt_title1.setText(Name);


        getsubcat();

        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void getsubcat() {
        RetrofitMethod retrofitMethod = Retrofiturl.getRetrofitInstance().create(RetrofitMethod.class);
        Call<RetrofitModel> call = retrofitMethod.getCategories();

        call.enqueue(new Callback<RetrofitModel>() {
            @Override
            public void onResponse(Call<RetrofitModel> call, Response<RetrofitModel> response) {
                Log.e(TAG, "onResponse: " + response.code());

                RetrofitModel retrofitModel = response.body();

                if (retrofitModel != null) {

                    for (int i = 0; i < retrofitModel.getCategories().size(); i++) {

                        if (retrofitModel.getCategories().get(i).getSubcategories() != null) {

                            for (int j = 0; j < retrofitModel.getCategories().get(i).getSubcategories().size(); j++) {

                                if (parent_id.equalsIgnoreCase(retrofitModel.getCategories().get(i).getSubcategories().get(j).getParent_id())) {
                                    recyclerview.setLayoutManager(layoutManager);
                                    recyclerview.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                                    childAdapter = new Childadapter(retrofitModel.getCategories().get(i).getSubcategories(), Banners_Activity.this, new ChildItemthree() {
                                        @Override
                                        public void onItemClick(View view, String category_id, String name, String image) {

                                        }
                                    });
                                    recyclerview.setAdapter(childAdapter);
                                }

                            }

                        }


                    }


                } else {
                    Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<RetrofitModel> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

}