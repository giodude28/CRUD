package io.giodude.atry.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.giodude.atry.Adapter.ProductAdapter;
import io.giodude.atry.Model.ProductModel;
import io.giodude.atry.R;
import io.giodude.atry.ViewModel.ProductViewModel;

public class ProductListView extends AppCompatActivity {
private ProductAdapter productAdapter;
private ProductViewModel productViewModel;
private List<ProductModel> pModel = new ArrayList<>();
private static RecyclerView recyclerView;
private RecyclerView.LayoutManager pOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_view);
        showProduct();
    }

    private void getProduct(List<ProductModel> product){
        recyclerView = findViewById(R.id.productRecyclerview);
        pOut = new LinearLayoutManager(ProductListView.this);
        recyclerView.setLayoutManager(pOut);
        productAdapter = new ProductAdapter(ProductListView.this, product);
        recyclerView.setAdapter(productAdapter);
    }


    private void showProduct(){
        productViewModel = ViewModelProviders.of(ProductListView.this).get(ProductViewModel.class);
        productViewModel.init();
        productViewModel.getProduct().observe(this, productModels -> {
            if (productModels == null){
                Toast.makeText(ProductListView.this,"Null",Toast.LENGTH_LONG).show();
            }else {
                getProduct(productModels);
                pModel.addAll(productModels);
                productAdapter.notifyDataSetChanged();
            }
        });
    }
}