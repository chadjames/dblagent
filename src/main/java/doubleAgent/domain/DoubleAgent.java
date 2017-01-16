package doubleAgent.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by chad on 1/13/17.
 */
@Entity
public class DoubleAgent{

    public DoubleAgent(){};

    @Id
    @GeneratedValue
    private int id;

    private double currentLatitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private double currentLongitude;

    private String name;

    private int age;

    private String gender;





    public DoubleAgent(double currentLatitude, double currentLongitude, String name, int age, String gender) {
        this.currentLatitude = currentLatitude;
        this.currentLongitude = currentLongitude;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
