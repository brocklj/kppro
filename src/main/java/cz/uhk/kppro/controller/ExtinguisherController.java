package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Extinguisher;
import cz.uhk.kppro.service.BuildingService;
import cz.uhk.kppro.service.CompanyService;
import cz.uhk.kppro.service.ExtinguisherService;
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
@RequestMapping("/extinguishers")
public class ExtinguisherController {

    private ExtinguisherService extinguisherService;
    private BuildingService buildingService;
    private CompanyService companyService;

    @Autowired
    public ExtinguisherController(ExtinguisherService extinguisherService, BuildingService buildingService, CompanyService companyService) {
        this.extinguisherService = extinguisherService;
        this.buildingService = buildingService;
        this.companyService = companyService;
    }

    @GetMapping("/")
    public String listAllExtinguishers(Model model) {
        model.addAttribute("extinguishers", extinguisherService.getAllExtinguishers());
        return "extinguisher_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {
        Extinguisher extinguisher = extinguisherService.getExtinguisherById(id);
        if(extinguisher != null) {
            model.addAttribute("extinguisher", extinguisher);
            return "extinguisher_detail";
        }
        return "redirect:/extinguishers/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        Extinguisher extinguisher = extinguisherService.getExtinguisherById(id);
        if(extinguisher != null) {
            model.addAttribute("extinguisher", extinguisher);
            model.addAttribute("buildings", buildingService.getAllbuildings());
            model.addAttribute("producers", companyService.getAllCompanies());
            model.addAttribute("edit", true);
            return "extinguisher_edit";
        }
        return "redirect:/extinguishers/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("extinguisher", new Extinguisher());
        model.addAttribute("buildings", buildingService.getAllbuildings());
        model.addAttribute("producers", companyService.getAllCompanies());
        model.addAttribute("edit", false);
        return "extinguisher_edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        extinguisherService.deleteExtinguisherById(id);
        return "redirect:/extinguishers/";
    }

    @PostMapping("/save")
    public String save(@Valid Extinguisher extinguisher, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("edit", extinguisher.getId() != 0);
            return "extinguisher_edit";
        }
        extinguisherService.saveExtinguisher(extinguisher);
        return "redirect:/extinguishers/";
    }

}
