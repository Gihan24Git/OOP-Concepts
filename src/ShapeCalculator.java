import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Shape {

    public void printOutput() {
        System.out.println("Shape: " + getShapeName());
        System.out.println("\nProperties:");
        printProperties();
        System.out.println("\nArea: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }

    abstract String getShapeName();
    abstract void printProperties();
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

class InvalidDimensionException extends Exception {
    public InvalidDimensionException(String message) {
        super(message);
    }
}

class Square extends Shape {

    private final double side;

    public Square(double side) throws InvalidDimensionException {
        if (side <= 0) {
            throw new InvalidDimensionException("Side must be greater than 0");
        }
        this.side = side;
    }

    String getShapeName() {
        return "Square";
    }

    void printProperties() {
        System.out.println("Side = " + side);
    }

    double calculateArea() {
        return side * side;
    }

    double calculatePerimeter() {
        return 4 * side;
    }
}

class Rectangle extends Shape {

    private final double height;
    private final double width;

    public Rectangle(double height, double width) throws InvalidDimensionException {
        if (height <= 0 || width <= 0) {
            throw new InvalidDimensionException("Height and Width must be greater than 0");
        }
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

    double calculateArea() {
        return height * width;
    }

    double calculatePerimeter() {
        return 2 * (height + width);
    }
}

class Circle extends Shape {

    private final double radius;

    public Circle(double radius) throws InvalidDimensionException {
        if (radius <= 0) {
            throw new InvalidDimensionException("Radius must be greater than 0");
        }
        this.radius = radius;
    }

    String getShapeName() {
        return "Circle";
    }

    void printProperties() {
        System.out.println("Radius = " + radius);
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

public class ShapeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Shape shape;

        while (true) {
            try {
                System.out.println("\n--- Shape Menu ---");
                System.out.println("1. Square");
                System.out.println("2. Rectangle");
                System.out.println("3. Circle");
                System.out.println("4. Exit");
                System.out.print("Select a shape: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter side length: ");
                        double side = scanner.nextDouble();
                        shape = new Square(side);
                    }
                    case 2 -> {
                        System.out.print("Enter height: ");
                        double height = scanner.nextDouble();
                        System.out.print("Enter width: ");
                        double width = scanner.nextDouble();
                        shape = new Rectangle(height, width);
                    }
                    case 3 -> {
                        System.out.print("Enter radius: ");
                        double radius = scanner.nextDouble();
                        shape = new Circle(radius);
                    }
                    case 4 -> {
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close();
                        return;
                    }
                    default -> throw new IllegalArgumentException("Invalid menu choice!");
                }

                System.out.println();
                shape.printOutput();

            } catch (InputMismatchException e) {
                System.out.println(" Error: Please enter numbers.");
                scanner.nextLine();

            } catch (InvalidDimensionException e) {
                System.out.println(" Dimension Error: " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println(" Menu Error: " + e.getMessage());
            }
        }
    }
}
