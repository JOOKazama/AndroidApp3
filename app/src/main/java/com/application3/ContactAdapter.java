package com.application3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ViewHolder>
{
    private final ArrayList<Contact>contacts;
    public ContactAdapter(ArrayList<Contact> contacts){ this.contacts=contacts; }

    @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.contact,parent,false);
        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Contact contact = contacts.get(position);
        holder.setName(contact.getName());
        holder.setAddress(contact.getAddress());
        holder.setImage(contact.getUrl());
    }

    @Override public int getItemCount() { return contacts.size(); }

    public void addContact(Contact contact)
    {
        contacts.add(0, contact);
        notifyItemChanged(0);
    }
}