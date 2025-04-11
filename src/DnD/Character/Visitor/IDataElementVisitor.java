package DnD.Character.Visitor;

public interface IDataElementVisitor {

    void visit(DnD.Character.Character character);
    void visit(DnD.Character.Stats stats);
    void visit(DnD.Character.CharacterClass characterClass);
    void visit(DnD.Character.CharacterRace race);

}
