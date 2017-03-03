package persistence;

import com.google.gson.*;
import com.sun.org.apache.regexp.internal.RE;
import logic.*;

import java.lang.reflect.Type;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class CellSerialization implements JsonSerializer<Cell>, JsonDeserializer<Cell> {

    @Override
    public JsonElement serialize(Cell cell, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement element = new Gson().toJsonTree(cell);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_class", cell.getClass().getSimpleName());
        jsonObject.add("_object", element);
        return jsonObject;
    }

    @Override
    public Cell deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String className = jsonObject.get("_class").getAsString();
        JsonElement object = jsonObject.get("_object");

        Gson gson = new Gson();

        if (className.equals(Entrance.class.getSimpleName())) {
            return gson.fromJson(object, Entrance.class);

        } else if (className.equals(Exit.class.getSimpleName())) {
            return gson.fromJson(object, Exit.class);

        } else if (className.equals(Obstacle.class.getSimpleName())) {
            return gson.fromJson(object, Obstacle.class);

        } else if (className.equals(Player.class.getSimpleName())) {
            return gson.fromJson(object, Player.class);

        } else if (className.equals(Chest.class.getSimpleName())) {
            return gson.fromJson(object, Chest.class);

        }

        return null;
    }
}
