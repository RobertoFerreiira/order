package program;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String date = sc.nextLine();
        LocalDate data = LocalDate.parse(date, formatter);
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());
        System.out.print("How many items to this order? ");
        int items = sc.nextInt();
        sc.nextLine();
        Order newOrder = new Order(orderStatus, new Client(name, email, data));
        for(int i = 0; i < items; i++){
            System.out.println("Enter #"+(i+1)+" item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();;
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            newOrder.addItem(new OrderItem(quantity, new Product(productName, productPrice)));
        }
        System.out.println(newOrder);
        newOrder.printItems();
    }
}