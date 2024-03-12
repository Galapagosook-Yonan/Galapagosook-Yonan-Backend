package GalapagosookYonan.GalapagosookYonan.controller;

import GalapagosookYonan.GalapagosookYonan.entity.farmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import GalapagosookYonan.GalapagosookYonan.repository.farmRepository; // Ensure correct import

@RestController
@RequestMapping("/")
public class farmController {

    @Autowired
    private final farmRepository farmRepository;

    public farmController(GalapagosookYonan.GalapagosookYonan.repository.farmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    // Get all farms
    @GetMapping("/farm") // Ensure your mapping is correct
    public List<farmEntity> getAllFarms() {
        return farmRepository.findAll();
    }

    // Get a single farm by ID
    @GetMapping("/farm/{id}")
    public farmEntity getFarmById(@PathVariable("id") Integer id) {
        Optional<farmEntity> farm = farmRepository.findById(id);
        if (farm.isEmpty()) {
            throw new ResourceNotFoundException("Farm not found with id: " + id); // Ensure you have defined this exception
        }
        return farm.get();
    }

}