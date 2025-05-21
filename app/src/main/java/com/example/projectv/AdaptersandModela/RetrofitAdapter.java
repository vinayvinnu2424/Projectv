package com.example.projectv.AdaptersandModela;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectv.Activities.APIS_Activity;
import com.example.projectv.Activities.Banners_Activity;
import com.example.projectv.R;
import com.example.projectv.Retrofit.RetrofitModel;

import java.util.ArrayList;
import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter {
    RetrofitItemthree retrofitItemthree;
    Context context;
    static List<RetrofitModel.Categories> my_data;
    RetrofitModel.Categories retrofitModel;

    public RetrofitAdapter(ArrayList<RetrofitModel.Categories> my_data, Context context, RetrofitItemthree retrofitItemthree) {
        this.my_data = my_data;
        this.context = context;
        this.retrofitItemthree = retrofitItemthree;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_tems, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RetrofitAdapter.MenuViewHolder holder1 = (RetrofitAdapter.MenuViewHolder) holder;
        retrofitModel = my_data.get(position);

        holder1.txt_name.setText(retrofitModel.getName());

        if (retrofitModel.getImage() == null || retrofitModel.getImage().equalsIgnoreCase("")) {
        } else {
            Glide.with(context)
                    .load( "https://www.epoojastore.in/image/"+retrofitModel.getImage())
                    .placeholder(R.drawable.vinnu_bg)
                    .error(R.drawable.vinay_bg)
                    .into(((RetrofitAdapter.MenuViewHolder) holder).img_pro);
        }

    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    private class MenuViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linear_pro;
        ImageView img_pro;
        TextView txt_name;
        public MenuViewHolder(View view) {
            super(view);
            txt_name = view.findViewById(R.id.txt_name);
            linear_pro = view.findViewById(R.id.linear_pro);
            img_pro = view.findViewById(R.id.img_pro);

            img_pro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Issubcategories = my_data.get(getAdapterPosition()).getIssubcategories();

                    String parent_id = "";
                    if (my_data.get(getAdapterPosition()).getSubcategories()!=null){
                        for (int i = 0; i < my_data.get(getAdapterPosition()).getSubcategories().size(); i++) {
                            parent_id = my_data.get(getAdapterPosition()).getSubcategories().get(i).getParent_id();
                        }
                    }

                    String Category_id = my_data.get(getAdapterPosition()).getCategory_id();
                    String Name = my_data.get(getAdapterPosition()).getName();
                    if (Issubcategories.equalsIgnoreCase("0")){
                        Context context = v.getContext();
                        Intent vk = new Intent(context, APIS_Activity.class);
                        vk.putExtra("Category_id",Category_id);
                        vk.putExtra("Name",Name);
                        context.startActivity(vk);
                    }else if (Issubcategories.equalsIgnoreCase("1")){
                        Context context1 = v.getContext();
                        Intent vvk = new Intent(context1, Banners_Activity.class);
                        vvk.putExtra("Name",Name);
                        vvk.putExtra("parent_id",parent_id);
                        context1.startActivity(vvk);
                    }else{

                    }
                }
            });
        }
    }
}
