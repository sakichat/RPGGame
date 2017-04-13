package logic;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class BaseUpdate {

    /**
     * attribute
     */
    private Object update;

    /**
     * This is the method for when
     * @param update
     * @return BaseUpdate
     */
    public static BaseUpdate when(Object update) {
        BaseUpdate baseUpdate = new BaseUpdate();
        baseUpdate.update = update;
        return baseUpdate;
    }

    /**
     * attribute
     */
    private List<String> matches = new LinkedList<>();

    /**
     * This is the method for match
     * @param event
     * @return BaseUpdate
     */
    public BaseUpdate match(String event){
        matches.add(event);
        return this;
    }

    /**
     * This is the method for check
     * @return Boolean
     */
    public boolean check(){
        return matches.stream().anyMatch(m -> m.equals(update));
    }
}
