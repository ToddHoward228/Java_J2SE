package DnD;


/**
 * The {@code DX} enum represents common types of dice.
 * Each enum constant corresponds to a die with a specific number of sides.
 *
 * <p>Typical dice types include:
 * <ul>
 *   <li>{@code D4}  - four-sided die</li>
 *   <li>{@code D6}  - six-sided die (standard)</li>
 *   <li>{@code D8}  - eight-sided die</li>
 *   <li>{@code D10} - ten-sided die</li>
 *   <li>{@code D12} - twelve-sided die</li>
 *   <li>{@code D20} - twenty-sided die (common in D&D)</li>
 *   <li>{@code D100} - percentile die</li>
 * </ul>
 */
public enum DX {
    D4(4), D6(6), D8(8),
    D10(10), D12(12), D20(20), D100(100);

    private final int numValue;

    DX(int value) {
        numValue = value;
    }

    public int getNumValue() {
        return numValue;
    }

    /**
     * @param numValue sides of die
     * @return die with specified sides
     * @throws IllegalArgumentException if there is no Die with entered sides
     */
    public static DX fromNumValue(int numValue) throws IllegalArgumentException {
        for (DX d : DX.values()) {
            if (d.numValue == numValue)
                return d;
        }
        throw new IllegalArgumentException("There is no Die with sides = " + numValue);
    }

    public static boolean isContain(String dice) {
        try {
            DX.valueOf(dice);
            return true;
        }
        catch(IllegalArgumentException e){
            return false;
        }
    }

}
