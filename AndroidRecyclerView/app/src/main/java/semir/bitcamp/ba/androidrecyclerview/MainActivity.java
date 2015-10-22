package semir.bitcamp.ba.androidrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static PersonList personList = new PersonList();

    private EditText mFirstName;
    private EditText mLastName;
    private Button mAddButton;
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstName = (EditText) findViewById(R.id.first_name);
        mLastName = (EditText) findViewById(R.id.last_name);
        mAddButton = (Button) findViewById(R.id.add);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        personAdapter = new PersonAdapter(personList);
        recyclerView.setAdapter(personAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable firstName = mFirstName.getText();
                Editable lastName = mLastName.getText();

                personList.addPerson(firstName, lastName);

            }
        });

    }

    private class PersonHolder extends RecyclerView.ViewHolder {
        private TextView firstName;
        private TextView lastName;
        private TextView dateAdded;

        public PersonHolder(View itemView){
            super(itemView);

            firstName = (TextView) itemView.findViewById(R.id.person_layout_first_name);
            lastName = (TextView) itemView.findViewById(R.id.person_layout_last_name);
            dateAdded = (TextView) itemView.findViewById(R.id.person_layout_date_added);

        }

    }

    private class PersonAdapter extends RecyclerView.Adapter<PersonHolder> {

        private PersonList personList;

        public PersonAdapter(PersonList personList) {
            this.personList = personList;
        }

        @Override
        public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            View view = layoutInflater.inflate(R.layout.person_layout, parent, false);

            return new PersonHolder(view);
        }

        @Override
        public void onBindViewHolder(PersonHolder holder, int position) {
            Person person = personList.getPerson(position);

            holder.firstName.setText(person.getmFirstName());
            holder.lastName.setText(person.getmLastName());
            holder.dateAdded.setText(person.getmDate().toString());
        }


        @Override
        public int getItemCount() {
            return personList.getPersonListSize();
        }

    }



}
