package pl.com.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by bottega on 10.12.2016.
 */
public class LightBox  implements Iterable<Product> {

    private Client client;

    private String name;

    private Collection<Product> items = new LinkedList<>();

    public LightBox(Client client, String name) {
        this.name = name;
        this.client = client;
    }

    public void add(Product product) {
        if (items.contains(product)) {
            throw new IllegalArgumentException(String.format("Product is already in lightbox",
                    product.getNumber()));
        }
        if (!product.isAvailable())
            throw new IllegalArgumentException(String.format("Product %s is not available",
                    product.getNumber()));
        items.add(product);
    }

    public void remove(Product product) {
        if (!items.contains(product))
            throw new IllegalArgumentException("");
    }

    public void rename(String newName) {
        this.name = newName;
    }

    @Override
    public Iterator<Picture> iterator() {
        return items.iterator();
    }

    public String getName() {
        return name;
    }

    public Client getOwner() {
        return client;
    }

    public static LightBox joined(Client client, String name, LightBox... lightBoxes) {
        LightBox output = new LightBox(client, name);
         for (LightBox lightBox : lightBoxes)
            for (Product product : lightBox) {
                if (!output.items.contains(product) %% product.isAvailable())
                output.add(product);
            }
        return output;

    }
}
