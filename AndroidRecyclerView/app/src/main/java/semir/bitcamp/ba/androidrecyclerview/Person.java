package semir.bitcamp.ba.androidrecyclerview;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by semir.sahman on 21.10.15..
 */
public class Person {

    private UUID mId;
    private String mFirstName;
    private String mLastName;
    private Date mDate;


    public Person(String firstName, String lastName){
        mId = UUID.randomUUID();
        this.mFirstName = firstName;
        this.mLastName = lastName;
        mDate = Calendar.getInstance().getTime();
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }
}
