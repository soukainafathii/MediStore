package com.example.medistore.service;

import com.example.medistore.model.Medicine;

import java.util.List;

public interface MedicineService {

    public Medicine addMedicine(Medicine medicine);
    public List<Medicine> addMedicines(List<Medicine> medicines);
    public List<Medicine> getMedicines();
    public Medicine getMedicineById(long id);
    public String deleteMedicine(long id);
    public Medicine updateMedicine(Medicine Medicine);

}
