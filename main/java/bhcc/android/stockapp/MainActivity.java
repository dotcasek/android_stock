/*
This program accepts entry from the user and stores it in a file.
The file is then read into a binary tree and displayed in descending order.

Derek Otcasek

CIT 243

Android Programming

 4/22/2017
 */

package bhcc.android.stockapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    boolean fileExists = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.ic_ab_icon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        fileExists = FileLoader.checkFile();

        if(fileExists){
            menu.getItem(0).setEnabled(false);
            menu.getItem(1).setEnabled(true);
        }
        else{
            menu.getItem(0).setEnabled(true);
            menu.getItem(1).setEnabled(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId()){
            case R.id.enter_data:
                intent = new Intent(this, EntryActivity.class);
                Bundle b = new Bundle();
                b.putInt("start", 0);
                intent.putExtras(b);
                startActivity(intent);
                break;
            case R.id.display_data:
                intent = new Intent(this, DisplayActivity.class);
                startActivity(intent);
                break;
            case R.id.quit:

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Quit");
                alertDialog.setMessage("Are you sure you want to quit?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
