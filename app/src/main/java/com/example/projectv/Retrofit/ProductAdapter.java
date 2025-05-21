package com.example.projectv.Retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectv.AdaptersandModela.RetrofitAdapter;
import com.example.projectv.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {
    Productitemthree productItemThree;
    Context context;
    List<ProductModel.category_products> mdata;
    ProductModel.category_products productModel;

    public ProductAdapter(ArrayList<ProductModel.category_products> mdata, Context context, Productitemthree productItemThree){
        this.mdata = mdata;
        this.context = context;
        this.productItemThree = productItemThree;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_items,parent,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductAdapter.MenuViewHolder holder1 = (ProductAdapter.MenuViewHolder) holder;
        productModel = mdata.get(position);

        holder1.txt_name.setText(productModel.getName());
        holder1.txt_productcost.setText(productModel.actualprice);
        holder1.txt_rating.setText(productModel.rating);



        if (productModel.getImage() == null || productModel.getImage().equalsIgnoreCase("")) {
        } else {
            Glide.with(context)
                    .load( "https://www.epoojastore.in/image/"+productModel.getImage())
                    .placeholder(R.drawable.vinnu_bg)
                    .error(R.drawable.vinay_bg)
                    .into(((ProductAdapter.MenuViewHolder) holder).img_pro);
        }
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linear_pro;
        ImageView img_pro;
        TextView txt_name;
        TextView txt_productcost;
        TextView txt_rating;


        public MenuViewHolder(View view) {
            super(view);
            txt_name = view.findViewById(R.id.txt_name);
            txt_productcost = view.findViewById(R.id.txt_productcost);
            linear_pro = view.findViewById(R.id.linear_pro);
            img_pro = view.findViewById(R.id.img_pro);
            txt_rating = view.findViewById(R.id.txt_rating);




        }
    }
}
