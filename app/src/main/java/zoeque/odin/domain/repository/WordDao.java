package zoeque.odin.domain.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import zoeque.odin.domain.entity.Word;

@Dao
public interface WordDao {
    @Query("SELECT * FROM word")
    List<Word> getAll();

    @Query("SELECT * FROM word WHERE id IN (:ids)")
    List<Word> loadAllByIds(int[] ids);

    @Insert
    void insertAll(Word... accessTimes);

    @Insert
    void insert(Word accessTime);

    @Delete
    void delete(Word accessTime);
}
