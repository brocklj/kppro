package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Building;
import cz.uhk.kppro.service.BuildingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/buildings")
public class BuildingController {

    private BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("/")
    public String listAllbuildings(Model model) {
        model.addAttribute("buildings", buildingService.getAllbuildings());
        return "building_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {
        Building building = buildingService.getbuildingById(id);
        if(building != null) {
            model.addAttribute("building", building);
            return "building_detail";
        }
        return "redirect:/buildings/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        Building building = buildingService.getbuildingById(id);
        if(building != null) {
            model.addAttribute("building", building);
            model.addAttribute("edit", true);
            return "building_edit";
        }
        return "redirect:/buildings/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("building", new Building());
        model.addAttribute("edit", false);
        return "building_edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        buildingService.deletebuildingById(id);
        return "redirect:/buildings/";
    }

    @PostMapping("/save")
    public String save(@Valid Building building, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("edit", building.getId() != 0);
            return "building_edit";
        }
        buildingService.savebuilding(building);
        return "redirect:/buildings/";
    }

}
