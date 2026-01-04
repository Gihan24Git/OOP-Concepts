import java.util.Scanner;

// Abstract class
abstract class Shape {

    public void printOutput() {
        System.out.println("Shape : " + getShapeName() + "\n");

        System.out.println("Properties :");
        printProperties();

        System.out.println("\nArea : " + calculateArea());
        System.out.println("Perimeter : " + calculatePerimeter());
    }

    abstract String getShapeName();
    abstract void printProperties();
    abstract int calculateArea();
    abstract int calculatePerimeter();
}

// Square class
class Square extends Shape {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    String getShapeName() {
        return "Square";
    }

    void printProperties() {
        System.out.println("Side = " + side);
    }

    int calculateArea() {
        return side * side;
    }

    int calculatePerimeter() {
        return 4 * side;
    }
}

// Rectangle class
class Rectangle extends Shape {

    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    String getShapeName() {
        return "Rectangle";
    }

    void printProperties() {
        System.out.println("Height = " + height);
        System.out.println("Width = " + width);
    }

    int calculateArea() {
        return height * width;
    }

    int calculatePerimeter() {
        return 2 * (height + width);
    }
}

// Circle class
class Circle extends Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    String getShapeName() {
        return "Circle";
    }

    void printProperties() {
        System.out.println("Radius = " + radius);
    }

    int calculateArea() {
        return (int) (Math.PI * radius * radius);
    }

    int calculatePerimeter() {
        return (int) (2 * Math.PI * radius);
    }
}

// Main class
public class ShapeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Shape shape = null;

        System.out.println("--- Shape Menu ---");
        System.out.println("1. Square");
        System.out.println("2. Rectangle");
        System.out.println("3. Circle");
        System.out.print("Select a shape: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter side length: ");
                shape = new Square(scanner.nextInt());
                break;

            case 2:
                System.out.print("Enter height: ");
                int height = scanner.nextInt();
                System.out.print("Enter width: ");
                int width = scanner.nextInt();
                shape = new Rectangle(height, width);
                break;

            case 3:
                System.out.print("Enter radius: ");
                shape = new Circle(scanner.nextInt());
                break;

            default:
                System.out.println("Invalid choice!");
        }

        if (shape != null) {
            System.out.println();
            shape.printOutput();   // SINGLE reusable output method
        }

        scanner.close();
    }
}
