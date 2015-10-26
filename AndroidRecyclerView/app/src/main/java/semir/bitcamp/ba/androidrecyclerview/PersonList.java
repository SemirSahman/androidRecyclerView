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

    private static List<Person> personList;

    public PersonList() {
        personList = new ArrayList<>();
    }

    public int getPersonListSize() {
        return personList.size();
    }

    public void addPerson(Editable firstName, Editable lastName) {
        personList.add(new Person(firstName.toString(), lastName.toString()));
    }

    public static Person getPerson(int index) {
        return personList.get(index);
    }

    public int findPosition(Person person) {
        for (int i = 0; i < personList.size(); i++) {
            if (person.getmId().equals(personList.get(i).getmId())) {
                return i;
            }
        }

        return -1;
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

    public static List<Person> getPersonList() {
        return personList;
    }
}
