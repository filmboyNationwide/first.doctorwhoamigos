package first.doctorwhoamigos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Doctor {


    private final UUID id;
    private final String number;
    private final String actor;
    private final int startYear;
    private final int endYear;

    public Doctor(@JsonProperty("id") UUID id, @JsonProperty("number") String number, @JsonProperty("actor")String actor, @JsonProperty("startYear")int startYear, @JsonProperty("endYear")int endYear) {
        this.id = id;
        this.number = number;
        this.actor = actor;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public UUID getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getActor() {
        return actor;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public final String toString() {
        return "Doctor{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", actor='" + actor + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }

}
