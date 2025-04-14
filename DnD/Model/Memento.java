package DnD.Model;

import java.util.ArrayList;

public class Memento {
    ArrayList<String> mementoList;

    public void add(ArrayList<String> mem) {
        mementoList = new ArrayList<>(mem);
    }

    public ArrayList<String> undo() {
        return mementoList;
    }

}
