package com.example.medistore.controller;

import com.example.medistore.model.Medicine;
import com.example.medistore.service.MedicineService;
import com.example.medistore.service.impl.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicine")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    ////////////////////////////////// Add Medicines ///////////////////////////
    @PostMapping("/addMedicine")
    public Medicine addMedicine(@RequestBody Medicine medicine){
        return medicineService.addMedicine(medicine);
    }


    @PostMapping("/addMedicines")
    public List<Medicine> addMedicines(@RequestBody List<Medicine> medicines){
        return medicineService.addMedicines(medicines);
    }

    ////////////////////////////////// Get Medicines ///////////////////////////
    @GetMapping("/get")
    public List<Medicine> getMedicines(){
        return medicineService.getMedicines();
    }

    @GetMapping("/get/{id}")
    public Medicine getMedicineById(@PathVariable long id){
        return medicineService.getMedicineById(id);
    }




    ////////////////////////////// update Medicine ///////////////////////////
    @PutMapping("/update")
    public Medicine updateMedicine(@RequestBody Medicine medicine){
        return medicineService.updateMedicine(medicine);
    }


    ////////////////////////////// delete Medicine ///////////////////////////
    @DeleteMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable long id){
        return medicineService.deleteMedicine(id);
    }




}
