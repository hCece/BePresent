package com.example.bepresent.database.friends;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Friend {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "birthday")
    public Date birthday;

    @ColumnInfo(name = "is_close_friend")
    public boolean isCloseFriend;

    public Date getBirthday() {
        return birthday;
    }

    public String getLastName() {
        return lastName;
    }

    public Friend(String firstName, String lastName, Date birthday, boolean isCloseFriend) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.isCloseFriend = isCloseFriend;

    }



}