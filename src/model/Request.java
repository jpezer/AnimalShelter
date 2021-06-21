package model;

public class Request extends Table {
    @Entity(type = "INTEGER",size = 32,primary = true)
    int id;

    @Entity(type = "VARCHAR",size = 500,isnull = false)
    String Description;

    @ForeignKey(table = "User",attribute = "id")
    @Entity(type = "INTEGER",size = 32)
    int UserID_Fk;

    @ForeignKey(table = "Animal",attribute = "id")
    @Entity(type = "INTEGER",size = 32)
    int AnimalID_Fk;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getUserID_Fk() {
        return UserID_Fk;
    }

    public void setUserID_Fk(int userID_Fk) {
        UserID_Fk = userID_Fk;
    }

    public int getAnimalID_Fk() {
        return AnimalID_Fk;
    }

    public void setAnimalID_Fk(int animalID_Fk) {
        AnimalID_Fk = animalID_Fk;
    }
}
