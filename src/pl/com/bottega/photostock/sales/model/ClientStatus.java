package pl.com.bottega.photostock.sales.model;

/**
 * Created by bottega on 10.12.2016.
 */
public enum ClientStatus {

    STANDARD("Standardowy"),
    VIP("Vip"),
    GOLD("Złoty"),
    SILVER("Srebrny"),
    PLATINUM("Platynowy");

    private String statusName;

    ClientStatus(String statusName){
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
