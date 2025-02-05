package controller;

import model.Cabin;
import service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cabins")
public class CabinController {

    @Autowired
    private CabinService cabinService;

    @GetMapping
    public List<Cabin> getAllCabins() {
        return cabinService.getAllCabins();
    }
}
