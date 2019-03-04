package HomeworkClass1;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {

    public abstract void insertPhone(String name,String phone);
    public abstract void removePhone(String name);
    public abstract void updatePhone(String name,String newphone);
    public abstract void searchPhone(String name);
    public abstract List<PhoneDetail> sort(ArrayList<PhoneDetail> phoneList);

}
