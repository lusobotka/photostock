package pl.com.bottega.photostock.sales.model;

import java.util.*;

/**
 * Created by bottega on 10.12.2016.
 */
public class Offer {

    private List<Product> items;

    private Client client;

    public Offer(Client client, Collection<Product> items){
        this.client = client;
        this.items = new LinkedList<>(items);
        sortProducts();
    }


    public boolean sameAs(Offer other, Money money){
        return false;
    }

    public int getItemsCount(){
        return items.size();
    }

    public Money getTotalCost(){
        Money totalCost = Money.ZERO;
        for(Product product : items){
            Money pictureCost = product.calculatePrice(client);
            totalCost = totalCost.add(pictureCost);
        }
        return totalCost;
    }

    // automatycznie wygenerowana metoda
    private void sortProductsByPriceDesc() {
        this.items.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                Money price1 = p1.calculatePrice(client);
                Money price2 = p2.calculatePrice(client);
                return price1.compareTo(price2);
            }
        });
    }
}
