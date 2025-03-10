package DnD.Character;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    List<Memento> mementoList;

    public void add(Memento m) {
        if (mementoList == null) {
            mementoList = new ArrayList<>();
        }
        mementoList.add(m);
    }
    public Memento get(int i) {
        return mementoList.get(i);
    }
}
