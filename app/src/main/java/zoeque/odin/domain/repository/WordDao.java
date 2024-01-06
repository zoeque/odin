package zoeque.odin.domain.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import zoeque.odin.domain.entity.Word;

@Dao
public interface WordDao {
    @Query("SELECT * FROM word")
    LiveData<List<Word>> getAll();

    @Query("SELECT * FROM word WHERE id IN (:ids)")
    List<Word> loadAllByIds(int[] ids);

    @Query("SELECT * FROM word where learnedFlag = 0")
    LiveData<List<Word>> getNotLearnedWords();

    @Insert
    void insertAll(Word... targets);

    @Insert
    void insert(Word target);

    @Delete
    void delete(Word target);

    @Update
    void update(Word word);
}
