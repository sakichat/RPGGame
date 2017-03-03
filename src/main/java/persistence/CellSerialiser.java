package persistence;

import com.google.gson.*;
import logic.Cell;

import java.lang.reflect.Type;

/**
 * Created by Penelope on 17/3/3.
 */
public class CellSerialiser implements JsonSerializer<Cell>, JsonDeserializer<Cell> {

    @Override
    public JsonElement serialize(Cell cell, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }

    @Override
    public Cell deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
