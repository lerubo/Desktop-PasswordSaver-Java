
package models;


public class Password {
    private int pid;
    private int aid;
    private String passName;
    private byte[] pass;
    private byte[] secretkey;
    private String passDescription;

    public Password() {
    }

    public Password(String passName, byte[] passKey,byte[] key, String passDescription) {
        this.passName = passName;
        this.pass = passKey;
        this.secretkey = key;
        this.passDescription = passDescription;
    }

    public Password( String passName, byte[] passKey, String passDescription) { 
        this.passName = passName;
        this.pass = passKey;
        this.passDescription = passDescription;
    }

    public Password(int pid, int aid, String passName, byte[] pass, byte[] secretkey, String passDescription) {
        this.pid = pid;
        this.aid = aid;
        this.passName = passName;
        this.pass = pass;
        this.secretkey = secretkey;
        this.passDescription = passDescription;
    }
    
    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public byte[] getPass() {
        return pass;
    }

    public void setPass(byte[] pass) {
        this.pass = pass;
    }

    public byte[] getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(byte[] secretkey) {
        this.secretkey = secretkey;
    }

   

    public String getPassDescription() {
        return passDescription;
    }

    public void setPassDescription(String passDescription) {
        this.passDescription = passDescription;
    }

    @Override
    public String toString() {
        return "Password{" + "pid=" + pid + ", aid=" + aid + ", passName=" + passName + ", pass=" + pass + ", secretkey=" + secretkey + ", passDescription=" + passDescription + '}';
    }
}
