package exercise;

// BEGIN
public class App {

    public static void printSquare(Circle circle) {
        try {
            double square = circle.getSquare();
            System.out.println((int) Math.round(square)); // Округление площади до ближайшего целого числа
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        }
        System.out.println("Вычисление окончено");
    }
}
// END
