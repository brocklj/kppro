package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Company;
import cz.uhk.kppro.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCompanyById(long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            companyRepository.delete(company.get());
        }
    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }
}
