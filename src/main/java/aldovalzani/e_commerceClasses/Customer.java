package aldovalzani.e_commerceClasses;

public class Customer {
    private static long idCounter = 0;
    private Long id;
    private String name;
    private Integer tier;

    public Customer(String name, Integer tier) {
        this.id = ++idCounter;
        this.name = name;
        this.tier = tier;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
