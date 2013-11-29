/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author ChrisvanderHeijden
 */
public class Medewerker {
    private String name;
    private String username;
    private boolean appManager;
    private String password;
    private String userLang;
    public Medewerker() {
    }

    public Medewerker(String name, String username, char[] password, boolean appManager) {
        this.name = name;
        this.username = username;
        this.appManager = appManager;
        this.password =  DigestUtils.sha256Hex(String.valueOf(password));
        this.userLang = "EN";
    }

    public Medewerker(String name, String username, char[] password) {
        this.name = name;
        this.username = username;
        this.password = DigestUtils.sha256Hex(String.valueOf(password));
        this.userLang = "EN";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAppManager() {
        return appManager;
    }

    public void setAppManager(boolean appManager) {
        this.appManager = appManager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }


    @Override
    public String toString() {
        return "Medewerker{" + "name=" + name + ", username=" + username + ", appManager=" + appManager + ", password=" + password +  '}';
    }
    
    
    
    
}
