package com.example.medistore.controller;

import com.example.medistore.model.Medicine;
import com.example.medistore.service.MedicineService;
import com.example.medistore.service.impl.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("medicines")
public class MedicineController {


    MedicineService medicineService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }


    ////////////////////////////////// Add Medicines ///////////////////////////
    @PostMapping("/")
    public Medicine addMedicine(@RequestBody Medicine medicine){
        return medicineService.addMedicine(medicine);
    }


    @PostMapping("/all")
    public List<Medicine> addMedicines(@RequestBody List<Medicine> medicines){
        return medicineService.addMedicines(medicines);
    }



    ////////////////////////////////// Get Medicines ///////////////////////////
    @GetMapping("/")
    public List<Medicine> getMedicines(){
        return medicineService.getMedicines();
    }

    @GetMapping("/id-{id}")
    public Medicine getMedicineById(@PathVariable long id){
        return medicineService.getMedicineById(id);
    }

    /*
    String urii="http://localhost:8080/medicines/id-{id}";
    @GetMapping("/id-{id}")
    public Medicine getMedicineById(@PathVariable long id){

        return webClientBuilder.build()
                .get()
                .uri(urii, id)
                .retrieve()
                .bodyToMono(Medicine.class)
                .block();
    }*/




    ////////////////////////////// update Medicine ///////////////////////////
    @PutMapping("/")
    public Medicine updateMedicine(@RequestBody Medicine medicine){
        return medicineService.updateMedicine(medicine);
    }


    ////////////////////////////// delete Medicine ///////////////////////////
    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable long id){
        return medicineService.deleteMedicine(id);
    }




}
