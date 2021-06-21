package model;

public class Animal extends  Table {

    @Entity(type = "INTEGER",size = 32,primary = true)
    int id;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Name;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Species;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Breed;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Gender;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Age;


    @ForeignKey(table = "Shelter",attribute = "id")
    @Entity(type = "INTEGER",size = 32)
    int ShelterID_Fk;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public int getShelterID_Fk() {
        return ShelterID_Fk;
    }

    public void setShelterID_Fk(int shelterID_Fk) {
        ShelterID_Fk = shelterID_Fk;
    }
}
