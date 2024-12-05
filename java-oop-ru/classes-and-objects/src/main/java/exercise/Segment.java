package exercise;

// BEGIN
public class Segment {
    private Point begin; // Начальная точка отрезка
    private Point end;   // Конечная точка отрезка

    // Конструктор, принимающий две точки — начало и конец отрезка
    public Segment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    // Метод для получения начальной точки отрезка
    public Point getBeginPoint() {
        return begin;
    }

    // Метод для получения конечной точки отрезка
    public Point getEndPoint() {
        return end;
    }

    // Метод для получения середины отрезка
    public Point getMidPoint() {
        int midX = (begin.getX() + end.getX()) / 2; // Вычисление координаты x середины
        int midY = (begin.getY() + end.getY()) / 2; // Вычисление координаты y середины
        return new Point(midX, midY); // Создание новой точки для середины
    }
}
// END
