package bhcc.android.stockapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

// enter all the data
public class EntryActivity extends AppCompatActivity {

    static int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        // set the index for progressbar
        Bundle bundle = getIntent().getExtras();
        index = bundle.getInt("start");

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){

            // display new form
            if(index < 25) {
                fragment = new EntryFragment();
                Bundle b = new Bundle();
                b.putInt("index", index + 1);
                fragment.setArguments(b);

                fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
            }
            // display final fragment when finished to write to file
            else {
                fragment = new SubmitAll();
                fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
            }
        }
    }
}
