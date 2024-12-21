package cz.uhk.kppro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "seš marnej")
    private String name;

    @Min(value = 18)
    @Max(value = 99)
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "seš marnej") @Size(min = 7, max = 7) String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "seš marnej") @Size(min = 7, max = 7) String name) {
        this.name = name;
    }

    @Min(value = 18)
    @Max(value = 99)
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 18) @Max(value = 99) int age) {
        this.age = age;
    }
}
