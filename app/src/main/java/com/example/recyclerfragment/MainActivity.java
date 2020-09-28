package com.example.recyclerfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements ContactAdapter.ItemSelected {

    TextView tvName, tvAddr;
    EditText edName, edAddr;
    Button btnAdd;
    ListFragment listFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvAddr = findViewById(R.id.tvAddr);

        edName = findViewById(R.id.edName);
        edAddr = findViewById(R.id.edAddr);
        btnAdd = findViewById(R.id.btnAdd);
        fragmentManager = this.getSupportFragmentManager();
        listFragment =(ListFragment) fragmentManager.findFragmentById(R.id.list);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString().trim();
                String addr = edAddr.getText().toString().trim();

                if(name.isEmpty() || addr.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Fill all empty blanks", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Application.contacts.add(new Contact(name, addr));
                    listFragment.notifyDataChanged();
                }
            }
        });

        this.OnItemSelected(0);
    }

    @Override
    public void OnItemSelected(int index) {
        Contact contact = Application.contacts.get(index);
        tvName.setText(contact.getName());
        tvAddr.setText(contact.getAddr());
    }
}