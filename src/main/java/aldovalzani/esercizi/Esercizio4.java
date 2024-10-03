package aldovalzani.esercizi;

import aldovalzani.e_commerceClasses.Customer;
import aldovalzani.e_commerceClasses.Order;
import aldovalzani.e_commerceClasses.Product;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Esercizio4 {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Customer customer1 = new Customer(faker.name().fullName(), 1);
        Customer customer2 = new Customer(faker.name().fullName(), 2);
        Customer customer3 = new Customer(faker.name().fullName(), 1);

        Product product1 = new Product("Electronics", "Laptop", 999.99);
        Product product2 = new Product("Books", "Java Programming", 49.99);
        Product product3 = new Product("Home Appliances", "Vacuum Cleaner", 149.99);
        Product product4 = new Product("Smartphones", "iPhone", 1199.99);
        Product product5 = new Product("Furniture", "Sofa", 749.99);

        Order order1 = new Order("Shipped", LocalDate.now(), Arrays.asList(product1, product2), customer1);
        Order order2 = new Order("Delivered", LocalDate.now().minusDays(2), Arrays.asList(product2), customer2);
        Order order3 = new Order("Processing", LocalDate.now().minusWeeks(1), Arrays.asList(product1, product3, product4), customer1);
        Order order4 = new Order("Shipped", LocalDate.now().minusDays(5), Arrays.asList(product5, product3), customer3);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        //Media totale degli ordini

//        OptionalDouble mediaCostoDegliOrdini = orders.stream().
//                mapToDouble(order -> order.getProducts().stream().
//                        mapToDouble(Product::getPrice).sum()).average();
//
//        if (mediaCostoDegliOrdini.isPresent()) {
//            System.out.println("La media degli ordini si aggira a: € " + mediaCostoDegliOrdini.getAsDouble());
//        } else {
//            System.out.println("Non sono ordini inl ista");
//        }


        // Media per ogni ordine

        orders.forEach(order -> {
            OptionalDouble mediaCostoDeiProdotti = order.getProducts().stream().mapToDouble(Product::getPrice).average();
            if (mediaCostoDeiProdotti.isPresent()) {
                System.out.println("Numero ordine: " + order.getId() +
                        ", Prezzo medio prodotto: € " + mediaCostoDeiProdotti.getAsDouble());
            } else {
                System.out.println("Non sono ordini inl ista");
            }

        });
    }
}
