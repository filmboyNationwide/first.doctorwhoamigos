package first.doctorwhoamigos.service;

import first.doctorwhoamigos.dao.DoctorDao;
import first.doctorwhoamigos.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorService {

    private final DoctorDao doctorDao;

    @Autowired
    public DoctorService(@Qualifier("postgres") DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public List<Doctor> getAllDoctors() {
        return doctorDao.selectAllDoctors();
    }

    public int addDoctor(Doctor doctor) {
        return doctorDao.insertDoctor(doctor);
    }

    public Optional<Doctor> getDoctorById(UUID id) {
        return doctorDao.selectDoctorById(id);
    }

    public int deleteDoctor(UUID id) {
        return doctorDao.deleteDoctorById(id);
    }

    public int updateDoctor(UUID id, Doctor newDoctor) {
        return doctorDao.updateDoctorById(id, newDoctor);
    }
}
