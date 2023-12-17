package zoeque.odin.domain.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import zoeque.odin.domain.entity.IWord;
import zoeque.odin.domain.model.OdinSettingModel;

public class WordRepository extends SQLiteOpenHelper {
    public WordRepository(@Nullable Context context) {
        super(context,
                OdinSettingModel.ODIN.getSettingModel(),
                null,
                1);
    }

    /**
     * Create the database table.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE word (" +
                "id TEXT PRIMARY KEY," +
                "word TEXT," +
                "meaning TEXT," +
                "learned_flag INTEGER" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // ignore
    }

    public List<IWord> getAllWords() {
        Cursor cursor = null;
        SQLiteDatabase database = null;
        try {
            List<IWord> words = new ArrayList<>();
            database = this.getReadableDatabase();
            cursor = database.rawQuery("SELECT word FROM word", null);
            if (cursor.moveToFirst()) {
                do {
                    words.add(
                            new IWord.WordImpl(cursor.getString(0),
                                    cursor.getString(1),
                                    cursor.getString(2),
                                    cursor.getInt(3))
                    );
                } while (cursor.moveToNext());
            }
            cursor.close();
            database.close();
            return words;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            if (database != null) {
                database.close();
            }
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
