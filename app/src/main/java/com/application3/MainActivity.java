package com.application3;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogListener
{
    RecyclerView v;
    ContactAdapter a;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = findViewById(R.id.view);
        ArrayList<Contact> c = new ArrayList<>();

        a=new ContactAdapter(c);
        v.setAdapter(a);
        v.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab=findViewById(R.id.floating);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                FragmentManager fm=getSupportFragmentManager();
                FragmentDialog addAnimalFragment=FragmentDialog.newInstance();
                addAnimalFragment.show(fm, "Added!");
            }
        });
    }

    @Override public void onFinishAddDialog(Contact c) { a.addContact(c); }
}