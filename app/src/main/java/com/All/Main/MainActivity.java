package com.All.Main;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.All.Contact.Contact;
import com.All.Contact.ContactAdapter;
import com.All.R;
import com.All.RecyclerViewLogic.DialogListener;
import com.All.RecyclerViewLogic.FragmentDialog;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogListener
{
    RecyclerView recycler_view;
    ContactAdapter contact_adapter;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_view=findViewById(R.id.recycler_view);
        ArrayList<Contact>contacts=new ArrayList<>();

        contact_adapter=new ContactAdapter(contacts);
        recycler_view.setAdapter(contact_adapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override public void onFinishAddDialog(Contact c) { contact_adapter.addContact(c); }

    public void Click(View view)
    {
        FragmentManager fragment_manager=getSupportFragmentManager();
        FragmentDialog add_animal_fragment=FragmentDialog.newInstance();
        add_animal_fragment.show(fragment_manager, "Added!");
    }
}