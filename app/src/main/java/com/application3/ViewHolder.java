package com.application3;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder
{
    ImageView image;
    TextView name;
    TextView address;

    public ViewHolder(@NonNull View itemView)
    {
        super(itemView);
        image=itemView.findViewById(R.id.image);
        name=itemView.findViewById(R.id.name);
        address=itemView.findViewById(R.id.address);
    }

    public void setName(String name){ this.name.setText(name); }
    public void setAddress(String address){ this.address.setText(address); }
    public void setImage(String url) { Picasso.get().load(url).resize(349, 317).into(image); }
}