package logic.equipment;

/**
 * This class is the interface of equipment.
 * @author Li Zhen
 * @version 0.3
 */

public interface Equipment {

    public final static String HELMET = "Helmet";
    public final static String ARMOR = "Armor";
    public final static String SHIELD = "Shield";
    public final static String RING = "Ring";
    public final static String BELT = "Belt";
    public final static String BOOTS = "Boots";
    public final static String WEAPON = "Weapon";

    boolean validate();

    String getName();
    void setName(String name);

    String getType();
    void setType(String type);

    String getEnhancedAttribute();
    void setEnhancedAttribute(String enhancedAttribute);

    int getEnhancedValue();
    void setEnhancedValue(int enhancedValue);

    void levelRefresh(int level);

    String displayName();

}
