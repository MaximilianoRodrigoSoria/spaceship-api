package ar.com.laboratory.openapirestexample.util;


import ar.com.laboratory.openapirestexample.util.exceptions.CannotParseObjectException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonHandler {

    private final ObjectMapper objectMapper;

    @Autowired
    public JsonHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> String toJson(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new CannotParseObjectException("Could not parse object of type " + object.getClass().getName() + " to json");
        }
    }

    public <T> JsonNode toJsonNode(T object) {
        return this.toJsonNode(this.toJson(object));
    }

    public JsonNode toJsonNode(String json) {
        try {
            return this.objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new CannotParseObjectException("Could not map json to JsonNode");
        }
    }

    public <T> T fromObject(Object obj, Class<T> type) {
        return this.objectMapper.convertValue(obj, type);
    }

    public ObjectNode createObjectNode() {
        return this.objectMapper.createObjectNode();
    }

    public ArrayNode createArrayNode() {
        return this.objectMapper.createArrayNode();
    }

}
