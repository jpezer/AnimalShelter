package model;

public class Shelter extends Table {
    @Entity(type = "INTEGER",size = 32,primary = true)
    int id;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Name;

    @Entity(type = "VARCHAR",size = 32,isnull = false)
    String Location;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
