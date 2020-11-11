package com.kalli.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswrodRequest {

    String password;

    public PasswrodRequest(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkLowerCaseUpperCase(){
        String regex = ".*[A-Z].*" + ".*[a-z].*";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(this.password);

        // Print Yes if string
        // matches ReGex
        if (m.matches())
            System.out.println("ACCEPTABLE PASSWORD!");
        else
            System.out.println("UNACCEPTABLE PASSWORD!");
    }

    public void checkLowerUpperDigit(){
        String regex = ".*[A-Z].*" + ".*[a-z].*"+ ".*\\d.*";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(this.password);

        // Print Yes if string
        // matches ReGex
        if (m.matches())
            System.out.println("ACCEPTABLE PASSWORD!");
        else
            System.out.println("UNACCEPTABLE PASSWORD!");
    }

    public void checkEverything(){
        String regex = ".*[A-Z].*" + ".*[a-z].*"+ ".*\\d.*" + ".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*" + "{8,}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(this.password);

        // Print Yes if string
        // matches ReGex
        if (m.matches())
            System.out.println("ACCEPTABLE PASSWORD!");
        else
            System.out.println("UNACCEPTABLE PASSWORD!");

    }
}
