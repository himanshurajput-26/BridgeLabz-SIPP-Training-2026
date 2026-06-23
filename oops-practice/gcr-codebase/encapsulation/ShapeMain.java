// Abstract class defining the contract for structural shapes
abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
}

class Circle extends Shape {
    private final double radius; // Enforced immutability

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}

class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() { return sideA; }
    public void setSideA(double sideA) { this.sideA = sideA; }
    public double getSideB() { return sideB; }
    public void setSideB(double sideB) { this.sideB = sideB; }
    public double getSideC() { return sideC; }
    public void setSideC(double sideC) { this.sideC = sideC; }

    @Override
    public double area() {
        // Heron's Formula for area calculation
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }
}

public class ShapeMain {
    public static void main(String[] clonedArgs) {
        Shape[] shapes = new Shape[] {
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0, 5.0)
        };

        System.out.println("====== SHAPE AREA REPORT ======");
        for (Shape shape : shapes) {
            System.out.printf("Type: %-12s | Area: %-7.2f | Perimeter: %.2f%n", 
                shape.getClass().getSimpleName(), shape.area(), shape.perimeter());
        }
    }
}