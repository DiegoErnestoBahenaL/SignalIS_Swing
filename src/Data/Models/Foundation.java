package Data.Models;

import Data.DataStructures.List;

public class Foundation {
    private long Id;
    private String Name;
    private double Budget;
    private List<String> Affiliates;
    private List<String> Trainings;

    public Foundation(){}

    public Foundation(long id, String name, double budget, List<String> affiliates, List<String> trainings) {
        Id = id;
        Name = name;
        Budget = budget;
        Affiliates = affiliates;
        Trainings = trainings;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getBudget() {
        return Budget;
    }

    public void setBudget(double budget) {
        Budget = budget;
    }

    public List<String> getAffiliates() {
        return Affiliates;
    }

    public void setAffiliates(List<String> affiliates) {
        Affiliates = affiliates;
    }

    public List<String> getTrainings() {
        return Trainings;
    }

    public void setTrainings(List<String> trainings) {
        Trainings = trainings;
    }
}
