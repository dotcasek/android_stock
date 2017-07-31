package bhcc.android.stockapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by dotca on 4/27/2017.
 */

// this just creates instance of the app context for reference
public class StockApp extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        StockApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return StockApp.context;
    }
}
