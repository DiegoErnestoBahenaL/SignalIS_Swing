package Data.Models;

public class Course {
    private long Id;
    private int DurationInHours;
    private String Description;
    private long IdMaestro;
    private String Level;

    public Course (){}

    public Course(long id, int durationInHours, String description, long idMaestro, String level) {
        Id = id;
        DurationInHours = durationInHours;
        Description = description;
        IdMaestro = idMaestro;
        Level = level;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getDurationInHours() {
        return DurationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        DurationInHours = durationInHours;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getIdMaestro() {
        return IdMaestro;
    }

    public void setIdMaestro(long idMaestro) {
        IdMaestro = idMaestro;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }
}
