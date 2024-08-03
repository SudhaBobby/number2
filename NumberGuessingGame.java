import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame extends JFrame implements ActionListener {

    private int numberToGuess;
    private int numberOfTries;
    private final int maxAttempts = 3; // Maximum number of allowed attempts
    private JTextField guessInput;
    private JLabel feedbackLabel;
    private JLabel attemptsLabel;
    private JButton submitButton;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Initialize game
        Random random = new Random();
        numberToGuess =34 + 1;
        numberOfTries = 0;

        // Create GUI components
        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        guessInput = new JTextField();
        submitButton = new JButton("Submit Guess");
        feedbackLabel = new JLabel("");
        attemptsLabel = new JLabel("Number of attempts: 0");

        // Add action listener to the button
        submitButton.addActionListener(this);

        // Add components to the frame
        add(instructionLabel);
        add(guessInput);
        add(submitButton);
        add(feedbackLabel);
        add(attemptsLabel);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = guessInput.getText();
        try {
            int guess = Integer.parseInt(userInput);
            numberOfTries++;

            if (numberOfTries > maxAttempts) {
                feedbackLabel.setText("Game over! The correct number was: " + numberToGuess + ".");
                feedbackLabel.setForeground(Color.RED);
                submitButton.setEnabled(false); // Disable button after exceeding attempts
                return;
            }

            if (guess < 1 || guess > 100) {
                feedbackLabel.setText("Invalid guess. Please enter a number between 1 and 100.");
                feedbackLabel.setForeground(Color.RED);
            } else if (guess < numberToGuess) {
                feedbackLabel.setText("Too low. Try again.");
                feedbackLabel.setForeground(Color.BLUE);
            } else if (guess > numberToGuess) {
                feedbackLabel.setText("Too high. Try again.");
                feedbackLabel.setForeground(Color.BLUE);
            } else {
                feedbackLabel.setText("Congratulations! You've guessed the right number: " + numberToGuess + ".");
                feedbackLabel.setForeground(Color.GREEN);
                submitButton.setEnabled(false); // Disable button after correct guess
            }
            attemptsLabel.setText("Number of attempts: " + numberOfTries);
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Please enter a valid number.");
            feedbackLabel.setForeground(Color.RED);
        }
        guessInput.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberGuessingGame game = new NumberGuessingGame();
            game.setVisible(true);
        });
    }
}
