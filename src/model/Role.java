package model;

public class Role extends Table {
    @Entity(type = "INTEGER",size = 32,primary = true)
    int RoleID;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
