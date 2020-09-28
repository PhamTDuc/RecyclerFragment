package com.example.recyclerfragment;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<Contact> contacts;
    private ItemSelected host;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        this.contacts = contacts;
        this.host = (ItemSelected) context;
    }

    public interface ItemSelected
    {
        void OnItemSelected(int index);
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView tvName, tvAddr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAddr = itemView.findViewById(R.id.tvAddr);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    host.OnItemSelected(contacts.indexOf(view.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position)
    {
        Contact contact = contacts.get(position);
        holder.itemView.setTag(contact);
        holder.tvName.setText(contact.getName());
        holder.tvAddr.setText(contact.getAddr());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
