package bhcc.android.stockapp;

import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dotca on 4/22/2017.
 */

// Customer class stores all the pertinent data for each entry

public class Customer implements Comparable<Customer>, Serializable{
    private static final long serialVersionUID = 42L;

    private int shares;
    private String id, name, company;
    double price, worth;
    Date date;

    public Customer(String id, String name, String company, int shares, double price){
        setId(id);
        setName(name);
        setCompany(company);
        setShares(shares);
        setPrice(price);
        setDate();
        setWorth();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }

    public void setDate() {
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getWorth() {
        return worth;
    }

    private void setWorth() {
        worth = shares * price;
    }


    // compare by id
    @Override
    public int compareTo(Customer another) {
        return (id.compareToIgnoreCase(another.id));
    }
}
