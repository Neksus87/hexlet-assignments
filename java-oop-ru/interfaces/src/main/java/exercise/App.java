package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        Collections.sort(homes, (a, b) -> a.compareTo(b)); // Сортируем по площади
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(n, homes.size()); i++) {
            result.add(homes.get(i).toString()); // Добавляем строковое представление в результат
        }
        return result;
    }
}
// END
