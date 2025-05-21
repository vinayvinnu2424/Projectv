package com.example.projectv.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectv.AdaptersandModela.CategoryAdapter;
import com.example.projectv.AdaptersandModela.CategoryModel;
import com.example.projectv.Retrofit.CustomItemThree;
import com.example.projectv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Home_Fragment extends Fragment {
    private static final String TAG = "Home_Fragment";
    RelativeLayout relative_pro;

    RecyclerView recyclerview;
    CategoryAdapter categoryAdapter;
    ArrayList<CategoryModel> categoryModels;

    JSONArray subcategoriesArray;

    String url = "https://www.epoojastore.in/index.php?route=restapi/categories1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_, container, false);
        relative_pro = view.findViewById(R.id.relative_pro);

        //recyclerview list
        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(),3));
        categoryModels = new ArrayList<>();

        Category_data();

        return view;


    }

    private void Category_data() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.e(TAG, "onResponseresponse: "+response );

                    JSONArray jsonArray = jsonObject.getJSONArray("Categories");
                    for ( int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jns = jsonArray.getJSONObject(i);

                        String category_id = jns.getString("category_id");
                        String name = jns.getString("name");
                        String image = jns.getString("image");
                        String Issubcategories = jns.getString("Issubcategories");
                        if (Issubcategories.equalsIgnoreCase("1")){
                            subcategoriesArray = jns.getJSONArray("subcategories");
                        }else {
                        }

                        CategoryModel categorieskey = new CategoryModel();
                        categorieskey.setCategory_id(category_id);
                        categorieskey.setName(name);
                        categorieskey.setImage(image);
                        categorieskey.setIssubcategories(Issubcategories);
                        categorieskey.setSubcategoriesArray(subcategoriesArray+"");
                        categoryModels.add(categorieskey);
                    }
                    adapter_Code();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            private void adapter_Code() {
                categoryAdapter = new CategoryAdapter(categoryModels,getActivity(), new CustomItemThree(){
                    @Override
                    public void onItemClick(View view, String category_id, String name, String image) {

                    }
                });
                recyclerview.setAdapter(categoryAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                999999990,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(request);
    }
}