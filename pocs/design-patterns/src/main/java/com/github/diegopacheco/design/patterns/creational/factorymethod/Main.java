package com.github.diegopacheco.design.patterns.creational.factorymethod;

public class Main {
    public static void main(String[] args) {
        S3 s3 = new S3();
        EC2 ec2 = new EC2();
        System.out.println(s3.calculateBill(100));
        System.out.println(ec2.calculateBill(100));
    }
}
