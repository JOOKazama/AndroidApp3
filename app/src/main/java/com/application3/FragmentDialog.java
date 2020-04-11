package com.application3;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

public class FragmentDialog extends DialogFragment implements View.OnClickListener
{
    private EditText text;
    private EditText text2;
    private EditText text3;
    DialogListener listener;

    public static FragmentDialog newInstance() { return new FragmentDialog(); }

    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    { return inflater.inflate(R.layout.fragment,container,false); }

    @RequiresApi(api=Build.VERSION_CODES.KITKAT)
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        text=view.findViewById(R.id.text);
        text2=view.findViewById(R.id.text2);
        text3=view.findViewById(R.id.text3);
        Button button=view.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        listener=(DialogListener)context;
    }

    @Override public void onClick(View v)
    {
        Contact contact=new Contact();
        contact.setName(text.getText().toString());
        contact.setAddress(text2.getText().toString());
        contact.setUrl(text3.getText().toString());
        listener.onFinishAddDialog(contact);
        v.clearFocus();
        v.setFocusable(false);
        dismiss();
    }
}