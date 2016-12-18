package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.*;

/**
 * Created by bottega on 11.12.2016.
 */
public class LightBoxTest {

    public static void main(String[] args) {
        ProductRepository productRepository = new InMemoryProductRepository();
        Product product1 = productRepository.get("1");
        Product product2 = productRepository.get("2");
        Product product3 = productRepository.get("3");
        Client client = new Client("Johny X", new Address(), Money.valueOf(100));
        Client marian = new Client("Marian X", new Address(), Money.valueOf(100));

        LightBox l1 = new LightBox(client, "Samochody");
        LightBox l2 = new LightBox(client, "BMW");
        LightBox l3 = new LightBox(marian, "Wyścigowe Samochody");

        l1.add(product1);
        l1.add(product3);
        l1.add(product3);

        l2.add(product1);

        l3.add(product3);

        printLightBoxes(l1, l2, l3);

        LightBox l = LightBox.joined(client, "Joined lightbox", l1, l2, l3);
        System.out.println("Joined lightbox");
        printLightBox(l);
    }
    private static void printLightBoxes(LightBox... lightBoxes){
        int nr = 1;
        for(LightBox lightBox : lightBoxes){
            System.out.println(String.format("%d,. %s - %s", nr, lightBox.getName(), lightBox.getOwner().getName()));
            printLightBox(lightBox);
            nr++;
        }
    }
    private static void printLightBox(LightBox lightBox){
        for (Product product : lightBox){
            System.out.println(String.format("%s%s | %s",
                    (product.isActive() ? "" : "x"),
                    product.getNumber(),
                    product.calculatePrice(lightBox.getOwner())
                    ));
        }
    }
}
