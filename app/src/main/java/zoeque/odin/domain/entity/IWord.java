package zoeque.odin.domain.entity;

/**
 * The interface of the word entity.
 */
public interface IWord {
    String getId();

    String getWord();

    String getMeaning();

    int getLearnedFlag();

    class WordImpl implements IWord {
        String id;
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
         * @param id          UUID converted to the string type.
         * @param word        the word to display.
         * @param meaning     the meaning of the word that is hidden.
         * @param learnedFlag 0 with not learned state or 1, learned state.
         */
        public WordImpl(String id, String word, String meaning, int learnedFlag) {
            setId(id);
            setWord(word);
            this.meaning = meaning;
            setLearnedFlag(learnedFlag);
        }

        private void setId(String id) {
            if (id == null || id.equals("")) {
                throw new IllegalArgumentException("ID must not be null");
            }
            this.id = id;
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

        public String getId() {
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
}
