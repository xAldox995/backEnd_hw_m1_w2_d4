package aldovalzani.esercizi;

import aldovalzani.e_commerceClasses.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Esercizio5 {
    public static void main(String[] args) {
        Product product1 = new Product("Electronics", "Laptop", 999.99);
        Product product2 = new Product("Books", "Java Programming", 49.99);
        Product product3 = new Product("Home Appliances", "Vacuum Cleaner", 149.99);
        Product product4 = new Product("Electronics", "Smartphone", 499.99);
        Product product5 = new Product("Books", "Cookbook", 29.99);

        List<Product> products = Arrays.asList(product1, product2, product3, product4, product5);

        Map<String, Double> totalePerCategoria = products.stream().
                collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));

        totalePerCategoria.forEach((categoria, tot) ->
                System.out.println("Categoria: " + categoria + ", Totale: € " + tot)
        );
    }
}
