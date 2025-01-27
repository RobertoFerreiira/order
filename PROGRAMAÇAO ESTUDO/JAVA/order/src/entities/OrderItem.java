package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;


    public OrderItem(Integer quantity, Product product){
        this.quantity = quantity;
        this.product = product;
    }

    public double subTotal(Product product){
        price = quantity * product.getPrice();
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String toString(){
        return this.getQuantity() +" "+ this.getProduct().getName()+" "+this.getProduct().getPrice();
    }
}
