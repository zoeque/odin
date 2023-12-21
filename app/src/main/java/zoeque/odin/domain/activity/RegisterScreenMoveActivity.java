package zoeque.odin.domain.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;
import java.util.UUID;

import zoeque.odin.R;
import zoeque.odin.domain.entity.IWord;
import zoeque.odin.domain.entity.Word;
import zoeque.odin.domain.repository.OdinDatabase;
import zoeque.odin.domain.repository.OdinDatabaseSingleTon;
import zoeque.odin.domain.repository.WordDao;

/**
 * The screen component to save new word.
 */
public class RegisterScreenMoveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        OdinDatabase db = OdinDatabaseSingleTon.getInstance(getApplicationContext());


        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save the words with given values
                EditText wordEditText = findViewById(R.id.word);
                EditText meaningEditText = findViewById(R.id.meaning);

                // get text from forms
                String word = wordEditText.getText().toString();
                String meaning = meaningEditText.getText().toString();

                String id = UUID.randomUUID().toString();
                int learnedFlag = 0;
                IWord newWord = new Word(word, meaning, learnedFlag);

                // save the instance via repository
                new DataStoreAsyncTask(RegisterScreenMoveActivity.this, db)
                        .execute(newWord);

                // show toast with the result of the saving process
                Toast.makeText(getApplicationContext(),
                                word + "を登録しました",
                                Toast.LENGTH_SHORT)
                        .show();
            }
        });

        // The button activity to back to the top screen
        Button buttonToTop = findViewById(R.id.button_to_top);
        buttonToTop.setOnClickListener(new View.OnClickListener() {
            /**
             * The button action to move to top screen.
             *
             * @param v The view that was clicked.
             */
            public void onClick(View v) {
                Intent intent = new Intent(RegisterScreenMoveActivity.this,
                        TopScreenButtonActivity.class);
                startActivity(intent);
            }
        });
    }


    private class DataStoreAsyncTask extends AsyncTask<IWord, Void, Integer> {
        private final WeakReference<Activity> weakReference;
        private final OdinDatabase db;

        public DataStoreAsyncTask(Activity activity, OdinDatabase db) {
            this.weakReference = new WeakReference<>(activity);
            this.db = db;
        }

        @Override
        protected Integer doInBackground(IWord... words) {
            WordDao wordDao = db.wordDao();
            wordDao.insert((Word) words[0]);
            return 0;
        }
    }
}
