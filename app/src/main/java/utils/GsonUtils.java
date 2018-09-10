package utils;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GsonUtils {

    public static  <T> T toBean(String s,Type type){
        return new Gson().fromJson(s,type);
    }

    public static Type newType(Type type,Type... types){
        if(types.length == 0){
            return type;
        }else {
            return new JsonType(type,types);
        }

    }
    static class JsonType implements ParameterizedType{

        public Type type;
        public Type[] types;

        public JsonType(Type type, Type... types) {
            this.type = type;
            this.types = types;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return types;
        }

        @Override
        public Type getRawType() {
            return type;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }

}
