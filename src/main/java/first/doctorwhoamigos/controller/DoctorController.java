package first.doctorwhoamigos.controller;

import first.doctorwhoamigos.model.Doctor;
import first.doctorwhoamigos.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/doctor")
@RestController
class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Doctor addDoctor(@Validated @RequestBody @NonNull Doctor doctor) {
        doctorService.addDoctor(doctor);
        return doctor;
    }
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
    @GetMapping(path = "{id}")
    public Optional<Doctor> getDoctorById(@Validated @PathVariable("id") UUID id){
        return Optional.ofNullable(doctorService.getDoctorById(id).orElse(null));
    }

    @PutMapping(path = "{id}")
    public Doctor updateDoctor(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Doctor doctorToUpdate){
        doctorService.updateDoctor(id, doctorToUpdate);
        return doctorToUpdate;
    }

    @DeleteMapping(path = "{id}")
    public Optional<Doctor> deleteDoctorById(@Validated @PathVariable("id") UUID id){
        Optional<Doctor> doctorToDelete = doctorService.getDoctorById(id);
        doctorService.deleteDoctor(id);
        return doctorToDelete;
    }
}
