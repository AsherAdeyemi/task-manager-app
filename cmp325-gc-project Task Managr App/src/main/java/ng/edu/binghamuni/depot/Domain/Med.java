package ng.edu.binghamuni.depot.Domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "inventory")
@Entity(name = "med")
public class Med {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String body;
//    private int price;
//    private String color;

    @CreationTimestamp
    Date created_at;

    @UpdateTimestamp
    Date updated_at;

    public Med() {
    }

//    public List<Ingredient> getIngredients() {
//        return ingredients;
//    }

//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }

//    @OneToMany
//    private List<Ingredient> ingredients;
    public Med(Long id, String name, String body) {
        this.id = id;
        this.name = name;
        this.body = body;
//        this.price = price;
//        this.color = color;
    }

    public static Med get() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public int getPrice() {return price;}
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }

}
