package io.giodude.atry.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.giodude.atry.Connection.Repositories;
import io.giodude.atry.Model.ProductModel;

public class ProductViewModel extends ViewModel {

    private MutableLiveData<List<ProductModel>> product;
    public Repositories repositories;

    public void init(){
        if (product != null){
            return;
        }
        repositories = Repositories.getInstance();
        product = repositories.getProduct();
    }

    public LiveData<List<ProductModel>> getProduct(){
        return product;
    }
}
