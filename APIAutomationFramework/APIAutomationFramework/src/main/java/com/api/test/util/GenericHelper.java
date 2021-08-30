package com.api.test.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.*;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.lang.reflect.Type;

public class GenericHelper {

    public Object convertFromJson(String json, Class classType){
        Gson gsonConverter = (new GsonBuilder()).disableHtmlEscaping().setPrettyPrinting().create();
        return gsonConverter.fromJson(json, classType);
    }

    public  String convertToJson(Object obj) {
        Gson gsonConverter = (new GsonBuilder()).disableHtmlEscaping().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").registerTypeAdapter(ObjectId.class, new JsonSerializer<ObjectId>() {
            @Override
            public JsonElement serialize(ObjectId src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.toHexString());
            }
            public void serialize(ObjectId arg0, JsonGenerator arg1, SerializerProvider arg2)
                    throws IOException, JsonProcessingException {

            }
        }).create();
        return gsonConverter.toJson(obj);
    }
}
