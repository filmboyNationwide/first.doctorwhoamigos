package first.doctorwhoamigos.dao;

import first.doctorwhoamigos.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class DoctorDataAccessService implements DoctorDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DoctorDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Add in array posting functionality?
    @Override
    public int insertDoctor(UUID id, Doctor doctor) {
        String sql = "INSERT INTO doctor (id, number, actor, startYear, endYear) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, id, doctor.getNumber(), doctor.getActor(), doctor.getStartYear(), doctor.getEndYear());
        return 1;
    }

    @Override
    public List<Doctor> selectAllDoctors() {
        String sql = "SELECT id, number, actor, startYear, endYear FROM doctor";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String number = resultSet.getString("number");
            String actor = resultSet.getString("actor");
            int startYear = resultSet.getInt("startYear");
            int endYear = resultSet.getInt("endYear");
            return new Doctor(id, number, actor, startYear, endYear);
        });
    }

    @SuppressWarnings("deprecation")
    @Override
    public Optional<Doctor> selectDoctorById(UUID id) {
        String sql = "SELECT id, number, actor, startYear, endYear FROM doctor WHERE id = ?";
        Doctor doctor = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID doctorId = UUID.fromString(resultSet.getString("id"));
            String number = resultSet.getString("number");
            String actor = resultSet.getString("actor");
            int startYear = resultSet.getInt("startYear");
            int endYear = resultSet.getInt("endYear");
            return new Doctor(doctorId, number, actor, startYear, endYear);
        });
        return Optional.ofNullable(doctor);
    }

    @Override
    public Optional<Doctor> selectDoctorByActor(String actor) {
        String sql = "SELECT id, number, actor, startYear, endYear FROM doctor WHERE actor = ?";
        Doctor doctor = jdbcTemplate.queryForObject(sql, new Object[]{actor}, (resultSet, i) -> {
            UUID doctorId = UUID.fromString(resultSet.getString("id"));
            String number = resultSet.getString("number");
            String doctorActor = resultSet.getString("actor");
            int startYear = resultSet.getInt("startYear");
            int endYear = resultSet.getInt("endYear");
            return new Doctor(doctorId, number, doctorActor, startYear, endYear);
        });
        return Optional.ofNullable(doctor);
    }

    @Override
    public int updateDoctorById(UUID id, Doctor doctor) {
        String sql = "UPDATE doctor SET number = ?,actor = ?, startYear = ?, endYear = ? WHERE id = ?";
        jdbcTemplate.update(sql, doctor.getNumber(), doctor.getActor(), doctor.getStartYear(), doctor.getEndYear(), id);
        return 1;
    }

    @Override
    public int updateDoctorByActor(String actor, Doctor doctor) {
        String sql = "UPDATE doctor SET number = ?,actor = ?, startYear = ?, endYear = ? WHERE actor = ?";
        jdbcTemplate.update(sql, doctor.getNumber(), doctor.getActor(), doctor.getStartYear(), doctor.getEndYear(), actor);
        return 1;
    }

    @Override
    public int deleteDoctorById(UUID id) {
        String sql = "DELETE FROM doctor WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return 1;
    }

    @Override
    public int deleteDoctorByActor(String actor) {
        String sql = "DELETE FROM doctor WHERE actor = ?";
        jdbcTemplate.update(sql, actor);
        return 1;
    }


}
