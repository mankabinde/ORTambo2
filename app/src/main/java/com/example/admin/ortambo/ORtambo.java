package com.example.admin.ortambo;


/**
 * Created by Admin on 7/28/2017.
 */

public class ORtambo {

    String   head;
    String   description;
    String   photoUrl;



    public ORtambo(String head, String description, String photoUrl ) {
        this.head = head;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public ORtambo(String head, String photoUrl) {
        this.head = head;
        this.photoUrl = photoUrl;
    }







    public ORtambo() {

    }
}
