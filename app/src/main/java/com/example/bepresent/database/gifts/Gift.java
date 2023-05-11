package com.example.bepresent.database.gifts;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Gift {
    @PrimaryKey(autoGenerate = true)
    public int uid;
/*
    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    public String getLastName() {
        return lastName;
    }

    public Gift(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getUid() {
        return uid;
    }*/
}