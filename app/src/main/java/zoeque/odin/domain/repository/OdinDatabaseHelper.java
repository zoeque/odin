package zoeque.odin.domain.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import zoeque.odin.domain.model.OdinSettingModel;

/**
 * The database helper class for the odin application
 */
public class OdinDatabaseHelper extends SQLiteOpenHelper {
    public OdinDatabaseHelper(@Nullable Context context) {
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

}
