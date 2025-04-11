package DnD.Character;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    List<String> mementoList;

    public void add(String m) {
        if (mementoList == null) {
            mementoList = new ArrayList<>();
        }
        mementoList.add(m);
    }

    public String undo() {
        return mementoList.removeLast();
    }

}
