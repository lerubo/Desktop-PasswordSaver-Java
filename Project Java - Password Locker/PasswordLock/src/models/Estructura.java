/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


public class Estructura {
    private byte[] pass;
    private byte[] secret;

    public Estructura(byte[] word, byte[] secret) {
        this.pass = word;
        this.secret = secret;
    }

    public byte[] getPass() {
        return pass;
    }

    public void setPass(byte[] word) {
        this.pass = word;
    }

    public byte[] getSecret() {
        return secret;
    }

    public void setSecret(byte[] secret) {
        this.secret = secret;
    }
    
    
}
