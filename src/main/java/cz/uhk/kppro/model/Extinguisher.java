package cz.uhk.kppro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

@Entity
@Table(name="extinguishers")
public class Extinguisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Is mandatory!")
    private String serial;

    @NotNull(message= "Expiration date is mandatory!")
    private Date expirationDate;

    @ManyToOne
    private Building building;

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @ManyToOne
    private Company producer;

    public Company getProducer() {
        return producer;
    }

    public void setProducer(Company building) {
        this.producer = building;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Is mandatory!") String getSerial() {
        return serial;
    }

    public void setSerial(@NotBlank(message = "Is mandatory!") String serial) {
        this.serial = serial;
    }


    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(@NotNull(message= "Expiration date is mandatory!") Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
