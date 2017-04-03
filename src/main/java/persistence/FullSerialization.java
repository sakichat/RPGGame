package persistence;

import com.google.gson.*;
import logic.*;

import java.lang.reflect.Type;

/**
 * Created by Zhaozhe on 02/04/2017.
 */
public class FullSerialization implements JsonSerializer<Object>, JsonDeserializer<Object> {

    @Override
    public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement element = FileManager.defaultGson().toJsonTree(o);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_class", o.getClass().getName());
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
        Point point = new Point(1, 2);

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeHierarchyAdapter(Object.class, new FullSerialization())
                .setPrettyPrinting()
                .create();

        String s = gson.toJson(point);


        Point point1 = gson.fromJson(s, Point.class);


    }
}
