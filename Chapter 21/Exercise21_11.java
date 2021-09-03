import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
	
	int girlNames = 3;
	int boyNames = 1;
	private Map[] girls = getNames(girlNames);
	private Map[] boys = getNames(boyNames); 
	private ComboBox<String> cboYear = new ComboBox<>();
	private ComboBox<String> cboGender = new ComboBox<>();
	private TextField tfName = new TextField();
	private Button btFindRanking = new Button("Find Ranking");
	private Label lblResult = new Label("");
	private Scanner input; 

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

		// Create and register handle
		btFindRanking.setOnAction(e -> displayRank());

		// Create a Scene and place it in the stage
		Scene scene = new Scene(getPane(), 370, 160);
		primaryStage.setTitle("Exercise21_11"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void displayRank() {
		lblResult.setText(getGender() + " name " 
			+ tfName.getText() + " is ranked #" + getRank()
			+ " in year " + cboYear.getValue());
	}

	private String getGender() {
		return cboGender.getValue().equals("Female") ? "Girl" : "Boy";
	}

	private String getRank() {
		int year = Integer.parseInt(cboYear.getValue()) - 2001;

		if (cboGender.getValue().equals("Female")) {
			return girls[year].get(tfName.getText()) + "";
		}
		else
			return boys[year].get(tfName.getText()) + "";
	}

	BorderPane getPane() {
		for (int i = 2001; i <= 2010; i++)
			cboYear.getItems().add(i + "");

		cboGender.getItems().addAll("Female", "Male");	
		
	    GridPane gridPane = new GridPane();
	    gridPane.add(new Label("Select a year:"), 0, 0);
	    gridPane.add(new Label("Girl or boy?"), 0, 1);
	    gridPane.add(new Label("Enter a name:"), 0, 2);
	    gridPane.add(cboYear, 1, 0);
	    gridPane.add(cboGender, 1, 1);
	    gridPane.add(tfName, 1, 2);
	    gridPane.add(btFindRanking, 1, 3);
	    gridPane.setAlignment(Pos.CENTER);
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
	  
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(gridPane);
	    borderPane.setBottom(lblResult);
	    BorderPane.setAlignment(lblResult, Pos.CENTER);

		return borderPane;
	}
	
	Map[] getNames(int gender) {
		Map[] array = new Map[10];

		for (int year = 2001, i = 0; year <= 2010 && i < 10; year++, i++) {
			Map<String, String> map = new HashMap<>();

			try {
				java.net.URL url = new java.net.URL(
				"http://liveexample.pearsoncmg.com/data/babynamesranking" 
					+ year + ".txt");
	
				input = new Scanner(url.openStream());
				while (input.hasNext()) {
					ArrayList<String> list = new ArrayList<>();
					for (int x = 0; x < 5; x++) {
					   list.add(x, input.next());
					}
					map.put(list.get(gender), list.get(0));
				} 
			}
			
			catch (java.io.IOException ex) {
				System.out.println("I/0 Errors: no such file");
			}
			
			array[i] = map;
		}

		return array;
	}

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
