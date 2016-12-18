package pl.com.bottega.photostock.sales.model;

/**
 * Created by bottega on 17.12.2016.
 */
public class VIPClient extends Client {

    private Money creditLimit;

    public VIPClient(String name, Address address, Money balance, Money creditLimit) {
        super(name, address, ClientStatus.VIP, balance);
        this.creditLimit = creditLimit;

    }

    @Override
    public boolean canAfford(Money money) {
        return balance.add(creditLimit).gte(money);
    }

}
