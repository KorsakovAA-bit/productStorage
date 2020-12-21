package project.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Product implements Comparable{

    private int id;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 3, max = 30, message = "name should be between 4 and 30")
    private String name;

    @Size(min = 4, max = 200, message = "description should be more than 4")
    private String description;

    public Product(){}

    public Product(int id, @NotEmpty(message = "name should not be empty") @Size(min = 3, max = 30, message = "name should be between 4 and 30") String name, @Min(value = 4, message = "phone should be more than 4") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Object o) {
        Product secondProduct = (Product)o;
        this.getName().compareTo(secondProduct.getName());
        return 0;
    }
}
