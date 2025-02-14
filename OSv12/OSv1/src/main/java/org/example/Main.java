package org.example;

import static org.example.MasterCore.*;

public class Main {
    public static void main(String[] args) {

        Process p = new Process//the path of the file
                ("C:\\Users\\youse\\Desktop\\OSv12\\OSv12\\OSv1\\src\\main\\java\\org\\example\\file1.txt");
        Process p1 = new Process("C:\\Users\\youse\\Desktop\\OSv12\\OSv12\\OSv1\\src\\main\\java\\org\\example\\Program_2.txt");
        Process p2 = new Process("C:\\Users\\youse\\Desktop\\OSv12\\OSv12\\OSv1\\src\\main\\java\\org\\example\\Program_3.txt");

        ShortestJobFirst();
        Process p3 = new Process("C:\\Users\\youse\\Desktop\\OSv12\\OSv12\\OSv1\\src\\main\\java\\org\\example\\file1.txt");
        Process p4 = new Process("C:\\Users\\youse\\Desktop\\OSv12\\OSv12\\OSv1\\src\\main\\java\\org\\example\\Program_2.txt");
        Process p5 = new Process("C:\\Users\\youse\\Desktop\\OSv12\\OSv12\\OSv1\\src\\main\\java\\org\\example\\Program_3.txt");

        roundRobin(2);
        Process p6 = new Process("C:\\Users\\youse\\Desktop\\OSv12\\OSv12\\OSv1\\src\\main\\java\\org\\example\\file1.txt");
        Process p7 = new Process("C:\\Users\\youse\\Desktop\\OSv12\\OSv12\\OSv1\\src\\main\\java\\org\\example\\Program_2.txt");
        Process p8 = new Process("C:\\Users\\youse\\Desktop\\OSv12\\OSv12\\OSv1\\src\\main\\java\\org\\example\\Program_3.txt");

        roundRobinSRT(2);
    }
}