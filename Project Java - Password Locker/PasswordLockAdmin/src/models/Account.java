
package models;

public class Account {
    private int id; 
    private String forename;
    private String surname;
    private String dob;
    private String username;
    private String password;
    private String question1;
    private String question2;
    private String question3;
    private int responsible;
    
    public Account(){
        
    }

    public Account(int id, String forename, String surname, String dob, String username, String password, String question1, String quesiotn2, String question3) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.question1 = question1;
        this.question2 = quesiotn2;
        this.question3 = question3;
    }

    public Account(int id, String forename, String surname, String dob, String username, String password, String question1, String question2, String question3, int responsible) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.responsible = responsible;
    }

    public int getResponsible() {
        return responsible;
    }

    public void setResponsible(int responsible) {
        this.responsible = responsible;
    }
 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuesiotn2(String quesiotn2) {
        this.question2 = quesiotn2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", forename=" + forename + ", surname=" + surname + ", dob=" + dob + ", username=" + username + ", password=" + password + ", question1=" + question1 + ", quesiotn2=" + question2 + ", question3=" + question3 + '}';
    }
}
