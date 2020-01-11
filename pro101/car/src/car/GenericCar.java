package car;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class GenericCar<C extends Car> {

    LinkedList<C> m = new LinkedList<>();

    public void Add(C list) {
        m.add(list);
    }

    public LinkedList Display() {
        return m;
    }

    public int getSize() {
        return m.size();
    }

    public boolean checkEmpty() {
        return m.isEmpty();
    }

    public void Delete(int pos) {
        m.remove(pos);
    }

    public void Sort() {
        Comparator<C> byPrice = Comparator.comparing(C::getPrice);
        Collections.sort(m, byPrice);
    }

    public int Search(String name) {
        for (C v : m) {
            if (name.compareTo(v.getName()) == 0);
            return 1;
        }
        return 0;
    }
}
