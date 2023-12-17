package zoeque.odin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import zoeque.odin.R;
import zoeque.odin.domain.entity.IWord;

public class WordAdapter extends ArrayAdapter<IWord> {
    private LayoutInflater inflater;

    public WordAdapter(Context context, List<IWord> words) {
        super(context, 0, words);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.word_list, parent, false);
        }

        IWord word = getItem(position);

        CheckBox checkBox = convertView.findViewById(R.id.check_box);
        TextView textViewWord = convertView.findViewById(R.id.text_view_word);
        TextView textViewMeaning = convertView.findViewById(R.id.text_view_meaning);

        textViewWord.setText(word.getWord());
        textViewMeaning.setText(word.getMeaning());

        return convertView;
    }
}