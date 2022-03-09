package web.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Car {
    private int id;
    @Size(min =2, message = "Минимум 2 символа")
    @NotBlank(message = "Поле не должно быть пустым")
    private String model;
    @Size(min =2, message = "Минимум 2 символа")
    @NotBlank(message = "Поле не должно быть пустым")
    private String color;

    public Car() {
    }

    public Car(int id, String model, String color) {
        this.id = id;
        this.model = model;
        this.color = color;
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
}
