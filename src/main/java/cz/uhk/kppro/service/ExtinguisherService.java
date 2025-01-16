package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Extinguisher;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ExtinguisherService {
    List<Extinguisher> getAllExtinguishers();
    Extinguisher getExtinguisherById(long id);
    void deleteExtinguisherById(long id);
    void saveExtinguisher(Extinguisher extinguisher);
}
