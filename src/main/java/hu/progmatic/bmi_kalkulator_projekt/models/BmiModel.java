package hu.progmatic.bmi_kalkulator_projekt.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class BmiModel {

    @Id
    @GeneratedValue
    private long ID;

    private String name;
    private double height;

    private double kgs;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate BmiDate;
    private double BMI = (getKgs()/(getHeight()*getHeight()));

    public BmiModel() {

    }

    public BmiModel(double BMI) {
        this.BMI = BMI;
    }

    public BmiModel(long ID, String name, double height, double kgs, LocalDate bmiDate, double BMI) {
        this.ID = ID;
        this.name = name;
        this.height = height;
        this.kgs = kgs;
        BmiDate = bmiDate;
        this.BMI = BMI;
    }

    public BmiModel(String name, double height, double kgs, LocalDate bmiDate, double BMI) {
        this.name = name;
        this.height = height;
        this.kgs = kgs;
        BmiDate = bmiDate;
        this.BMI = BMI;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getKgs() {
        return kgs;
    }

    public void setKgs(double kgs) {
        this.kgs = kgs;
    }

    public LocalDate getBmiDate() {
        return BmiDate;
    }

    public void setBmiDate(LocalDate bmiDate) {
        BmiDate = bmiDate;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }
}
