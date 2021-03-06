package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.*;

/**
 * Created by bottega on 10.12.2016.
 */
public class ConsoleApplication {
    public static void main(String[] args){
        ProductRepository productRepository = new InMemoryProductRepository();
        Product product1 = productRepository.get("1");
        Product product2 = productRepository.get("2");
        Product product3 = productRepository.get("3");

        Client client = new Client("Johny X", new Address(), Money.valueOf(100));
        Client vipClient = new VIPClient("Johny VIP", new Address(), Money.ZERO, Money.valueOf(100));
        System.out.println(client.introduce());
        System.out.println(vipClient.introduce());
        Reservation reservation = new Reservation(vipClient);

        reservation.add(product1);
        reservation.add(product2);
        reservation.add(product3);
        System.out.println("After adding items count: " + reservation.getItemsCount());

       /* reservation.add(picture1);
        reservation.add(picture2);
        System.out.println("After duplicated adding items count: " + reservation.getItemsCount());
*/
        Offer offer = reservation.generateOffer();

        boolean canAfford = vipClient.canAfford(offer.getTotalCost());
        System.out.println("Client can afford: " + canAfford);

        if(canAfford){
            vipClient.charge(offer.getTotalCost(), "Test purchase:");
            Purchase purchase = new Purchase(vipClient, product1, product2, product3);
            System.out.println("Client purchased: " + purchase.getItemsCount() + " pictures");
            System.out.println("Total cost: " + offer.getTotalCost());
        }
        else System.out.println("Client cannot afford");
    }
}
