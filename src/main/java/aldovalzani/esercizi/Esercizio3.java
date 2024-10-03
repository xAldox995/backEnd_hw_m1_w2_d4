package aldovalzani.esercizi;

import aldovalzani.e_commerceClasses.Product;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Esercizio3 {
    public static void main(String[] args) {
        Faker faker = new Faker();

        Product product1 = new Product("Electronics", "Laptop", 999.99);
        Product product2 = new Product("Books", "Java Programming", 49.99);
        Product product3 = new Product("Home Appliances", "Vacuum Cleaner", 149.99);
        Product product4 = new Product("Smartphones", "iPhone", 1199.99);
        Product product5 = new Product("Furniture", "Sofa", 749.99);

        List<Product> products = Arrays.asList(product1, product2, product3, product4, product5);

//        Product mostExpensiveProduct = products.stream().
//                max(Comparator.comparingDouble(Product::getPrice)).get();
//
//        System.out.println("Il prodotto più costoso è: " + mostExpensiveProduct.getName() + " con un prezzo di: € "
//                + mostExpensiveProduct.getPrice());

        Optional<Product> mostExpensiveProduct = products.stream().
                max(Comparator.comparingDouble(Product::getPrice));

        mostExpensiveProduct.ifPresent(product ->
                System.out.println("Il prodotto più costoso è: " + product.getName() +
                        " con un prezzo di: € " + product.getPrice()));
    }
}
