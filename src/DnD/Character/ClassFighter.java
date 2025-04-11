package DnD.Character;

import DnD.DiceVar;

public class ClassFighter extends CharacterClass {
    public ClassFighter() {
        name = "Fighter";

        hitPointDie = DiceVar.D10;

        classFeatures.add(new FeaturePerk("Action Surge", "You can push yourself beyond your normal limits for " +
                "a moment. On your turn, you can take one additional action, except the Magic action.\n" +
                "Once you use this feature, you can’t do so again until you finish a Short or Long Rest. "));

    }
}
