import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFxUI extends Application {
    private TextField display;
    private CalculatorService calculator;
    private String operator;
    private double firstNumber;
    private boolean isNewNumber;

    @Override
    public void start(Stage primaryStage) {
        calculator = new CalculatorService();
        operator = "";
        firstNumber = 0;
        isNewNumber = true;

        display = new TextField("0");
        display.setEditable(false);
        display.setPrefHeight(50);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);

        grid.add(display, 0, 0, 4, 1);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        int row = 1;
        int col = 0;
        for (String text : buttons) {
            Button button = new Button(text);
            button.setPrefSize(50, 50);
            button.setOnAction(e -> handleButtonClick(text));
            grid.add(button, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        Scene scene = new Scene(grid, 220, 280);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String text) {
        if (text.matches("\\d")) {
            if (isNewNumber) {
                display.setText(text);
                isNewNumber = false;
            } else {
                display.setText(display.getText() + text);
            }
        } else if (text.equals("C")) {
            display.setText("0");
            operator = "";
            firstNumber = 0;
            isNewNumber = true;
        } else if (text.equals("=")) {
            if (!operator.isEmpty()) {
                double secondNumber = Double.parseDouble(display.getText());
                double result = calculator.calculate(firstNumber, secondNumber, operator);
                display.setText(String.valueOf(result));
                operator = "";
                isNewNumber = true;
            }
        } else {
            if (!operator.isEmpty()) {
                double secondNumber = Double.parseDouble(display.getText());
                double result = calculator.calculate(firstNumber, secondNumber, operator);
                display.setText(String.valueOf(result));
                firstNumber = result;
            } else {
                firstNumber = Double.parseDouble(display.getText());
            }
            operator = text;
            isNewNumber = true;
        }
    }
}