package zoeque.odin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import zoeque.odin.R;
import zoeque.odin.domain.entity.Word;
import zoeque.odin.domain.model.WordModel;
import zoeque.odin.domain.repository.OdinDatabase;
import zoeque.odin.domain.repository.OdinDatabaseSingleTon;
import zoeque.odin.service.DeleteWordAsyncTaskExecutor;

/**
 * The adapter class for the studying screen.
 */
public class StudyingListAdapter extends ArrayAdapter<Word> {
    private LayoutInflater inflater;
    Context context;

    public StudyingListAdapter(Context context, List<Word> words) {
        super(context, 0, words);
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.word_list_learning, parent, false);
        }

        Word word = getItem(position);

        CheckBox checkBox = convertView.findViewById(R.id.checkbox_learning);
        TextView textViewWord = convertView.findViewById(R.id.text_view_study_word);
        textViewWord.setText(word.getWord());
        OdinDatabase db = OdinDatabaseSingleTon.getInstance(this.context);

        // set true if the word is already learned state
        checkBox.setChecked(word.getLearnedFlag() == WordModel.LEARNED_STATE);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // save the state with true/false on the checkbox
                if (isChecked) {
                    word.updateLearnedFlag(WordModel.LEARNED_STATE);
                } else {
                    word.updateLearnedFlag(WordModel.NOT_LEARNED_STATE);
                }
                DeleteWordAsyncTaskExecutor
                        .getDatabaseWriteExecutor()
                        .execute(new Runnable() {
                            @Override
                            public void run() {
                                // update the state async
                                db.wordDao().update(word);
                            }
                        });
            }
        });
        return convertView;
    }
}