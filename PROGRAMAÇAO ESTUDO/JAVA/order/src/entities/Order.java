package entities;

import enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private LocalDateTime moment = LocalDateTime.now();
    private List<OrderItem> items = new ArrayList<>();
    private OrderStatus status;
    private Client client;

    public Order(OrderStatus status, Client client){
        this.status = status;
        this.client = client;
    }


    public Order(){

    }

    public String getMoment() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        return moment.format(date);
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item){
        this.items.add(item);
    }

    public void removeItem(OrderItem item){
        this.items.remove(item);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ").append(getMoment()+"\n");
        sb.append("Order status: ").append(getStatus()+"\n");
        sb.append("Client: ").append(client.getName()).append(" ("+client.getBirthDate()+")").append(" - ").append(client.getEmail()+"\n");
        sb.append("Order Items: ");
        return sb.toString();
    }
    public void printItems(){
        for(OrderItem item : items){
            System.out.println(item.getProduct().getName()+ ", $" +String.format("%.2f", item.getProduct().getPrice())+
                    ", Quantity: " + item.getQuantity() +
                    ", Subtotal: $" + String.format("%.2f", item.subTotal(item.getProduct())));
        }
        System.out.println("Total price: $"+ String.format("%.2f", total()));
    }

    public Double total(){
        double sum = 0;
        for(OrderItem item: items){
            sum += item.subTotal(item.getProduct());
        }
        return sum;
    };
}
