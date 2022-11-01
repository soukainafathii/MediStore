package com.example.medistore.service.impl;

import com.example.medistore.dao.MedicineRepository;
import com.example.medistore.model.Medicine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


class MedicineServiceImplTest {

    @Test
    @Disabled
    void addMedicine() {

        //Given
        MedicineServiceImpl medicineService= new MedicineServiceImpl();

        MedicineRepository medicineRepository= Mockito.mock(MedicineRepository.class);

        medicineService.setMedicineRepository(medicineRepository);

        Medicine medicine= new Medicine();

        Mockito.when(medicineRepository.save(medicine)).thenReturn(medicine);

        //When
        Medicine medicine1= medicineService.addMedicine(medicine);

        //then
        Assertions.assertNotNull(medicine1);
        Assertions.assertEquals(medicine1,medicine);
    }

    /*
    @Test
    @Disabled
    void shouldAddMedicine() {

        //Given
        MedicineServiceImpl medicineService= new MedicineServiceImpl();

        MedicineRepository medicineRepository= Mockito.mock(MedicineRepository.class);

        medicineService.setMedicineRepository(medicineRepository);

        Medicine medicine= new Medicine();

        Mockito.when(medicineRepository.save(medicine)).thenReturn(medicine);

        //When
        Medicine medicine1= medicineService.addMedicine(medicine);

        //then
        Assertions.assertNotNull(medicine1);
        Assertions.assertEquals(medicine1,medicine);
    }
    */

}