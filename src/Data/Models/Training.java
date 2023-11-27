package Data.Models;

import Data.DataStructures.List;

public class Training {

    private long Id;
    private String StartDate;
    private String EndDate;
    private String Location;
    private int Capacity;
    private List<Course> Courses;
    private List<Affiliate> Students;

    public Training (){}

    public Training(long id, String startDate, String endDate, String location, int capacity, List<Course> courses, List<Affiliate> students) {
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

    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> courses) {
        Courses = courses;
    }

    public List<Affiliate> getStudents() {
        return Students;
    }

    public void setStudents(List<Affiliate> students) {
        Students = students;
    }
}
