package pl.com.bottega.photostock.sales.model;

/**
 * Created by bottega on 17.12.2016.
 */
public interface Product {
    Money calculatePrice(Client client);

    boolean isSold();

    void reservePer(Client client);

    void unreservedPer(Client client);

    void soldPer(Client client);

    String getNumber();

    boolean isActive();

    boolean deactive();

    String getName();

    boolean isAvailable();

    default void ensureAvailable(){
        if (!isAvailable())
            throw new ProductNotAvailableException(this);
    }


}
