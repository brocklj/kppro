package cz.uhk.kppro.repository;

import cz.uhk.kppro.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

}
