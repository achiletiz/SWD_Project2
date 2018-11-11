package com.anhtnt.swd_project.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anhtnt.swd_project.Model.Product;
import com.anhtnt.swd_project.R;
import com.anhtnt.swd_project.Utils.ChangeValue;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.RecyclerViewHoler>{
    private  Context context;
    private  List<Product> data;
    private  setOnClickListener mListener;

    public ProductAdapter(Context context, List<Product> mList) {
        this.context = context;
        this.data = mList;
    }

    @NonNull
    @Override
    public RecyclerViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_layout_all_products, parent, false);
        return new RecyclerViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHoler holder, final int position) {
        holder.mTextViewName.setText(data.get(position).getName());
        holder.mTextViewPrice.setText(ChangeValue.formatDecimalPrice((float) data.get(position).getPrice()));
            Picasso.get().load(R.mipmap.loading_button).into(holder.mImageView);

        holder.mLinearLayoutSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setOnItemClickListener(position);
            }
        });
        holder.mTextViewDate.setText(data.get(position).getTaken_day());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class  RecyclerViewHoler extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextViewPrice;
        TextView mTextViewName;
        TextView mTextViewDate;
        LinearLayout mLinearLayoutSanPham;
        public RecyclerViewHoler(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_row_san_pham);
            mTextViewName = itemView.findViewById(R.id.product_name);
            mTextViewPrice = itemView.findViewById(R.id.price_product);
            mLinearLayoutSanPham = itemView.findViewById(R.id.lnl_root_san_pham);
            mTextViewDate = itemView.findViewById(R.id.taken_day_product);
        }
    }
    public  void setOnItemClickListner(setOnClickListener mOnItemClickListner){
        this.mListener = mOnItemClickListner;
    }
    public  interface  setOnClickListener{
        void setOnItemClickListener(int postion);
    }



}
