package pl.mmarczewski.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mmarczewski.model.Easement;
import pl.mmarczewski.service.EasementService;

import java.util.List;

@RestController
public class EasementController {

    private final EasementService easementService;

    public EasementController(EasementService easementService) {
        this.easementService = easementService;
    }

    @GetMapping("/easements")
    public List<Easement> findAll(){
       return easementService.findAll();
    }
}
