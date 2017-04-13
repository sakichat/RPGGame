package logic.equipment;

/**
 * This class is the interface of equipment.
 * @author Li Zhen
 * @version 0.3
 */

public interface Equipment {

    /**
     * static constant
     */
    public final static String HELMET = "Helmet";
    public final static String ARMOR = "Armor";
    public final static String SHIELD = "Shield";
    public final static String RING = "Ring";
    public final static String BELT = "Belt";
    public final static String BOOTS = "Boots";
    public final static String WEAPON = "Weapon";

    /**
     * This is the method for validate
     * @return Boolean
     */
    boolean validate();

    /**
     * attribute and setter
     * @return String
     */
    String getName();
    void setName(String name);

    /**
     * attribute and setter
     * @return String
     */
    String getType();
    void setType(String type);

    /**
     * attribute and setter
     * @return String
     */
    String getEnhancedAttribute();
    void setEnhancedAttribute(String enhancedAttribute);

    /**
     * attribute and setter
     * @return Integer
     */
    int getEnhancedValue();
    void setEnhancedValue(int enhancedValue);

    /**
     * This is the method for adapt level
     * @param level
     */
    void adapt(int level);

    /**
     * attribute
     * @return String
     */
    String displayName();

}
