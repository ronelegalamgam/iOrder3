package com.app.brensurio.iorder.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.brensurio.iorder.R;
import com.app.brensurio.iorder.models.Order;

import java.util.List;

public class CustomerOrderAdapter extends
        RecyclerView.Adapter<CustomerOrderAdapter.ViewHolder> {

    private List<Order> orders;
    private Context context;

    // Provide reference to the views used in the recycler view
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CustomerOrderAdapter(Context context, List<Order> orders) {
        this.orders = orders;
        this.context = context;
    }

    @Override
    public CustomerOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_customer_order, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;

        TextView refTextView = (TextView) cardView.findViewById(R.id.ref_text_view);
        refTextView.setText("Order ID: " + orders.get(position).getRefNo());
        TextView statusTextView = (TextView) cardView.findViewById(R.id.status_text_view);
        statusTextView.setText(orders.get(position).getStatus());

        ImageView statusIcon = (ImageView) cardView.findViewById(R.id.status_icon);
        if (orders.get(position).getStatus().equalsIgnoreCase("processing")) {
            Drawable myDrawable =
                    context.getResources().getDrawable(R.drawable.ic_directions_run_black_24dp);
            statusIcon.setImageDrawable(myDrawable);
        } else if (orders.get(position).getStatus().equalsIgnoreCase("confirmed")){
            Drawable myDrawable =
                    context.getResources().getDrawable(R.drawable.ic_done_all_black_24dp);
            statusIcon.setImageDrawable(myDrawable);
        } else {
            Drawable myDrawable =
                    context.getResources().getDrawable(R.drawable.ic_error_outline_black_24dp);
            statusIcon.setImageDrawable(myDrawable);
        }
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }


}
