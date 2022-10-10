package com.example.medistore.service.impl;


import com.example.medistore.dao.MedicineRepository;
import com.example.medistore.model.Medicine;
import com.example.medistore.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    MedicineRepository medicineRepository;

    ////////////////////////////////// save medicine ///////////////////////////////
    //Save one medicine
    public Medicine addMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }

    //save many medicines
    public List<Medicine> addMedicines(List<Medicine> medicines){
        return (List<Medicine>) medicineRepository.saveAll(medicines);
    }

    ////////////////////////////////// get Medicine ///////////////////////////////
    //Get Medicines
    public List<Medicine> getMedicines(){
        return (List<Medicine>) medicineRepository.findAll();
    }

    // get Medicine by id
    public Medicine getMedicineById(long id){
        return medicineRepository.findById(id).orElse(null);
    }
    

    ////////////////////////////////// delete Medicine ///////////////////////////////
    // delete Medicine by id
    public String deleteMedicine(long id){
        medicineRepository.deleteById(id);
        return "Medicine has been deleted";
    }


    ////////////////////////////////// update Medicine ///////////////////////////////
    public Medicine updateMedicine(Medicine Medicine){
        Medicine existingMedicine= medicineRepository.findById(Medicine.getId()).orElse(null);

        existingMedicine.setId(Medicine.getId());
        existingMedicine.setPrice(Medicine.getPrice());
        existingMedicine.setCategory(Medicine.getCategory());
        existingMedicine.setDescription(Medicine.getDescription());

        return medicineRepository.save(existingMedicine);
    }




}
