package game;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Qi Xia
 */
public class Simulation {
    public static Player newPlayer(){
        Player player = new Player("playerDemo");
        player.setLevel(2);
        player.generateAbilities();
        player.generateHp();

        player.pickUpEquipment(getEquipments(Equipment.WEAPON).get(0));
        player.pickUpEquipment(getEquipments(Equipment.SHIELD).get(0));
        player.pickUpEquipment(getEquipments(Equipment.WEAPON).get(1));
        player.pickUpEquipment(getEquipments(Equipment.HELMET).get(0));
        player.pickUpEquipment(getEquipments(Equipment.BOOTS).get(0));

        player.equip(player.equipmentsInBackpack().get(0));
        player.equip(player.equipmentsInBackpack().get(0));

        player.setHp(100);

        return player;
    }


    static {
        initEquipments();
    }

    private static List<Equipment> equipments;

    private static void initEquipments(){
        equipments = new LinkedList<>();

        Equipment equipment;

        equipment = new Equipment("Light Leather",Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,1);
        equipments.add(equipment);

        equipment = new Equipment("Quilted Leather",Equipment.ARMOR,Player.ATTRIBUTE_ARMOR_CLASS,3);
        equipments.add(equipment);

        equipment = new Equipment("Arming Coat",Equipment.ARMOR,Player.ATTRIBUTE_ARMOR_CLASS,5);
        equipments.add(equipment);

        equipment = new Equipment("Might of Dread",Equipment.HELMET,Player.ABILITY_INT,3);
        equipments.add(equipment);

        equipment = new Equipment("Coif of Delusions",Equipment.HELMET,Player.ABILITY_WIS,5);
        equipments.add(equipment);

        equipment = new Equipment("Dawn of Insanity",Equipment.HELMET,Player.ATTRIBUTE_ARMOR_CLASS,2);
        equipments.add(equipment);

        equipment = new Equipment("Oathkeeper",Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,3);
        equipments.add(equipment);

        equipment = new Equipment("Ghostwalker",Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,4);
        equipments.add(equipment);

        equipment = new Equipment("Sierra",Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,5);
        equipments.add(equipment);

        equipment = new Equipment("Linen Sash",Equipment.BELT,Player.ABILITY_CON,3);
        equipments.add(equipment);

        equipment = new Equipment("Loyal Wool Sash",Equipment.BELT,Player.ABILITY_STR,4);
        equipments.add(equipment);

        equipment = new Equipment("Cord of Beginnings",Equipment.BELT,Player.ABILITY_CON,5);
        equipments.add(equipment);

        equipment = new Equipment("Steel Walkers",Equipment.BOOTS,Player.ATTRIBUTE_ARMOR_CLASS,3);
        equipments.add(equipment);

        equipment = new Equipment("Bronze Warboots",Equipment.BOOTS,Player.ABILITY_DEX,4);
        equipments.add(equipment);

        equipment = new Equipment("Bone Stompers",Equipment.BOOTS,Player.ABILITY_DEX,5);
        equipments.add(equipment);

        equipment = new Equipment("Ashbringer",Equipment.WEAPON,Player.ATTRIBUTE_ATTACK_BONUS,5);
        equipments.add(equipment);

        equipment = new Equipment("Axe of Cenarius",Equipment.WEAPON,Player.ATTRIBUTE_DAMAGE_BONUS,5);
        equipments.add(equipment);

        equipment = new Equipment("Bloodhoof Runespear",Equipment.WEAPON,Player.ATTRIBUTE_DAMAGE_BONUS,5);
        equipments.add(equipment);

        equipment = new Equipment("Phyrix's Embrace",Equipment.RING,Player.ATTRIBUTE_ARMOR_CLASS,2);
        equipments.add(equipment);

        equipment = new Equipment("Sephuz's Secret",Equipment.RING,Player.ABILITY_STR,2);
        equipments.add(equipment);

        equipment = new Equipment("Alythess's Pyrogenics",Equipment.RING,Player.ABILITY_CON,3);
        equipments.add(equipment);

        equipment = new Equipment("Chatoyant Signet",Equipment.RING,Player.ABILITY_WIS,5);
        equipments.add(equipment);

        equipment = new Equipment("Dual Determination",Equipment.RING,Player.ABILITY_CHA,5);
        equipments.add(equipment);

    }

    public static List<Equipment> getEquipments(){
        return equipments;
    }

    public static List<Equipment> getEquipments(String position) {
        List<Equipment> filteredEquipments = new LinkedList<>();

        for (Equipment equipment : equipments) {
            if (equipment.getType() == position){
                filteredEquipments.add(equipment);
            }
        }

        return filteredEquipments;
    }

}
