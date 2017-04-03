package persistence;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import logic.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;


public class FullSerialization implements JsonSerializer<Object>, JsonDeserializer<Object> {

    @Override
    public JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        System.out.println(object.getClass().getName() + "  :  " + type.getTypeName());

        JsonElement element = FileManager.defaultGson().toJsonTree(object);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_class", object.getClass().getName());
        jsonObject.add("_object", element);

        return jsonObject;
    }

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String className = jsonObject.get("_class").getAsString();
        JsonElement object = jsonObject.get("_object");

        Gson gson = FileManager.defaultGson();

        Class<Object> aClass = null;
        try {
            aClass = (Class<Object>)Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return gson.fromJson(object, aClass);
    }

    public static void main(String[] args) {

        Equipment equipment = new NonWeaponEquipment("name", "WEAPON", "STR", 1);

        EquipmentWrapper equipmentWrapper = new EquipmentWrapper(equipment);

        String s = FileManager.defaultGson().toJson(equipmentWrapper);
        System.out.println(s);


//        Point point = new Point(1, 2);
//
//        Gson gson = FileManager.defaultGson();
//
//        String s = gson.toJson(point);
//
//        System.out.println(s);
//
//        Point point1 = gson.fromJson(s, Point.class);

//        GameMap gameMap = new GameMap();
//        gameMap.setName("a");
//        gameMap.setWidth(2);
//        gameMap.setHeight(2);
//        gameMap.addCell(new Obstacle(), new Point(0, 0));
//
//        String s = FileManager.defaultGson().toJson(gameMap);
//        System.out.println(s);

    }
}
