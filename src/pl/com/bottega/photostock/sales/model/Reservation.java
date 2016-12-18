package pl.com.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by bottega on 10.12.2016.
 */
public class Reservation {

    private Client client;
    private Collection<Product> items;

    public Reservation(Client client) {
        this.client = client;
        this.items = new LinkedList<>();
    }

    public Client getClient() {
        return client;
    }

    public void add(Product product){
        if(items.contains(product))
            throw new IllegalArgumentException(String.format("Picture %s is already in your reservation",
                    product.getNumber()));
        if(!product.isAvailable())
            throw new IllegalArgumentException(String.format("Picture %s is not available",
                    product.getNumber()));
        items.add(product);
    }

    public void remove(Picture picture){
        if(!items.contains(picture))
            throw new IllegalArgumentException(String.format("Picture %s is not added to this reservation",
                    picture.getNumber()));
        if (!picture.isAvailable())
            throw new IllegalArgumentException(String.format("Picture %s is not available",
                    picture.getNumber()));
        items.remove(picture);
    }

    public Offer generateOffer(){
        return new Offer(client, getActiveItems());
    }
    private Collection<Product> getActiveItems(){
        Collection<Product> activeItems = new HashSet<>();
        for (Product picture : items)
            if (picture.isActive())
                activeItems.add(picture);
        return activeItems;
    }

    public int getItemsCount(){
        return 0;
    }
}
