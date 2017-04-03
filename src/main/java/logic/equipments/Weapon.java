package logic.equipments;

/**
 * @author Kai QI
 * @version 0.3
 */
public interface Weapon extends Equipment{

    int getRange();
    void setRange(int range);

    Weapon getOrigin();
    String enhancementsChainText();
}
