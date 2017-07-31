package bhcc.android.stockapp;

import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dotca on 4/22/2017.
 */

public class FileLoader {

    private static List<Customer> mCustomerList;
    private static BinaryTree<Customer> bTree;
    private static int numRecords = 0;

    // check if file exists and read the object
    public static boolean checkFile(){
        try
        {
            FileInputStream inputStream = StockApp.getAppContext().openFileInput("data.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            mCustomerList = new ArrayList<>();

            mCustomerList = (ArrayList<Customer>)objectInputStream.readObject();

            objectInputStream.close();
            inputStream.close();
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    // insert the data from the file into the binary tree
    public static BinaryTree<Customer> getTree(){

        bTree = new BinaryTree<>();
        for(Customer c : mCustomerList){
            bTree.insert(c);
        }
        Toast.makeText(StockApp.getAppContext(), bTree.getNodeCount() + " Records Found", Toast.LENGTH_SHORT).show();
        return bTree;
    }
}
