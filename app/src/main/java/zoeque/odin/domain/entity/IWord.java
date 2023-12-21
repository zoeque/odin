package zoeque.odin.domain.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * The interface of the word entity.
 */
public interface IWord extends OdinEntity{
    int getId();

    String getWord();

    String getMeaning();

    int getLearnedFlag();

}
