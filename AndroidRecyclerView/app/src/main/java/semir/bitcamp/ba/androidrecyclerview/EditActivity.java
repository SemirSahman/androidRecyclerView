package semir.bitcamp.ba.androidrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class EditActivity extends AppCompatActivity {

    private UUID value;
    private EditText mPersonFirstName;
    private EditText mPersonLastName;
    private Button mSavePersonDetails;
    private Person person;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mPersonFirstName = (EditText) findViewById(R.id.person_layout_first_name);
        mPersonLastName = (EditText) findViewById(R.id.person_layout_last_name);
        mSavePersonDetails = (Button) findViewById(R.id.add);

        person = (Person) getIntent().getExtras().getSerializable(MainActivity.KEY_INTENT);
        PersonList list = (PersonList) PersonList.getPersonList();
        position = list.findPosition(person);

        mPersonFirstName.setText(person.getmFirstName());
        mPersonLastName.setText(person.getmLastName());

        mSavePersonDetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PersonList.getPerson(position).setmFirstName(mPersonFirstName.getText().toString());
                PersonList.getPerson(position).setmLastName(mPersonLastName.getText().toString());
                Toast.makeText(EditActivity.this, "Change saved", Toast.LENGTH_LONG).show();
            }
        });




    }
}