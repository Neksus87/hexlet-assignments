package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
    public static Car deserialize(String jsonRepresentation) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonRepresentation, Car.class);
    }
    // END
}
