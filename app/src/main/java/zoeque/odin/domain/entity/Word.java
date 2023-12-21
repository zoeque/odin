package zoeque.odin.domain.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Word implements IWord {
    @PrimaryKey(autoGenerate = true)
    public int id;
    String word;
    String meaning;
    /**
     * 0: not learned
     * 1: learned
     */
    int learnedFlag;

    /**
     * The word that managed in this application
     *
     * @param word        the word to display.
     * @param meaning     the meaning of the word that is hidden.
     * @param learnedFlag 0 with not learned state or 1, learned state.
     */
    public Word(String word, String meaning, int learnedFlag) {
        setWord(word);
        this.meaning = meaning;
        setLearnedFlag(learnedFlag);
    }

    private void setWord(String word) {
        if (word == null || word.equals("")) {
            throw new IllegalArgumentException("Word must not be null");
        }
        this.word = word;
    }

    private void setLearnedFlag(int learnedFlag) {
        if (!(learnedFlag == 0 || learnedFlag == 1)) {
            throw new IllegalArgumentException(
                    "Learned flag must be 0 or 1 : " + learnedFlag
            );
        }
        this.learnedFlag = learnedFlag;
    }

    public int getId() {
        return this.id;
    }

    public String getWord() {
        return this.word;
    }

    public String getMeaning() {
        return this.meaning;
    }

    public int getLearnedFlag() {
        return this.learnedFlag;
    }
}