package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.Clip;
import pl.com.bottega.photostock.sales.model.Money;
import pl.com.bottega.photostock.sales.model.Picture;
import pl.com.bottega.photostock.sales.model.Product;

import java.util.HashSet;

/**
 * Created by bottega on 11.12.2016.
 */
public class PictureEqualsTest {
    
    public static void main(String[] args){
        Product product1 = picture("123");
        Product product2 = picture(null);
        Product product3 = picture("123");
        Product product4 = picture("099");
        Product product5 = picture(null);

        Clip clip1 = clip("123");
        Clip clip2 = clip("333");
        Clip clip3 = clip("255");

        System.out.println("Positive");
        System.out.println(product1.equals(product3));
        System.out.println(product3.equals(product1));
        System.out.println(product1.equals(product1));
        System.out.println(product2.equals(product5));

        System.out.println("Negative");
        System.out.println(product1.equals(product2));
        System.out.println(product3.equals(product4));
        System.out.println(product4.equals(product4));
            }

    private static Clip clip(String number){
        return new Clip(number, "", new HashSet<>(), Money.valueOf(110));
    }

    private static Product picture(String number){
        return new Picture(number, "", new HashSet<>(), Money.valueOf(100));
    }
}
