package application;

import java.sql.SQLException;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login {
	
	 public static final Logger LOGGER = Logger.getLogger(Login.class.getName());
	
	 	private static final String VALID_USERNAME = "admin";
	    private static final String VALID_PASSWORD = "password";
	    
	    public void loginScreen(Stage primaryStage) {
	    primaryStage.setTitle("Login");

        // UI-Elemente erstellen
        Label labelUsername = new Label("Benutzername:");
        TextField textFieldUsername = new TextField();

        Label labelPassword = new Label("Passwort:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Anmelden");
        loginButton.setOnAction(e -> handleLogin(textFieldUsername.getText(), passwordField.getText()));
        
        Button registerButton = new Button("Registrieren");
        registerButton.setOnAction(e -> {
			try {
				handleRegister(textFieldUsername.getText(), passwordField.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} );
        

        // Layout erstellen
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(labelUsername, textFieldUsername, labelPassword, passwordField, loginButton, registerButton);

        // Szene erstellen und der Bühne hinzufügen
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);

        // Bühne anzeigen
        primaryStage.show();
    }
	    
	    public void showRegisterForm() {
	    VBox layout = new VBox(10);
	    layout.setPadding(new Insets(10));
	    }
	    
	    private void handleRegister(String username, String password) throws SQLException {
	    	   if (!DbConnection.isUsernameTaken(username)) {
			  
			       DbConnection.registerUser(username, password);
			       LOGGER.info("Registration successful");
			   } else {
			       LOGGER.warning("Username is already taken. Please choose another one.");
			   }
	    }
	
	    public boolean handleLogin(String username, String password) {
	    	
	        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
	        	LOGGER.info("Login successful");
	        	return true;
	        } else {
	            LOGGER.warning("Worng password oder username - check them and try again");
	        }
			return false;
	    }
	
}
