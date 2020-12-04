package customers;

import java.util.GregorianCalendar;

public class Customer {
    private String name = "";
    private GregorianCalendar date_of_birth = new GregorianCalendar(1970, 00, 01);
    private String address = "";
    private String image = "";

    public Customer() {
    }

    public Customer(String name, GregorianCalendar date_of_birth, String address, String image) {
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(GregorianCalendar date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "customer{" +
                "name='" + name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
