package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(long id);
    void deleteCompanyById(long id);
    void saveCompany(Company company);
}
