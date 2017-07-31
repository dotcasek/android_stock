package bhcc.android.stockapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

// sumbit writes the object to a file
public class SubmitAll extends Fragment {

    Button btSubmit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_submit_all, container, false);

        btSubmit = (Button)view.findViewById(R.id.button_sumbit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // write to file
                if(MyFileWriter.writeToFile()){
                    Toast.makeText(getActivity(), "File Created", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Error Creating File", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
