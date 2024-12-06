package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area; // Общая площадь
    }

    @Override
    public int compareTo(Home another) {
        double thisArea = this.getArea();
        double anotherArea = another.getArea();
        return Double.compare(thisArea, anotherArea); // Используем метод для сравнения
    }

    @Override
    public String toString() {
        return String.format("%d этажный коттедж площадью %.1f метров", floorCount, area);
    }
}
// END
