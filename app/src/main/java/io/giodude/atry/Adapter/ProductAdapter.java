package io.giodude.atry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.giodude.atry.Model.ProductModel;
import io.giodude.atry.R;
import io.giodude.atry.View.ProductListView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    Context context;
    public List<ProductModel> data;

    public ProductAdapter(Context context, List<ProductModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.productitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pname.setText(data.get(position).getProductName());
        holder.psize.setText(data.get(position).getUnitSize());
        holder.pcat.setText(data.get(position).getProductCategory());
        holder.pid.setText(data.get(position).getProductID());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pname,psize,pcat,pid;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pname = itemView.findViewById(R.id.productname);
            psize = itemView.findViewById(R.id.productsize);
            pcat = itemView.findViewById(R.id.productcategory);
            pid = itemView.findViewById(R.id.productid);
        }
    }
}
