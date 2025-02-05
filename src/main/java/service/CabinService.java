package service;

import model.Cabin;
import repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinService {
    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAllCabins() {
        return cabinRepository.findAll();
    }
}
