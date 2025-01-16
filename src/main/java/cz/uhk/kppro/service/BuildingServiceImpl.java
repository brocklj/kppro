package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Building;
import cz.uhk.kppro.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements BuildingService {

    private BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public List<Building> getAllbuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public Building getbuildingById(long id) {
        return buildingRepository.findById(id).orElse(null);
    }

    @Override
    public void deletebuildingById(long id) {
        Optional<Building> building = buildingRepository.findById(id);
        if (building.isPresent()) {
            buildingRepository.delete(building.get());
        }
    }

    @Override
    public void savebuilding(Building building) {
        buildingRepository.save(building);
    }
}
