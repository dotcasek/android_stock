package bhcc.android.stockapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Stack;

/**
 * Created by dotca on 4/23/2017.
 */

// pageViewer Adapter class
public class StockAdapter extends RecyclerView.Adapter<StockAdapter.MyViewHolder>{

    private BinaryTree<Customer> bTree;
    private Stack<Customer> stack;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView id;
        public TextView name;
        public TextView company;
        public TextView shares;
        public TextView price;
        public TextView date;
        public TextView worth;


        public MyViewHolder(View view){
            super(view);
            name = (TextView)view.findViewById(R.id.name_display);
            company = (TextView)view.findViewById(R.id.company_display);
            id = (TextView)view.findViewById(R.id.id_display);
            shares = (TextView)view.findViewById(R.id.shares_display);
            price = (TextView)view.findViewById(R.id.price_display);
            date = (TextView)view.findViewById(R.id.date_display);
            worth = (TextView)view.findViewById(R.id.worth_display);
        }
    }

    public StockAdapter(BinaryTree<Customer> bt){
        bTree = bt;
    }

    @Override
    public StockAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_display, parent, false);
        stack = bTree.getNodeStack();

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StockAdapter.MyViewHolder holder, int position) {

            if(!stack.isEmpty()) {
                Customer c = (Customer) stack.get(position);
                holder.name.setText(c.getName());
                holder.company.setText(c.getCompany());
                holder.id.setText(c.getId() + "");
                holder.shares.setText(c.getShares() + "");
                holder.price.setText(String.format("$%.2f", c.getPrice()));
                holder.date.setText(c.getDate());
                holder.worth.setText(String.format("$%.2f", c.getWorth()));
            }
    }

    @Override
    public int getItemCount() {
        return bTree.getNodeCount();
    }
}
