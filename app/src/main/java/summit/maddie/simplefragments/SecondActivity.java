package summit.maddie.simplefragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        addExampleFragment(extras);

    }

    private void addExampleFragment(Bundle arguments) {
        ExampleFragment fragment = new ExampleFragment();
        fragment.setArguments(arguments);

        getSupportFragmentManager().beginTransaction()
            .add(R.id.example_fragment_container, fragment)
            .commit();

    }
}
