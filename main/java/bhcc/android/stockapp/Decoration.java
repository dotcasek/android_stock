package bhcc.android.stockapp;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;

/**
 * Created by dotca on 4/23/2017.
 */

// adds spacing between recycleview panels
public class Decoration extends ItemDecoration {

    private int spacing;

    public Decoration(int spacing){
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = spacing;
    }
}
