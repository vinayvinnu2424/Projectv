package com.example.projectv.Fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.projectv.AdaptersandModela.RetrofitAdapter;
import com.example.projectv.AdaptersandModela.RetrofitItemthree;
import com.example.projectv.R;
import com.example.projectv.Retrofit.RetrofitMethod;
import com.example.projectv.Retrofit.RetrofitModel;
import com.example.projectv.Retrofit.Retrofiturl;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Favourite_Fragment extends Fragment {

    RelativeLayout relative_pro;

    RecyclerView recyclerview;
    RetrofitAdapter retrofitAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite_, container, false);
        relative_pro = view.findViewById(R.id.relative_pro);

        //recyclerview list
        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(),3));


        Retrofitcategoriesdata();

        return view;
    }

    private void Retrofitcategoriesdata() {
        RetrofitMethod retrofitMethod = Retrofiturl.getRetrofitInstance().create(RetrofitMethod.class);
        Call<RetrofitModel> call = retrofitMethod.getCategories();

        call.enqueue(new Callback<RetrofitModel>() {
            @Override
            public void onResponse(Call<RetrofitModel> call, Response<RetrofitModel> response) {
                Log.e(TAG, "onResponse: "+response.code() );

                RetrofitModel retrofitModel = response.body();

                if (retrofitModel!=null){
                    retrofitAdapter = new RetrofitAdapter(retrofitModel.getCategories(),getActivity(), new RetrofitItemthree(){
                        @Override
                        public void onItemClick(View view, String category_id, String name, String image) {

                        }
                    });
                    recyclerview.setAdapter(retrofitAdapter);
                }else {
                    Toast.makeText(getActivity(),"No Data",Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<RetrofitModel> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });


    }
}