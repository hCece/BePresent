package com.example.bepresent.database.gifts;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * This class uses the repository pattern to execute a request to the Dao. The main reason for this class to exist
 * is that each time we want to execute sql-command we have to execute the request into another thread.
 * Doing that for each request would make messy code, in this way we encapsulate this problem.
 *
 * The class uses also a Singleton pattern to ensure that there is always just one instance of the class.
 */
public class GiftRepository {/*
    private GiftDao userDao;
    private ExecutorService executor;
    private static GiftRepository instance;

    public static GiftRepository getInstance() {
        if (instance == null) {
            // Throw an exception or log an error if data is not set before getInstance() is called
            throw new IllegalStateException("Data not set for singleton instance");
        }
        return instance;
    }

    /** This method is necessary to intialize the Repository, where we pass the object userDao
     *//*
    public static void initialize(GiftDao userDao) {
        if (instance == null) {
            instance = new GiftRepository(userDao);
        }
    }

    /** The code uses Executors that are able to create a pool thread.
     * A thread pool is a collection of worker threads that are managed the Executors.
     * Instead of creating new threads for every task, thread pools allow for reusing existing threads,
     * which can improve performance and reduce resource consumption.
     * *//*
    private GiftRepository(GiftDao userDao) {
        this.userDao = userDao;
        this.executor = Executors.newSingleThreadExecutor();
    }

    public void insertUser(Gift user) {
        executor.execute(() -> userDao.insertAll(user));
    }

    public List<Gift> getAllUsers() {
        try {
            return executor.submit(userDao::getAll).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(); // Return an empty list in case of error
    }*/
}

