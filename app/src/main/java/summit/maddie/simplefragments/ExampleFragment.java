package summit.maddie.simplefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rfl518 on 1/9/17.
 */
public class ExampleFragment extends Fragment {

    public ExampleFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_example, container, false);

        String editTextInputText = "";
        if (getArguments().containsKey(MainActivity.EDIT_TEXT_INPUT_EXTRA)) {
            editTextInputText = getArguments().getString(MainActivity.EDIT_TEXT_INPUT_EXTRA);
        }

        TextView editTextInput = (TextView) rootView.findViewById(R.id.edit_text_input_text_view);
        editTextInput.setText(editTextInputText);

        return rootView;
    }

}
