package Data.Models;

import Data.DataStructures.List;

public class Foundation {
    private long Id;
    private String Name;
    private double Budget;
    private List<Affiliate> Affiliates;
    private List<Training> Trainings;

    public Foundation(){}

    public Foundation(long id, String name, double budget, List<Affiliate> affiliates, List<Training> trainings) {
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

    public List<Affiliate> getAffiliates() {
        return Affiliates;
    }

    public void setAffiliates(List<Affiliate> affiliates) {
        Affiliates = affiliates;
    }

    public List<Training> getTrainings() {
        return Trainings;
    }

    public void setTrainings(List<Training> trainings) {
        Trainings = trainings;
    }
}
