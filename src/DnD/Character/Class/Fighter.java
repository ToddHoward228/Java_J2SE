package DnD.Character.Class;

import DnD.Character.Perk;

public class Fighter extends CharacterClass {
    Fighter() {
        name = "Fighter";

        HitPointDie = 10;

        classFeatures.add(new Perk("Action Surge", "You can push yourself beyond your normal limits for " +
                "a moment. On your turn, you can take one additional action, except the Magic action.\n" +
                "Once you use this feature, you can’t do so again until you finish a Short or Long Rest. "));

    }
}
