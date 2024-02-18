package zoeque.odin.service.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;

import zoeque.odin.R;
import zoeque.odin.adapter.StudyingListAdapter;
import zoeque.odin.domain.entity.Word;
import zoeque.odin.domain.model.OdinSettingModel;
import zoeque.odin.domain.repository.OdinDatabase;
import zoeque.odin.domain.repository.OdinDatabaseSingleTon;

/**
 * The activity class for the studying mode.
 */
public class StudyingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_list);

        OdinDatabase db = OdinDatabaseSingleTon.getInstance(getApplicationContext());

        // reset the idx of the showing list
        updateListIdx(0);

        // The process of list view
        StudyingListAdapter adapter = new StudyingListAdapter(this, new ArrayList<>());
        ListView listView = findViewById(R.id.list_view_study);
        listView.setAdapter(adapter);

        db.wordDao()
                .getAll()
                .observe(this, new Observer<List<Word>>() {
                    @Override
                    public void onChanged(List<Word> allWords) {
                        adapter.clear();
                        // set words with defined amounts
                        adapter.addAll(copyListWithDefinedSize(allWords));
                        adapter.notifyDataSetChanged();
                    }
                });

        // the button control to back to the top screen
        Button buttonToMaintenanceScreen = findViewById(R.id.button_to_top);
        buttonToMaintenanceScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(StudyingActivity.this,
                        TopScreenButtonActivity.class);
                startActivity(intent);
            }
        });

        // button for the next word list
        Button buttonNext = findViewById(R.id.button_to_next_word_list);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.wordDao()
                        .getAll()
                        .observe(StudyingActivity.this, new Observer<List<Word>>() {
                            @Override
                            public void onChanged(List<Word> allWords) {
                                adapter.clear();
                                // set words with defined amounts
                                List<Word> wordList = copyListWithDefinedSize(allWords);
                                // back to top screen if the word is nothing in the showing list
                                if (wordList.isEmpty()) {
                                    Intent intent = new Intent(StudyingActivity.this,
                                            TopScreenButtonActivity.class);
                                    startActivity(intent);
                                }
                                adapter.addAll(wordList);
                                adapter.notifyDataSetChanged();
                            }
                        });
            }
        });
    }

    /**
     * Process that copy the word list with the size of defined in settings.
     * If the size is given with 5, the returned value is set with 5 words in the list.
     * The size and IDX of the List holds all words is saved in Database.
     *
     * @param allWords The all words saved in Database.
     * @return The list of words with given size option.
     */
    private List<Word> copyListWithDefinedSize(List<Word> allWords) {
        List<Word> wordList = new ArrayList<>();
        SharedPreferences preferences = getSharedPreferences(OdinSettingModel.SETTING.getSettingModel(), 0);
        int selectedSize
                = preferences.getInt(OdinSettingModel.LIST_SIZE.getSettingModel(), 0);
        int startIdx = preferences.getInt(OdinSettingModel.LIST_STUDYING_IDX.getSettingModel(), 0);
        for (int i = startIdx; i < startIdx + selectedSize && i < allWords.size(); i++) {
            Word word = allWords.get(i);
            updateListIdx(i + 1);
            wordList.add(word);
        }
        return wordList;
    }

    private void updateListIdx(int idx) {
        SharedPreferences settings
                = getSharedPreferences(OdinSettingModel.SETTING.getSettingModel(), 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(OdinSettingModel.LIST_STUDYING_IDX.getSettingModel(), idx);
        editor.apply();
    }
}
