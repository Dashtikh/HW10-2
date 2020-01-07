package com.company;

import javax.security.auth.login.CredentialException;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) {
        loginpage loginpage = new loginpage();

        createfile createfile = new createfile();
        loginpage.run();
        createfile.run();

        // write your code here
    }
}
