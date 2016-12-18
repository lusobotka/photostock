package pl.com.bottega.photostock.sales.model;

/**
 * Created by bottega on 18.12.2016.
 */
public class ProductNotAvailableException extends RuntimeException {
    public ProductNotAvailableException(Product product){
        super(String.format("Picture %s is already in your reservation",
                product.getNumber()));
    }
}
