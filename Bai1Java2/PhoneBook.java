package HomeworkClass1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneBook extends Phone {
    ArrayList<PhoneDetail> PhoneList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void insertPhone(String name, String phone) {
        String [] output;
        for (int i = 0; i < PhoneList.size(); i++) {
            if (name.equals(PhoneList.get(i).name) ){
                if(PhoneList.get(i).phone.contains(":")){
                    output =PhoneList.get(i).phone.split("\\:");
                    int count = 0;
                    for (int j = 0; j < output.length; j++) {
                        if(phone.equals(output[j])){
                            count++;
                        }
                    }
                    if(count == 0){
                        PhoneList.get(i).phone +=":"+phone;
                    }
                    return;
                }
                else {
                    PhoneList.get(i).phone +=":"+phone;
                    return;
                }

            }
        }
        
        PhoneDetail phoneDetail = new PhoneDetail(name,phone);
        PhoneList.add(phoneDetail);
    }

    @Override
    public void removePhone(String name) {
        PhoneDetail phoneDetail = new PhoneDetail();
        for (int i = 0; i < PhoneList.size(); i++) {
            if(name.equals(PhoneList.get(i).name) ){
                phoneDetail = PhoneList.get(i);
                PhoneList.remove(phoneDetail);
                return;
            }
        }
        System.out.println("Do not exist this name");
    }

    @Override
    public void updatePhone(String name, String newphone) {

        for (int i = 0; i < PhoneList.size(); i++) {
            if(name.equals(PhoneList.get(i).name)){
                PhoneList.get(i).phone = newphone;
                return;
            }

        }
        System.out.println("Do not exist this name");
    }

    @Override
    public void searchPhone(String name) {
        for (int i = 0; i < PhoneList.size(); i++) {
            if(name.equals(PhoneList.get(i).name)){
                System.out.println("Phone of this person: "+PhoneList.get(i).phone);
                return;
            }
        }
        System.out.println("Do not exist this name");
    }

    @Override
    public List<PhoneDetail> sort(ArrayList<PhoneDetail> phoneList) {
        List<PhoneDetail> sorted = phoneList
                .stream()
                .sorted(new Comparator<PhoneDetail>() {
                    @Override
                    public int compare(PhoneDetail o1, PhoneDetail o2) {
                        return o1.name.compareTo(o2.name);
                    }
                })
                .collect(Collectors.toList());
        return sorted;
    }

    public PhoneBook() {
    }
}
