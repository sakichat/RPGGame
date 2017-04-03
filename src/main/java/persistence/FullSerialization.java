package persistence;

import com.google.gson.*;
import logic.*;
import logic.equipments.Equipment;
import logic.equipments.EquipmentSolid;

import java.lang.reflect.Type;


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

}
