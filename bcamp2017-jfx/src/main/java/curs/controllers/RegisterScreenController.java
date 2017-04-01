package curs.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import curs.model.User;
import curs.nav.ScreenNames;
import curs.services.RestClient;
import curs.services.UserServiceInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterScreenController extends BaseController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tLogin;

	@FXML
	private PasswordField tPassword;

	@FXML
	private PasswordField tPasswordConfirm;

	@FXML
	private Button bRegister;

	@FXML
	private ComboBox<String> tRole;

	@FXML
	void onRegister(ActionEvent event) {if (!tPassword.getText().equals(tPasswordConfirm.getText())) {

		Alert dlg = new Alert(AlertType.WARNING);
		dlg.setTitle("Error");
		dlg.setContentText("PASSWORDS DON'T MATCH!");
		dlg.showAndWait();
	} else {
		UserServiceInterface us = RestClient.instance().getUserServiceInterface();
		User user = new User();
		user.setLoginName(tLogin.getText());
		user.setPasswd(tPassword.getText());
		
		if(tRole.getSelectionModel().getSelectedItem()!=null){
			String role = tRole.getSelectionModel().getSelectedItem().toString();

			System.out.println("Will try to register "+role );
			try {
				if (us.register(user).execute().body()) {
					Alert dlg = new Alert(AlertType.INFORMATION);
					dlg.setTitle("Hello:" + user.getLoginName());
					dlg.setContentText("Successful registration");
					dlg.showAndWait();
					navigateToScreen(ScreenNames.loginScreen);
				} else {
					Alert dlg = new Alert(AlertType.WARNING);
					dlg.setTitle("FAIL");
					dlg.setContentText("Unsuccessful registration");
					dlg.showAndWait();
					
				}
			} catch (IOException e) {
				Alert dlg = new Alert(AlertType.ERROR);
				dlg.setTitle("Error");
				dlg.setContentText("Err message:" + e.getMessage());
				dlg.showAndWait();
			}
		}
		else {
			Alert dlg = new Alert(AlertType.WARNING);
			dlg.setTitle("FAIL");
			dlg.setContentText("PLEASE SELECT A DAMN ROLE");
			dlg.showAndWait();
			
		}
		

	}

}



	@FXML
	void initialize() {
		assert tLogin != null : "fx:id=\"tLogin\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert tPassword != null : "fx:id=\"tPassword\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert tPasswordConfirm != null : "fx:id=\"tPasswordConfirm\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert bRegister != null : "fx:id=\"bRegister\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert tRole != null : "fx:id=\"tRole\" was not injected: check your FXML file 'register_screen.fxml'.";
	
		tRole.getItems().addAll("User","Admin");
	}
}
