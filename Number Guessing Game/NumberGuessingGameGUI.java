import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class NumberGuessingGameGUI extends Application {

    private int secretNumber;
    private int attempts;
    private long startTime;
    private Label feedbackLabel;
    private TextField guessInput;
    private Label attemptsLabel;
    private Label timeLabel;
    private Button guessButton;
    private Button playAgainButton;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🎯 Number Guessing Game");

        feedbackLabel = new Label("Guess a number between 1 and 100");
        guessInput = new TextField();
        guessInput.setPromptText("Enter your guess");
        guessButton = new Button("Guess");
        playAgainButton = new Button("Play Again");
        playAgainButton.setDisable(true);

        attemptsLabel = new Label("Attempts: 0");
        timeLabel = new Label("⏱️ Time: 0.0 sec");

        VBox layout = new VBox(15, feedbackLabel, guessInput, guessButton, attemptsLabel, timeLabel, playAgainButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 30; -fx-font-size: 16;");

        guessButton.setOnAction(e -> handleGuess());
        playAgainButton.setOnAction(e -> startGame());

        startGame();

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startGame() {
        Random rand = new Random();
        secretNumber = rand.nextInt(100) + 1;
        attempts = 0;
        startTime = System.currentTimeMillis();

        feedbackLabel.setText("Guess a number between 1 and 100");
        guessInput.clear();
        attemptsLabel.setText("Attempts: 0");
        timeLabel.setText("⏱️ Time: 0.0 sec");
        guessButton.setDisable(false);
        playAgainButton.setDisable(true);
    }

    private void handleGuess() {
        String inputText = guessInput.getText();
        try {
            int guess = Integer.parseInt(inputText);
            attempts++;

            if (guess < secretNumber) {
                feedbackLabel.setText("Too low! 🔽");
            } else if (guess > secretNumber) {
                feedbackLabel.setText("Too high! 🔼");
            } else {
                long endTime = System.currentTimeMillis();
                double timeTaken = (endTime - startTime) / 1000.0;
                feedbackLabel.setText("🎉 Correct! The number was " + secretNumber);
                timeLabel.setText("⏱️ Time: " + timeTaken + " sec");
                guessButton.setDisable(true);
                playAgainButton.setDisable(false);
            }

            attemptsLabel.setText("Attempts: " + attempts);
            guessInput.clear();

        } catch (NumberFormatException e) {
            feedbackLabel.setText("❗ Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
