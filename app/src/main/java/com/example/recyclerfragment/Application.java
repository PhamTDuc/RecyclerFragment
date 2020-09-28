package com.example.recyclerfragment;

import java.util.ArrayList;

public class Application extends android.app.Application
{
    public static ArrayList<Contact> contacts;

    @Override
    public void onCreate() {
        super.onCreate();
        contacts = new ArrayList<>();
        contacts.add(new Contact("Pham Duc", "Hanam, Vietnam"));
        contacts.add(new Contact("Pham Cong", "Hanoi, Vietnam"));
        contacts.add(new Contact("Nguyen Minh", "Ninhbinh, Vietnam"));
        contacts.add(new Contact("Pham Tuan", "Angiang, Vietnam"));
    }
}
