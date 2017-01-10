package summit.maddie.simplefragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EDIT_TEXT_INPUT_EXTRA = "EDIT_TEXT_INPUT";

    private boolean mTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButtonClickListener();

        if (findViewById(R.id.example_fragment_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setUpButtonClickListener() {

        Button button = (Button) findViewById(R.id.button_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(EDIT_TEXT_INPUT_EXTRA, getEditTextInput());

                    ExampleFragment fragment = new ExampleFragment();
                    fragment.setArguments(arguments);

                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.example_fragment_container, fragment)
                        .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, SecondActivity.class);
                    intent.putExtra(EDIT_TEXT_INPUT_EXTRA, getEditTextInput());
                    context.startActivity(intent);
                }
            }
        });

    }

    public String getEditTextInput() {
        EditText editText = (EditText) findViewById(R.id.edit_text_main);
        final String editTextInput = editText.getText().toString();
        return editTextInput;
    }

}
