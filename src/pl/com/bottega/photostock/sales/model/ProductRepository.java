package pl.com.bottega.photostock.sales.model;

/**
 * Created by bottega on 17.12.2016.
 */
public interface ProductRepository {

    void put(Picture picture);
    Picture get(String name);
}
