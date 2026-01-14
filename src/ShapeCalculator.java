import java.util.Scanner;

// Abstract Shape class
abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

// Square class
class Square extends Shape {
    double side;

    Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }
}

// Rectangle class
class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}

// Circle class
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Main class
public class ShapeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Shape shape = null;

        // Display menu
        System.out.println("---- Shape Calculator ----");
        System.out.println("1. Square");
        System.out.println("2. Rectangle");
        System.out.println("3. Circle");
        System.out.print("Select a shape (1-3): ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter side length: ");
                double side = sc.nextDouble();
                shape = new Square(side);
                break;

            case 2:
                System.out.print("Enter length: ");
                double length = sc.nextDouble();
                System.out.print("Enter width: ");
                double width = sc.nextDouble();
                shape = new Rectangle(length, width);
                break;

            case 3:
                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();
                shape = new Circle(radius);
                break;

            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Area: " + shape.area());
        System.out.println("Perimeter: " + shape.perimeter());

        sc.close();
    }
}
