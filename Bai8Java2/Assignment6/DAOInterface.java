package Assignment6;

import java.util.ArrayList;
import java.util.Scanner;

public interface DAOInterface<E> {

    ArrayList<E> list();
    void update(E e);
    void delete(E e);
    void insert(E e);
    ArrayList<E> searchname(String username);
    E searchid(int id);
}
