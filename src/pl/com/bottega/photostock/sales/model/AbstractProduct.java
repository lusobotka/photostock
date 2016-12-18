package pl.com.bottega.photostock.sales.model;

/**
 * Created by bottega on 17.12.2016.
 */
public abstract class AbstractProduct implements Product {
    protected String number;
    private String name;
    protected Money catalogPrice;
    private boolean active;
    private Client reservationOwner;
    private Client buyer;

    public AbstractProduct(String name, Money catalogPrice, String number, boolean active) {
        this.name = name;
        this.catalogPrice = catalogPrice;
        this.number = number;
        this.active = active;
    }


    public abstract Money calculatePrice(Client client);

@Override
    public boolean isAvailable(){
        return active && !isSold() && !isReserved();
    }

    private boolean isReserved(){
        return reservationOwner != null;
    }

    @Override
    public boolean isSold(){
        return  buyer != null;
    }

    @Override
    public void reservePer(Client client){
        if(!isAvailable())
            throw new IllegalArgumentException(String.format("Picture %s is not available for reservation",
                    getNumber()));
        this.reservationOwner = client;
    }

    @Override
    public void unreservedPer(Client client){
        if(!isReserved() || !client.equals(reservationOwner))
            throw new IllegalArgumentException(String.format("Picture %s is not reserved by %s", getNumber()));
        reservationOwner = null;
    }

    private boolean isReservedBy(Client client){
        return !isReserved() || !client.equals(reservationOwner);
    }

    @Override
    public void soldPer(Client client){
        ensureReservedBy(client);
        buyer = client;
        unreservedPer(client);
    }

    private void ensureReservedBy(Client client) {
        if (!isReservedBy(client))
            throw new IllegalArgumentException(String.format("Picture %s is not reserved by %s",
                    getNumber()));
    }

    @Override
    public String getNumber(){
        return number;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean deactive(){
        return active = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override //wygenerowany autpmatycznie prawy/generate/equals i hashcode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractProduct product = (AbstractProduct) o;

        return number != null ? number.equals(product.number) : product.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }


    }

    /*@Override //equals z palca
    public boolean equals(Object other){
        if (!(other instanceof Picture))
            return false;
        Picture otherPicture = (Picture) other;
        return (otherPicture.number == this.number) ||
                otherPicture.number != null && otherPicture.number.equals(this.number);
    }
    */

