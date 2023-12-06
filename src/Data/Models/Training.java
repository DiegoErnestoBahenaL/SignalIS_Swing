package Data.Models;

import Data.DataStructures.List;

public class Training {

    private long Id;
    private String StartDate;
    private String EndDate;
    private String Location;
    private int Capacity;
    private List<Long> Courses;
    private List<String> Students;

    public Training (){}

    public Training(long id, String startDate, String endDate, String location, int capacity, List<Long> courses, List<String> students) {
        Id = id;
        StartDate = startDate;
        EndDate = endDate;
        Location = location;
        Capacity = capacity;
        Courses = courses;
        Students = students;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public List<Long> getCourses() {
        return Courses;
    }

    public void setCourses(List<Long> courses) {
        Courses = courses;
    }

    public List<String> getStudents() {
        return Students;
    }

    public void setStudents(List<String> students) {
        Students = students;
    }
}
