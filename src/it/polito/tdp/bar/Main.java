package it.polito.tdp.bar;
	
import it.polito.tdp.bar.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Model model = new Model();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Bar.fxml"));
			BorderPane root = (BorderPane) loader.load();
			BarController controller = loader.getController();
			controller.setModel(model);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
