package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Building;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuildingService {
    List<Building> getAllbuildings();
    Building getbuildingById(long id);
    void deletebuildingById(long id);
    void savebuilding(Building building);
}
