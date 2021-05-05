package io.giodude.atry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductModel {


    @SerializedName("ProductID")
    @Expose
    private String productID;
    @SerializedName("Image")
    @Expose
    private Object image;
    @SerializedName("ProductName")
    @Expose
    private String productName;
    @SerializedName("ProductCategory")
    @Expose
    private String productCategory;
    @SerializedName("UnitSize")
    @Expose
    private String unitSize;
    @SerializedName("Status")
    @Expose
    private Object status;

    public ProductModel(String productID, Object image, String productName, String productCategory, String unitSize, Object status) {
        this.productID = productID;
        this.image = image;
        this.productName = productName;
        this.productCategory = productCategory;
        this.unitSize = unitSize;
        this.status = status;
    }


    public String getProductID() {
        return productID;
    }

    public Object getImage() {
        return image;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getUnitSize() {
        return unitSize;
    }

    public Object getStatus() {
        return status;
    }
}
