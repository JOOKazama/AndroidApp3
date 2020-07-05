package com.All.RecyclerViewLogic;
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
import com.All.Contact.Contact;
import com.All.R;

public class FragmentDialog extends DialogFragment implements View.OnClickListener
{
    private EditText name;
    private EditText address;
    private EditText url;
    DialogListener dialog_listener;

    public static FragmentDialog newInstance() { return new FragmentDialog(); }

    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    { return inflater.inflate(R.layout.fragment,container,false); }

    @RequiresApi(api=Build.VERSION_CODES.KITKAT)
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        name=view.findViewById(R.id.name);
        address=view.findViewById(R.id.address);
        url=view.findViewById(R.id.url);
        Button button_send=view.findViewById(R.id.button_send);
        button_send.setOnClickListener(this);
    }

    @Override public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        dialog_listener=(DialogListener)context;
    }

    @Override public void onClick(View v)
    {
        Contact contact=new Contact();
        contact.setName(name.getText().toString());
        contact.setAddress(address.getText().toString());
        contact.setUrl(url.getText().toString());
        dialog_listener.onFinishAddDialog(contact);
        v.clearFocus();
        v.setFocusable(false);
        dismiss();
    }
}