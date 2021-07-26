package com.github.diegopacheco.design.patterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        DataSourceDecorator encoded =
                new CompressionDecorator(
                    new Base64Decorator(
                        new FileDataSource("/tmp/OutputDemo.txt")));

        encoded.write(salaryRecords);
        DataSource plain = new FileDataSource("/tmp/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.read());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.read());
    }
}
