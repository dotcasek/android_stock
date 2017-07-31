package bhcc.android.stockapp;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dotca on 4/25/2017.
 */

// this class writes a list object to a file
public class MyFileWriter {
    private static List<Customer> userGeneratedList;

    public MyFileWriter(){
        userGeneratedList = new ArrayList<>();
    }

    public static void addNewItem(Customer c){
        userGeneratedList.add(c);
    }

    public List<Customer> getList(){
        return userGeneratedList;
    }

    public static boolean writeToFile() {

        try {
            FileOutputStream outputStream = StockApp.getAppContext().openFileOutput("data.txt", AppCompatActivity.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(userGeneratedList);

            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            Toast.makeText(StockApp.getAppContext(), "File Error", Toast.LENGTH_SHORT).show();
        }

        return true;
    }


}
