package com.yuriy.model.serializer;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.jackson.JsonObjectSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.yuriy.model.User;

/**
 * Created by yyakymchuk on 5/15/2017.
 */
@JsonComponent
public class UserSerializerDeserializer {

	public static class Serializer extends JsonObjectSerializer<User> {

		@Override
		protected void serializeObject(final User user, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
			jsonGenerator.writeNumberField("id_c", user.getId());
			jsonGenerator.writeStringField("name_c", user.getName());
			jsonGenerator.writeStringField("surname_c", user.getSurname());
		}
	}

	public static class Deserializer extends JsonObjectDeserializer<User> {

		@Override
		protected User deserializeObject(final JsonParser jsonParser, final DeserializationContext deserializationContext, final ObjectCodec objectCodec, final JsonNode jsonNode) throws IOException {
			return new User(jsonNode.get("id").asLong(), jsonNode.get("name").asText(), jsonNode.get("surname").asText());
		}
	}
}
