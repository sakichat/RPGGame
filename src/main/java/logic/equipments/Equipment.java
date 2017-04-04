package logic.equipments;

/**
 * This class is the equitment
 * @author Li Zhen
 * @version 0.1
 */

public interface Equipment {

    public final static String HELMET = "Helmet";
    public final static String ARMOR = "Armor";
    public final static String SHIELD = "Shield";
    public final static String RING = "Ring";
    public final static String BELT = "Belt";
    public final static String BOOTS = "Boots";
    public final static String WEAPON = "Weapon";

    public final static String WEAPON_TYPE_MELEE = "Melee";
    public final static String WEAPON_TYPE_RANGED = "Ranged";

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
