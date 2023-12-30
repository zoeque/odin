package zoeque.odin.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import zoeque.odin.R;
import zoeque.odin.domain.entity.Word;
import zoeque.odin.domain.repository.OdinDatabase;
import zoeque.odin.domain.repository.OdinDatabaseSingleTon;
import zoeque.odin.service.DeleteWordAsyncTaskExecutor;

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
            convertView = inflater.inflate(R.layout.word_list_maintenance, parent, false);
        }

        Word word = getItem(position);

        TextView textViewWord = convertView.findViewById(R.id.text_view_study_word);
        textViewWord.setText(word.getWord());
        OdinDatabase db = OdinDatabaseSingleTon.getInstance(this.context);

        return convertView;
    }
}