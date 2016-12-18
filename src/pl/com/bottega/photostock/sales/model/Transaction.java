package pl.com.bottega.photostock.sales.model;

import java.time.LocalDateTime;

/**
 * Created by bottega on 11.12.2016.
 */
public class Transaction {

    private Money value;

    private String description;

    private LocalDateTime timestamp;

    public  Transaction(Money value, String description){
        this.value = value;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }
}
