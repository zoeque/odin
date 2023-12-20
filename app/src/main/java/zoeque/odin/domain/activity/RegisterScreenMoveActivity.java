package zoeque.odin.domain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

import io.vavr.control.Try;
import zoeque.odin.R;
import zoeque.odin.domain.entity.IWord;
import zoeque.odin.domain.repository.WordRepository;

/**
 * The screen component to save new word.
 */
public class RegisterScreenMoveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

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
                IWord newWord = new IWord.WordImpl(id, word, meaning, learnedFlag);

                // save the instance via repository
                WordRepository repository = new WordRepository(RegisterScreenMoveActivity.this);
                Try<IWord> saveTry = repository.save(newWord);

                // show toast with the result of the saving process
                if (saveTry.isSuccess()) {
                    Toast.makeText(getApplicationContext(),
                                    word + "を登録できました",
                                    Toast.LENGTH_SHORT)
                            .show();
                    // clear forms
                    wordEditText.setText("");
                    meaningEditText.setText("");
                } else {
                    // failed to save
                    Toast.makeText(getApplicationContext(),
                                    "登録に失敗しました",
                                    Toast.LENGTH_SHORT)
                            .show();
                }
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
}
