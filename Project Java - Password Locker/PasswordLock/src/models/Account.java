
package models;

public class Account {
    private String username;
    private String password;
    private String question1;
    private String quesiotn2;
    private String question3;
    
    public Account(){
        
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, String question1, String quesiotn2, String question3) {
        this.username = username;
        this.password = password;
        this.question1 = question1;
        this.quesiotn2 = quesiotn2;
        this.question3 = question3;
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

    public String getQuesiotn2() {
        return quesiotn2;
    }

    public void setQuesiotn2(String quesiotn2) {
        this.quesiotn2 = quesiotn2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", question1=" + question1 + ", quesiotn2=" + quesiotn2 + ", question3=" + question3 + '}';
    }
    
    
}
