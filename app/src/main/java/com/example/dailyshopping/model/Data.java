package com.example.dailyshopping.model;

public class Data {
    private String type;
    private int amount;
    private String note;
    private String id;
    private String Date;
    public Data()
    {

    }

    public Data(String type, int amount, String note, String date, String id) {
        this.type = type;
        this.amount = amount;
        this.note = note;
        this.id = id;
        this.Date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}



