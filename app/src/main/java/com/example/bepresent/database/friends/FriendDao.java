package com.example.bepresent.database.friends;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface FriendDao {
    @Query("SELECT * FROM Friend")
    List<Friend> getAll();

    @Query("SELECT * FROM Friend WHERE id IN (:friendIds)")
    List<Friend> loadAllByIds(int[] friendIds);

    @Query("SELECT * FROM Friend WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    Friend findByName(String first, String last);


    @Query("SELECT * FROM Friend WHERE strftime('%m-%d', birthday) = strftime('%m-%d', :targetDate)")
    List<Friend> getFriendsWithBirthday(Date targetDate);

    @Insert
    void insertAll(Friend... users);

    @Delete
    void delete(Friend user);
}