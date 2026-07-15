// ==========================================
// 1. ABSTRACT BASE CLASS
// ==========================================
abstract class Shape {
    // Abstract methods to be implemented by concrete classes
    public abstract double area();
    public abstract double perimeter();
    
    // Helper to get the actual class name for formatting
    public String getShapeType() {
        return this.getClass().getSimpleName();
    }
}

// ==========================================
// 2. CONCRETE SHAPE IMPLEMENTATIONS
// ==========================================

class Circle extends Shape {
    // Enforcing immutability using private final fields with getter-only access
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    // Getter only (no setter ensures immutability)
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
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimensions must be greater than 0.");
        }
        this.width = width;
        this.height = height;
    }

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
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        // Enforce the Triangle Inequality Theorem: sum of two sides must be > third side
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 ||
            (sideA + sideB <= sideC) || (sideA + sideC <= sideB) || (sideB + sideC <= sideA)) {
            throw new IllegalArgumentException("Invalid sides provided for a structural triangle.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double area() {
        // Heron's Formula for area calculation using 3 sides
        double s = perimeter() / 2.0; // Semi-perimeter
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}

// ==========================================
// 3. EXECUTION APPLICATION ENGINE
// ==========================================
public class ShapeHierarchyApp {
    public static void main(String[] args) {
        System.out.println("--- Initializing Polymorphic Shape Array --- \n");

        // Storing disparate structural shapes into a unified polymorphic array base
        Shape[] shapes = new Shape[] {
            new Circle(5.0),
            new Rectangle(4.0, 7.0),
            new Triangle(3.0, 4.0, 5.0),
            new Circle(2.5),
            new Rectangle(10.0, 2.5)
        };

        // Generating a structured console matrix report
        printShapeReport(shapes);
    }

    private static void printShapeReport(Shape[] shapes) {
        System.out.println("=================================================");
        System.out.printf("%-15s | %-14s | %-14s\n", "Shape Type", "Area", "Perimeter");
        System.out.println("=================================================");

        for (Shape shape : shapes) {
            System.out.printf("%-15s | %-14.4f | %-14.4f\n", 
                    shape.getShapeType(), 
                    shape.area(), 
                    shape.perimeter());
        }
        
        System.out.println("=================================================");
    }
}