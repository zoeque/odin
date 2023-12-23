package zoeque.odin.domain.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import zoeque.odin.domain.entity.Word;

/**
 * The database abstract class for {@link Word} entity.
 */
@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class OdinDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
}
