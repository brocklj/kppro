package cz.uhk.kppro.repository;

import cz.uhk.kppro.model.Building;
import cz.uhk.kppro.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
