package aldovalzani.esercizi;

import aldovalzani.e_commerceClasses.Customer;
import aldovalzani.e_commerceClasses.Order;
import aldovalzani.e_commerceClasses.Product;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Esercizio2 {
    public static void main(String[] args) {
        Faker faker = new Faker();

        Customer customer1 = new Customer(faker.name().fullName(), 1);
        Customer customer2 = new Customer(faker.name().fullName(), 2);
        Customer customer3 = new Customer(faker.name().fullName(), 1);

        Product product1 = new Product("Electronics", "Laptop", 999.99);
        Product product2 = new Product("Books", "Java Programming", 49.99);
        Product product3 = new Product("Home Appliances", "Vacuum Cleaner", 149.99);

        Order order1 = new Order("Shipped", LocalDate.now(), Arrays.asList(product1), customer1);
        Order order2 = new Order("Delivered", LocalDate.now().minusDays(2), Arrays.asList(product2), customer2);
        Order order3 = new Order("Processing", LocalDate.now().minusWeeks(1), Arrays.asList(product1, product3), customer1);
        Order order4 = new Order("Shipped", LocalDate.now().minusDays(5), Arrays.asList(product2, product3), customer3);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        Map<Customer, Double> totalPriceOrderByCust = orders.stream().
                collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(order -> order.getProducts().
                        stream().mapToDouble(Product::getPrice).sum())));

        totalPriceOrderByCust.forEach((customer, totalSales) -> {
            System.out.println("Cliente: " + customer.getName() + ", Tot. Carrello: € " + totalSales);
        });
    }
}
