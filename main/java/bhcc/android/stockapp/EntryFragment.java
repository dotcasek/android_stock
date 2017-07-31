package bhcc.android.stockapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dotca on 4/22/2017.
 */

// this holds
public class EntryFragment extends Fragment {

    static List<Customer> mCustomerList = new ArrayList<>();

    private EditText etID;
    private EditText etName;
    private EditText etCompany;
    private EditText etShares;
    private EditText etPrice;

    private ProgressBar pbProgressBar;
    private TextView tvPbView;

    private ImageButton imgBtn;

    public EntryFragment() {

    }

    // returns 1 for a valid int, 2 for a valid double
    public int scanText(String text) {
        // check for spaces
        String[] token = text.trim().split(" ");
        if (token.length > 1) {
            return 0;
        }

        Scanner inputScanner = new Scanner(text);

        if (inputScanner.hasNextInt()) {
            if (inputScanner.nextInt() < 0) {
                return 0;
            }
            return 1;
        }
        if (inputScanner.hasNextDouble()) {
            if (inputScanner.nextDouble() < 0) {
                return 0;
            }
            return 2;

        } else return 0;

    }

    // validate input
    public boolean validForm() {
        boolean valid = true;

        if (etID.getText().toString().equals("") || !(etID.getText().toString().matches("[A-Z]{2}[0-9]{6}"))){
            valid = false;
        }
        if (etName.getText().toString().equals("")) {
            valid = false;
        }
        if (etCompany.getText().toString().equals("")) {
            valid = false;
        }
        if (etShares.getText().toString().equals("") || scanText(etShares.getText().toString()) != 1) {
            valid = false;
        }
        if (etPrice.getText().toString().equals("") || scanText(etPrice.getText().toString()) == 0) {
            valid = false;
        }

        if (!valid) {
            Toast.makeText(getActivity(), "Invalid Form", Toast.LENGTH_SHORT).show();
        }

        return valid;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_entry, container, false);
        etID = (EditText)view.findViewById(R.id.id_entry);
        etName = (EditText)view.findViewById(R.id.name_entry);
        etCompany = (EditText)view.findViewById(R.id.company_entry);
        etShares = (EditText)view.findViewById(R.id.num_shares_entry);
        etPrice = (EditText)view.findViewById(R.id.price_entry);

        pbProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        tvPbView = (TextView)view.findViewById(R.id.progress_text);

        imgBtn = (ImageButton)view.findViewById(R.id.arrow_image);

        Bundle b = getArguments();
        final int index = b.getInt("index");

        pbProgressBar.setProgress(index);
        tvPbView.setText(index + "/" + 25);

        // button handler
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check if valid input
                if(index <= 25){
                    if(validForm()){
                        // first page
                        if(index == 1){
                            new MyFileWriter();
                        }

                        // create new customer object
                        Customer c = new Customer(
                                etID.getText().toString(),
                                etName.getText().toString(),
                                etCompany.getText().toString(),
                                Integer.parseInt(etShares.getText().toString()),
                                Double.parseDouble(etPrice.getText().toString())
                        );

                        // add object to list
                        MyFileWriter.addNewItem(c);

                        // refresh form
                        Intent intent = new Intent(getActivity(), EntryActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("start", index);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                }
            }
        });
        return view;
    }
}
