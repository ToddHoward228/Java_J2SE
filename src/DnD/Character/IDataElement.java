package DnD.Character;

import DnD.Character.Visitor.IDataElementVisitor;

public interface IDataElement {
    public void accept(IDataElementVisitor visitor);
}
