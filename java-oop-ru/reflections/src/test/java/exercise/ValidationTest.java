package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testAdvancedValidate() {
        // Тест 1: все валидные поля
        Address validAddress = new Address("Russia", "Ufa", "Lenina", "54", null);
        Map<String, List<String>> result1 = Validator.advancedValidate(validAddress);
        assertThat(result1).isEmpty();

        // Тест 2: поле country будет null
        Address addressWithNullCountry = new Address(null, "London", "1-st street", "5", "1");
        Map<String, List<String>> result2 = Validator.advancedValidate(addressWithNullCountry);
        assertThat(result2).containsEntry("country", List.of("can not be null"));

        // Тест 3: поля city и street будут null
        Address addressWithNullCityStreet = new Address("USA", null, null, "7", "2");
        Map<String, List<String>> result3 = Validator.advancedValidate(addressWithNullCityStreet);
        assertThat(result3).containsEntry("city", List.of("can not be null"));
        assertThat(result3).containsEntry("street", List.of("can not be null"));

        // Тест 4: country имеет длину менее 4
        Address addressWithShortCountry = new Address("US", "Texas", "Main St", "7", "2");
        Map<String, List<String>> result4 = Validator.advancedValidate(addressWithShortCountry);
        assertThat(result4).containsEntry("country", List.of("length less than 4"));
    }
    // END
}
