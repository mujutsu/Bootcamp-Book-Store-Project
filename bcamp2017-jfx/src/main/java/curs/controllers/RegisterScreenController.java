package curs.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import curs.exceptions.ValidationException;
import curs.model.User;
import curs.nav.ScreenNames;
import curs.services.RestClient;
import curs.services.UserServiceInterface;
import curs.utils.ValidationUtils;
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
	void onRegister(ActionEvent event) {

		UserServiceInterface us = RestClient.instance().getUserServiceInterface();
		User user = new User();
		user.setLoginName(tLogin.getText());
		user.setPasswd(tPassword.getText());

		if (user.getLoginName() == null || user.getLoginName().trim().isEmpty() || user.getPasswd() == null
				|| user.getPasswd().trim().isEmpty() || tRole.getSelectionModel().getSelectedItem() == null) {
			Alert dlg = new Alert(AlertType.WARNING);
			dlg.setTitle("Error!");
			dlg.setContentText("Please fill in user name, password and select a role");
			dlg.showAndWait();
			return;
		}

		if (!tPassword.getText().equals(tPasswordConfirm.getText())) {

			Alert dlg = new Alert(AlertType.WARNING);
			dlg.setTitle("Error!");
			dlg.setContentText("Passwords don't match!");
			dlg.showAndWait();
			return;
		}

		try {
			ValidationUtils.validatePassword(user.getPasswd());
		} catch (ValidationException ex) {
			ex.printStackTrace();
			Alert dlg = new Alert(AlertType.WARNING);
			dlg.setTitle("Error!");
			dlg.setContentText(ex.getMessage());
			dlg.showAndWait();
			return;
		}

		String role = tRole.getSelectionModel().getSelectedItem().toString();

		try {
			if (us.register(user).execute().body()) {
				Alert dlg = new Alert(AlertType.INFORMATION);
				dlg.setTitle("Hello:" + user.getLoginName());
				dlg.setContentText("Successful registration");
				dlg.showAndWait();
				navigateToScreen(ScreenNames.loginScreen);
			} else {
				Alert dlg = new Alert(AlertType.WARNING);
				dlg.setTitle("Error!");
				dlg.setContentText("Unsuccessful registration");
				dlg.showAndWait();

			}
		} catch (IOException e) {
			Alert dlg = new Alert(AlertType.ERROR);
			dlg.setTitle("Error!");
			dlg.setContentText("Err message:" + e.getMessage());
			dlg.showAndWait();
		}
	}

	@FXML
	void initialize() {
		assert tLogin != null : "fx:id=\"tLogin\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert tPassword != null : "fx:id=\"tPassword\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert tPasswordConfirm != null : "fx:id=\"tPasswordConfirm\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert bRegister != null : "fx:id=\"bRegister\" was not injected: check your FXML file 'register_screen.fxml'.";
		assert tRole != null : "fx:id=\"tRole\" was not injected: check your FXML file 'register_screen.fxml'.";

		tRole.getItems().addAll("User", "Admin");
	}
}
