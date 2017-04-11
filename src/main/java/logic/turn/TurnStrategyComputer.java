package logic.turn;

import logic.Play;
import logic.map.Cell;
import logic.map.GameMap;
import logic.map.GameMapGraph;
import logic.map.Point;
import logic.player.Player;

import java.util.List;


public class TurnStrategyComputer extends TurnStrategy {
    @Override
    public Point preferredNextLocation() {
        GameMapGraph gameMapGraph = Play.getCurrentPlay().getCurrentMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), player.getRangeForMove());

        if (points.size() != 0){
            Point result = points.get((int)(Math.random() * points.size()));
            return result;
        }else {
            return null;
        }
    }

    @Override
    public boolean couldAttack(Point target) {
        boolean result = false;
        Play play = Play.getCurrentPlay();
        GameMap gameMap = play.getCurrentMap();
        Cell cell = gameMap.getCell(target);
        if (cell == null){
            return result;
        }else {
            if (cell.getCellType().equals(Cell.Type.PLAYER)){
                Player targetPlayer = (Player)cell;
                    if (targetPlayer.isAlive()){
                        result = true;

                }
            }
        }

        return result;
    }

    @Override
    protected boolean couldInteract(Point target) {
        boolean result = false;
        Play play = Play.getCurrentPlay();
        GameMap gameMap = play.getCurrentMap();
        Cell cell = gameMap.getCell(target);
        if (cell.getCellType().equals(Cell.Type.CHEST)){
            result = true;
        }
        if (cell == null){
            return result;
        }else {
            if (cell.getCellType().equals(Cell.Type.PLAYER)){
                Player targetPlayer = (Player)cell;
                if ((targetPlayer.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE)){
                    if (targetPlayer.isAlive()){
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public Point preferredAttackingLocation() {
        List<Point> points = attackTargetsInNear();
        if (points.size() != 0){
            Point result = points.get((int)(Math.random() * points.size()));
            return result;
        }else {
            return null;
        }
    }

    @Override
    public Point preferredInteractionLocation() {
        GameMapGraph gameMapGraph = Play.getCurrentPlay().getCurrentMap().getGraph();
        List<Point> points = interactTargetsInNear();
        if (points.size() != 0){
            Point result = points.get((int)(Math.random() * points.size()));
            return result;
        }else {
            return null;
        }
    }
}
