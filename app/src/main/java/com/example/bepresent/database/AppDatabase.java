package com.example.bepresent.database;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.bepresent.database.friends.Friend;
import com.example.bepresent.database.friends.FriendDao;
import com.example.bepresent.database.gifts.Gift;
import com.example.bepresent.database.gifts.GiftDao;

@Database(entities = {User.class, Friend.class, Gift.class}, version = 2)
@TypeConverters(Converters.class) // Add this line to specify the Converters class
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract GiftDao giftDao();
    public abstract FriendDao friendDao();
}