package com.kardia.volunteersystem.utils;

import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class GsonConfig {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .setDateFormat("MMM d, yyyy hh:mm:ss a")
                .create();
    }

    private static class DateDeserializer implements JsonDeserializer<Date> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy hh:mm:ss a");

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String dateStr = json.getAsString();
            try {
                return dateFormat.parse(dateStr);
            } catch (ParseException e) {
                throw new JsonParseException(e);
            }
        }
    }
}