/**
 * Sample Skeleton for 'bookstore_screen.fxml' Controller Class
 */

package curs.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import curs.interfaces.ShoppingCartInterface;
import curs.interfaces.ShoppingCartItemInterface;
import curs.model.Book;
import curs.model.ShoppingCartItem;
import curs.nav.ScreenNames;
import curs.services.BookServiceInterface;
import curs.services.RestClient;
import curs.services.UserServiceInterface;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class BookstoreScreenController extends BaseController {
	private final ObservableList<Book> mBookCollection = FXCollections.observableArrayList();
	private BookServiceInterface mBSI;
	private UserServiceInterface mUSI;
	private Book mCurrentBook;
	@Inject
	private ShoppingCartInterface mCart;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;
	
	private Collection<ShoppingCartItemInterface> mItems;

	@FXML // fx:id="VBox"
	private VBox VBox; // Value injected by FXMLLoader

	@FXML // fx:id="btnRefresh"
	private Button btnRefresh; // Value injected by FXMLLoader

	@FXML // fx:id="bookTable"
	private TableView<Book> bookTable; // Value injected by FXMLLoader

	@FXML // fx:id="colTitle"
	private TableColumn<Book, String> colTitle; // Value injected by FXMLLoader

	@FXML // fx:id="colAuthor"
	private TableColumn<Book, String> colAuthor; // Value injected by FXMLLoader

	@FXML
	private TableColumn<Book, Integer> colAvail;

	@FXML // fx:id="colBooked"
	private TableColumn<Book, Integer> colBooked; // Value injected by
													// FXMLLoader

	@FXML // fx:id="bTitle"
	private TextField bTitle; // Value injected by FXMLLoader

	@FXML // fx:id="btnAddOneToCart"
	private Button btnAddOneToCart; // Value injected by FXMLLoader

	@FXML // fx:id="btnGoToCart"
	private Button btnGoToCart; // Value injected by FXMLLoader

	@FXML
	void onAddOneToCart(ActionEvent event) {

		try {

			// mCurrentBook.setAvailableCount(mCurrentBook.getAvailableCount() -
			// 1);
			// mCurrentBook.setSellCount(mCurrentBook.getSellCount() + 1);
			// System.out.println("book left
			// "+mCurrentBook.getAvailableCount());
			// //commenting the following line because we shouldn't take the
			// book quantity out of the db unless user buys it
			// mBSI.updateBook(mCurrentBook).execute();
			// onRefreshBooks(event);

			ShoppingCartItemInterface mCartItem=new ShoppingCartItem();
			if (mCart.getItems() == null) {
				mCart.getItems().add(mCartItem);
			} else {
				boolean found = false;
				mItems = mCart.getItems();
				for (ShoppingCartItemInterface item : mItems) {
					if(item.getBook().equals(mCartItem.getBook())){
						item.setQuantity(item.getQuantity()+1);
						
					}
				
				} 

			}
		} catch (NumberFormatException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Wrong quantity");
			alert.setContentText("Invalid number value");
			alert.showAndWait();
			return;
		}

	}

	@FXML
	void onGoToCart(ActionEvent event) {
		navigateToScreen(ScreenNames.loginScreen);

	}

	@FXML
	void onRefreshBooks(ActionEvent event) {
		System.out.println("Refreshing books from " + this.getClass().getSimpleName());
		mBookCollection.clear();
		try {
			List<Book> books = mBSI.getAllBooks().execute().body();
			System.out.println("booklist" + books);
			mBookCollection.addAll(books);
			showBookDetails(null);
			mCurrentBook = null;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void showBookDetails(Book pBook) {
		if (pBook != null) {
			// Fill the labels with info from the person object.
			bTitle.setText(pBook.getTitle() + " by " + pBook.getAuthor());

		} else {
			// Person is null, remove all the text.
			bTitle.setText("");

		}
	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert VBox != null : "fx:id=\"VBox\" was not injected: check your FXML file 'bookstore_screen.fxml'.";
		assert btnRefresh != null : "fx:id=\"btnRefresh\" was not injected: check your FXML file 'bookstore_screen.fxml'.";
		assert bookTable != null : "fx:id=\"bookTable\" was not injected: check your FXML file 'bookstore_screen.fxml'.";
		assert colTitle != null : "fx:id=\"colTitle\" was not injected: check your FXML file 'bookstore_screen.fxml'.";
		assert colAuthor != null : "fx:id=\"colAuthor\" was not injected: check your FXML file 'bookstore_screen.fxml'.";
		assert colBooked != null : "fx:id=\"colBooked\" was not injected: check your FXML file 'bookstore_screen.fxml'.";
		assert bTitle != null : "fx:id=\"bTitle\" was not injected: check your FXML file 'bookstore_screen.fxml'.";
		assert btnAddOneToCart != null : "fx:id=\"btnAddOneToCart\" was not injected: check your FXML file 'bookstore_screen.fxml'.";
		assert btnGoToCart != null : "fx:id=\"btnGoToCart\" was not injected: check your FXML file 'bookstore_screen.fxml'.";

		colAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		colAvail.setCellValueFactory(new PropertyValueFactory<Book, Integer>("availableCount"));
		colBooked.setCellValueFactory(new PropertyValueFactory<Book, Integer>("sellCount"));
		/**
		 * OkHttpClient okClient = new OkHttpClient();
		 * okClient.interceptors().add(new Interceptor() {
		 * 
		 * public Response intercept(Chain chain) throws IOException {
		 * System.out.println("req:" + chain.request().toString()); Response
		 * response = chain.proceed(chain.request()); return response; } });
		 * String baseUrl = "http://localhost:8080/Day33CDI/rest/"; Retrofit
		 * client = new
		 * Retrofit.Builder().baseUrl(baseUrl).client(okClient).addConverterFactory(JacksonConverterFactory.create()).build();
		 * mBSI = client.create(BookServiceInterface.class);
		 */
		mBSI = RestClient.instance().getBookServiceInterface();
		mUSI = RestClient.instance().getUserServiceInterface();

		bookTable.setItems(mBookCollection);
		btnAddOneToCart.disableProperty().bind(Bindings.isNull(bookTable.getSelectionModel().selectedItemProperty()));
		showBookDetails(null);
		// Listen for selection changes and show the person details when
		// changed.
		bookTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			showBookDetails(newValue);
			mCurrentBook = newValue;
		});
		onRefreshBooks(new ActionEvent());
	}
}
