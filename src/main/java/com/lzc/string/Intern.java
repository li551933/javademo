package com.lzc.string;

public class Intern {
    public static void main(String args[]) {
        String Str1 = new String("Welcome to Tutorialspoint.com");
        String Str2 = new String("WELCOME TO SUTORIALSPOINT.COM");

        System.out.print("Canonical representation:" );
        System.out.println(Str1.intern());

        System.out.print("Canonical representation:" );
        System.out.println(Str2.intern());
    }
}
