package pl.com.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by bottega on 17.12.2016.
 */
public class Clip extends AbstractProduct {

    private static final Long FIVE_MINUTES = 1000l * 60 * 5;
    private Long length;

    public Clip(String number, String name, Long length, Money catalogPrice, boolean active){
        super(name, catalogPrice, number, active);
        this.length = new length;
    }
    public Clip(String number, String name, Long length, Money catalogPrice){
        this(number, name, length, catalogPrice, true);
    }

    @Override
    public Money calculatePrice(Client client){
        if(length > 1000 * 60 * 5)
            return catalogPrice.multiply(2);
            return catalogPrice;
    }
}
