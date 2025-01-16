package cz.uhk.kppro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "buildings")
public class  Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Is mandatory!")
    @Size(min = 2, max = 32)
    private String name;
    private String address;

    @Min(value = 1)
    private int numberOfRooms;

    @OneToMany(mappedBy = "building")
    private List<Extinguisher> extinguishers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(@Min(value = 1) int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
