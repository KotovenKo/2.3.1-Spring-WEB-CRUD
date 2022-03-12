package web.model;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table (name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column(name = "model")
    @Size(min =2, message = "Минимум 2 символа")
    @NotBlank(message = "Поле не должно быть пустым")
    private String model;

    @Column(name = "color")
    @Size(min =2, message = "Минимум 2 символа")
    @NotBlank(message = "Поле не должно быть пустым")
    private String color;


    @Column(name = "power")
//    @Size(min =2, message = "Минимум 2 символа")
//    @NotBlank(message = "Поле не должно быть пустым")
    private int power;


    public Car() {
    }

    public Car(int id, String model, String color, int power) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.power = power;

    }

    public Car(String model, String color, int power) {
        this.model = model;
        this.color = color;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
