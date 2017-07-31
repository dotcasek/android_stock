package bhcc.android.stockapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

// displays the contents of the tree in a recyclerview

public class DisplayActivity extends AppCompatActivity {

    private BinaryTree<Customer> bTree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv.addItemDecoration(new Decoration(50));

        bTree = FileLoader.getTree();
        bTree.inOrder();

        StockAdapter sa = new StockAdapter(bTree);
        rv.setAdapter(sa);
    }
}
