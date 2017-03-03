package logic;

import persistence.PlayerFileManager;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Qi Xia
 * this class is the simulation
 */
public class Simulation {
    /**
     * this method is to create new Player
     * @return Player
     */
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

    /**
     * this method is to initial the equipment
     */
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

        equipment = new Equipment("Phyrix Embrace",Equipment.RING,Player.ATTRIBUTE_ARMOR_CLASS,2);
        equipments.add(equipment);

        equipment = new Equipment("Sephuz Secret",Equipment.RING,Player.ABILITY_STR,2);
        equipments.add(equipment);

        equipment = new Equipment("Alythess Pyrogenics",Equipment.RING,Player.ABILITY_CON,3);
        equipments.add(equipment);

        equipment = new Equipment("Chatoyant Signet",Equipment.RING,Player.ABILITY_WIS,5);
        equipments.add(equipment);

        equipment = new Equipment("Dual Determination",Equipment.RING,Player.ABILITY_CHA,5);
        equipments.add(equipment);

    }

    /**
     * this method is to get all the equipments
     * @return List<Equipment>
     */

    public static List<Equipment> getEquipments(){
        return equipments;
    }

    /**
     * this method is to get Equipment
     * @param position String
     * @return List<Equipment>
     */

    public static List<Equipment> getEquipments(String position) {
        List<Equipment> filteredEquipments = new LinkedList<>();

        for (Equipment equipment : equipments) {
            if (equipment.getType() == position){
                filteredEquipments.add(equipment);
            }
        }

        return filteredEquipments;
    }

    /**
     * this method is to create map
     * @return GameMap
     */

    public static GameMap gameMap1(){
        GameMap gameMap = new GameMap();
        gameMap.setSize(4);
        Exit exit1 = new Exit();
        Entrance entrance = new Entrance();

        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 3);

        gameMap.addCell(exit1, point1);
        gameMap.addCell(entrance, point2);

        return gameMap;
    }

    /**
     * this method is to create Campaign
     * @return Campaign
     */

    public static Campaign campaign1(){
        Campaign campaign = new Campaign();

        String gameMap1 = "Howling Abeiase";
        String gameMap2 = "Summoner's Rift";
        String gameMap3 = "Salty Lake";
        String gameMap4 = "Crystal Land";

        campaign.addMapName(gameMap1);
        campaign.addMapName(gameMap2);
        campaign.addMapName(gameMap3);
        campaign.addMapName(gameMap4);

        return campaign;
    }

    /**
     * this method is to create the  player,entrance, exit and obstacle on the map
     * @return GameMap
     */

    public static GameMap gameMap2(){
        GameMap gameMap = new GameMap();
        gameMap.setSize(8);

        Exit exit = new Exit();
        Entrance entrance = new Entrance();
        Obstacle obstacle1 = new Obstacle();
        Obstacle obstacle2 = new Obstacle();
        Obstacle obstacle3 = new Obstacle();
        Obstacle obstacle4 = new Obstacle();
        Obstacle obstacle5 = new Obstacle();
        Obstacle obstacle6 = new Obstacle();
        Obstacle obstacle7 = new Obstacle();
        Obstacle obstacle8 = new Obstacle();
        Obstacle obstacle9 = new Obstacle();

        Player characteur1 = newPlayer();
        characteur1.setName("Joey");
        Player characteur2 = newPlayer();
        characteur2.setName("Monster");

        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 1);
        Point point3 = new Point(3, 1);
        Point point4 = new Point(3, 2);
        Point point5 = new Point(3, 3);
        Point point6 = new Point(4, 5);
        Point point7 = new Point(5, 5);
        Point point8 = new Point(4, 6);
        Point point9 = new Point(4, 7);
        Point pointExit = new Point(7, 7);
        Point pointEntrance = new Point(0, 0);
        Point pointCharacteur1 = new Point(1, 5);
        Point pointCharacteur2 = new Point(2, 7);

        gameMap.addCell(obstacle1, point1);
        gameMap.addCell(obstacle2, point2);
        gameMap.addCell(obstacle3, point3);
        gameMap.addCell(obstacle4, point4);
        gameMap.addCell(obstacle5, point5);
        gameMap.addCell(obstacle6, point6);
        gameMap.addCell(obstacle7, point7);
        gameMap.addCell(obstacle8, point8);
        gameMap.addCell(obstacle9, point9);
        gameMap.addCell(entrance, pointEntrance);
        gameMap.addCell(exit, pointExit);
        gameMap.addCell(characteur1, pointCharacteur1);
        gameMap.addCell(characteur2, pointCharacteur2);

        return gameMap;
    }
}
