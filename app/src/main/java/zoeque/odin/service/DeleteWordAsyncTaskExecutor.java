package zoeque.odin.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * the task executor that runs not-synchronized
 */
public class DeleteWordAsyncTaskExecutor {
    private static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(4);

    public static ExecutorService getDatabaseWriteExecutor() {
        return databaseWriteExecutor;
    }
}
