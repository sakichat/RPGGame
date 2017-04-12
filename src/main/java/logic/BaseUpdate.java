package logic;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class BaseUpdate {

    private Object update;

    public static BaseUpdate when(Object update) {
        BaseUpdate baseUpdate = new BaseUpdate();
        baseUpdate.update = update;
        return baseUpdate;
    }

    private List<String> matches = new LinkedList<>();

    public BaseUpdate match(String event){
        matches.add(event);
        return this;
    }

    public boolean check(){
        return matches.stream().anyMatch(m -> m.equals(update));
    }
}
