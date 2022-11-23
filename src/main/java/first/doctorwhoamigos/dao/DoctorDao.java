package first.doctorwhoamigos.dao;

import first.doctorwhoamigos.model.Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorDao {

    int insertDoctor(UUID id, Doctor doctor);

    default int insertDoctor(Doctor doctor) {
        UUID id = UUID.randomUUID();
        return insertDoctor(id, doctor);
    }

    List<Doctor> selectAllDoctors();

    Optional<Doctor> selectDoctorById(UUID id);

    int deleteDoctorById(UUID id);

    int updateDoctorById(UUID id, Doctor doctor);
}
