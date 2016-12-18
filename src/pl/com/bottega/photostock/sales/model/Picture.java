package pl.com.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.HashSet;

public class Picture extends AbstractProduct {

    private Collection<String> tags;

    public Picture(String number, String name, Collection<String> tags, Money catalogPrice, boolean active){
        super(name, catalogPrice, number, active);
        this.tags = new HashSet<String>(tags);
    }
    public Picture(String number, String name, Collection<String> tags, Money catalogPrice){
        this(number, name, tags, catalogPrice, true);
    }

}
