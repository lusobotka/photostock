package pl.com.bottega.photostock.sales.model;

import java.util.*;

/**
 * Created by bottega on 10.12.2016.
 */
public class Purchase {

    private Client client;
    private Date purchaseDate;
    private List<Product> items;

    public Purchase(Client client, Collection<Product> items){
        this.client = client;
        this.items = new LinkedList<>(items);
        sortProductsByNumberAsc();

    }

    public Purchase(Client client, Product ... items){
        this(client, Arrays.asList(items));
    }

    public int getItemsCount() {
        return 0;
    }
    /*

    public int sortProductsByNumberAsc(){
        this.items.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
            String n1 = o1.getNumber();
                String n2 = o2.getNumber();
                return 0;
            }
        });
    }
*/
}
