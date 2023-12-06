package Data.Models;

public class Certificate {
    private long Id;
    private String StudentName;
    private String TeacherName;
    private long TrainingId;
    private String Date;

    public Certificate(){}

    public Certificate(long id, String studentName, String teacherName, long trainingId, String date) {
        Id = id;
        StudentName = studentName;
        TeacherName = teacherName;
        TrainingId = trainingId;
        Date = date;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public long getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(long trainingId) {
        TrainingId = trainingId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString (){
        return "Id: " + Id + "\n" +
                "Nombre del Estudiante: " + StudentName + "\n" +
                "Nombre del Profesor: " + TeacherName + "\n" +
                "Id del curso: "  + TrainingId + "\n"  +
                "Fecha: " + Date;
    }
}
