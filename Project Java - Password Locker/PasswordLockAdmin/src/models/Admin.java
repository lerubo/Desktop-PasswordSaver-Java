
package models;

public class Admin {
    private int id;
    private String userAdmin;
    private String adminPass;

    public Admin() {
    }
    
    public Admin(String userAdmin, String adminPass) {        
        this.userAdmin = userAdmin;
        this.adminPass = adminPass;
    }

    public Admin(int id, String userAdmin, String adminPass) {
        this.id = id;
        this.userAdmin = userAdmin;
        this.adminPass = adminPass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", userAdmin=" + userAdmin + ", adminPass=" + adminPass + '}';
    }
  
}
