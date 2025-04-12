package DnD.Character.Visitor;

import DnD.Character.IFeature;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class JSONOutputVisitor implements IDataElementVisitor {

    JSONObject obj;
    String path = "output.json";

    public void changePath(String path) {
        this.path = path;
    }

    public void visit(DnD.Character.Character character){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(toJSONString(character));
            writer.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void visit(DnD.Character.Stats stats){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(toJSONString(stats));
            writer.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void visit(DnD.Character.CharacterClass characterClass){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(toJSONString(characterClass));
            writer.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void visit(DnD.Character.CharacterRace characterRace){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(toJSONString(characterRace));
            writer.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    String toJSONString(DnD.Character.Character character) {
        obj = new JSONObject();

        obj.put("class", "Character");
        obj.put("name", character.getName());
        obj.put("gender", character.getGender().toString());
        obj.put("alignment", character.getAlignment().toString());
        obj.put("hp", character.getHp());
        obj.put("level", character.getLevel());

        return obj.toJSONString();
    }

    String toJSONString(DnD.Character.Stats stats) {
        obj = new JSONObject();

        obj.put("class", "Stats");
        obj.put("strength", stats.getStrength());
        obj.put("dexterity", stats.getDexterity());
        obj.put("constitution", stats.getConstitution());
        obj.put("intelligence", stats.getIntelligence());
        obj.put("wisdom", stats.getWisdom());
        obj.put("charisma", stats.getCharisma());

        return obj.toJSONString();
    }

    String toJSONString(DnD.Character.CharacterClass characterClass) {
        obj = new JSONObject();

        obj.put("class", "characterClass");
        obj.put("name", characterClass.getName());
        obj.put("hitPointDie", characterClass.getHitPointDie().toString());

        JSONArray featuresArray = new JSONArray();
        JSONObject feature;

        for (IFeature f : characterClass.getClassFeatures()){
            feature = new JSONObject();

            feature.put("name", f.getName());
            feature.put("description", f.getDescription());
            featuresArray.add(feature);
        }

        obj.put("features",featuresArray);

        return obj.toJSONString();
    }

    String toJSONString(DnD.Character.CharacterRace race) {
        obj = new JSONObject();

        obj.put("class", "CharacterRace");
        obj.put("name", race.getName());
        obj.put("description", race.getDescription());

        JSONArray featuresArray = new JSONArray();
        JSONObject feature;

        for (IFeature f : race.getRaceFeatures()){
            feature = new JSONObject();

            feature.put("name", f.getName());
            feature.put("description", f.getDescription());
            featuresArray.add(feature);
        }

        obj.put("features",featuresArray);

        return obj.toJSONString();
    }
}
