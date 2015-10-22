package semir.bitcamp.ba.androidrecyclerview;

import android.text.Editable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by semir.sahman on 21.10.15..
 */
public class PersonList {

    private List<Person> personList;

    public PersonList() {
        personList = new ArrayList<>();
    }

    public int getPersonListSize() {
        return personList.size();
    }

    public void addPerson(Editable firstName, Editable lastName) {
        personList.add(new Person(firstName.toString(), lastName.toString()));
    }

    public Person getPerson(int index) {
        return personList.get(index);
    }

    public void deletePerson(UUID id) {
        Iterator<Person> iterator = personList.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getmId().equals(id)) {
                iterator.remove();
                return;
            }
        }
    }

}
