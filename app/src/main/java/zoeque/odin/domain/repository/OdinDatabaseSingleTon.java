package zoeque.odin.domain.repository;

import android.content.Context;

import androidx.room.Room;

public class OdinDatabaseSingleTon {
    private static OdinDatabase database = null;

    public static OdinDatabase getInstance(Context context) {
        if (database != null) return database;
        // Return the built database
        database = Room.databaseBuilder(
                context, OdinDatabase.class, "odin_database"
        ).build();
        return database;
    }
}
