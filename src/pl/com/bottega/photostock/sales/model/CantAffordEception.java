package pl.com.bottega.photostock.sales.model;

/**
 * Created by bottega on 11.12.2016.
 */
public class CantAffordEception extends RuntimeException {

public CantAffordEception(String message){
    super(message);
    }
}
