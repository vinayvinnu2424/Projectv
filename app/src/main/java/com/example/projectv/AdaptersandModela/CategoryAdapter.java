package com.example.projectv.AdaptersandModela;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectv.R;
import com.example.projectv.Retrofit.CustomItemThree;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter  extends RecyclerView.Adapter {
    CustomItemThree customItemThree;
    Context context;
    static List<CategoryModel> my_data;
    CategoryModel categoriesModel;


    public CategoryAdapter(ArrayList<CategoryModel> my_data, Context context, CustomItemThree customItemThree) {
        this.my_data = my_data;
        this.context = context;
        this.customItemThree = customItemThree;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_tems, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuViewHolder holder1 = (MenuViewHolder) holder;
        categoriesModel = my_data.get(position);

        holder1.txt_name.setText(categoriesModel.getName());

        if (categoriesModel.getImage() == null || categoriesModel.getImage().equalsIgnoreCase("")) {
        } else {
            Glide.with(context)
                    .load( "https://www.epoojastore.in/image/"+categoriesModel.getImage())
                    .placeholder(R.drawable.vinnu_bg)
                    .error(R.drawable.vinay_bg)
                    .into(((MenuViewHolder) holder).img_pro);
        }


    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
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
                public void onClick(View view) {
//                    String image = my_data.get(getAdapterPosition()).getImage();
//                    String name = my_data.get(getAdapterPosition()).getName();
//                    Context context = view.getContext();
//                    Intent intent = new Intent(context, APIS_Activity.class);
//                    intent.putExtra("image",image);
//                    intent.putExtra("name",name);
//                    context.startActivity(intent);

                }
            });



        }
    }
}
