package com.example.bepresent.database.gifts;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GiftDao {/*
    @Query("SELECT * FROM Gift")
    List<Gift> getAll();

    @Query("SELECT * FROM Gift WHERE uid IN (:userIds)")
    List<Gift> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Gift WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    Gift findByName(String first, String last);

    @Insert
    void insertAll(Gift... users);

    @Delete
    void delete(Gift user);*/
}