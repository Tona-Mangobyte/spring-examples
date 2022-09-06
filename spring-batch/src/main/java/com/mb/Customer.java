package com.mb;

import java.io.Serializable;
import java.util.Calendar;
import lombok.Data;

@Data
public class Customer implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public int getTransactions() {
        return transactions;
    }

    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }

    private String name;
    private Calendar birthday;
    private int transactions;

    @Override
    public String toString() {
        return String.format(
                "#%s, %s born on %3$tb %3$te, %3$tY, finished %4$s transactions",
                id,
                name,
                birthday.getTime(),
                transactions
        );
    }

}