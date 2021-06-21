package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends Table {
    @Entity(type = "INTEGER",size = 32,primary = true)
    int id;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Firstname;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Lastname;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Email;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Password;

    @Entity(type = "VARCHAR",size = 50,isnull = false)
    String Role;


    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public static User login(String email,String password) throws Exception {
        String sql ="SELECT id FROM user WHERE email=? AND password=?";
        PreparedStatement query=Database.CONNECTION.prepareStatement(sql);
        query.setString(1,email);
        query.setString(2,password);

        ResultSet rs=query.executeQuery();
        if (rs.next()){
            return (User) User.get(User.class, rs.getInt(1));
        }else{
            return null;
        }
    }


}
