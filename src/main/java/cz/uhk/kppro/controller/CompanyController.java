package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Company;
import cz.uhk.kppro.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public String listAllCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "company_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {
        Company company = companyService.getCompanyById(id);
        if(company != null) {
            model.addAttribute("company", company);
            return "company_detail";
        }
        return "redirect:/companies/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        Company company = companyService.getCompanyById(id);
        if(company != null) {
            model.addAttribute("company", company);
            model.addAttribute("edit", true);
            return "company_edit";
        }
        return "redirect:/companies/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("edit", false);
        return "company_edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        companyService.deleteCompanyById(id);
        return "redirect:/companies/";
    }

    @PostMapping("/save")
    public String save(@Valid Company company, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("edit", company.getId() != 0);
            return "company_edit";
        }
        companyService.saveCompany(company);
        return "redirect:/companies/";
    }

}
