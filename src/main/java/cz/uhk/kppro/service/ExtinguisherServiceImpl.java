package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Extinguisher;
import cz.uhk.kppro.repository.ExtinguisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExtinguisherServiceImpl implements ExtinguisherService {

    private ExtinguisherRepository extinguisherRepository;

    @Autowired
    public ExtinguisherServiceImpl(ExtinguisherRepository extinguisherRepository) {
        this.extinguisherRepository = extinguisherRepository;
    }

    @Override
    public List<Extinguisher> getAllExtinguishers() {
        return extinguisherRepository.findAll();
    }

    @Override
    public Extinguisher getExtinguisherById(long id) {
        return extinguisherRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteExtinguisherById(long id) {
        Optional<Extinguisher> extinguisher = extinguisherRepository.findById(id);
        if (extinguisher.isPresent()) {
            extinguisherRepository.delete(extinguisher.get());
        }
    }

    @Override
    public void saveExtinguisher(Extinguisher extinguisher) {
        extinguisherRepository.save(extinguisher);
    }
}
