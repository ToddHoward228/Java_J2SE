package DnD;

public enum DiceVar {
    D4(4), D6(6), D8(8),
    D10(10), D12(12), D20(20);

    private final int numValue;

    DiceVar(int value) {
        numValue = value;
    }

    public int getNumValue() {
        return numValue;
    }

    public static DiceVar fromNumValue(int numValue) {
        for (DiceVar d : DiceVar.values()) {
            if (d.numValue == numValue)
                return d;
        }
        throw new IllegalArgumentException("There is no Dice with value: " + numValue);
    }

    public static boolean isContain(String dice) {
        try {
            DiceVar.valueOf(dice);
            return true;
        }
        catch(IllegalArgumentException e){
            return false;
        }
    }

}
