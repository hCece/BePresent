package com.example.bepresent.database;


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
public class UserRepository {
    private UserDao userDao;
    private ExecutorService executor;
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            // Throw an exception or log an error if data is not set before getInstance() is called
            throw new IllegalStateException("Data not set for singleton instance");
        }
        return instance;
    }

    /** This method is necessary to intialize the Repository, where we pass the object userDao
     */
    public static void initialize(UserDao userDao) {
        if (instance == null) {
            instance = new UserRepository(userDao);
        }
    }

    /** The code uses Executors that are able to create a pool thread.
     * A thread pool is a collection of worker threads that are managed the Executors.
     * Instead of creating new threads for every task, thread pools allow for reusing existing threads,
     * which can improve performance and reduce resource consumption.
     * */
    private UserRepository(UserDao userDao) {
        this.userDao = userDao;
        this.executor = Executors.newSingleThreadExecutor();
    }

    public void insertUser(User user) {
        executor.execute(() -> userDao.insertAll(user));
    }

    public List<User> getAllUsers() {
        try {
            return executor.submit(userDao::getAll).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(); // Return an empty list in case of error
    }
}

