package viet.umesh.locationtracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ListOnlineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtEmail;
    ItemClickListener itemClickListener;


    public ListOnlineViewHolder(@NonNull View itemView) {
        super(itemView);
        txtEmail = itemView.findViewById(R.id.txt_user_email);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition());
        Log.d("CLICKED", "onClick: "+view+getAdapterPosition());
    }
}
