package View;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.Arrays;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;

public class Main extends Application {

  public Main() {
    // TODO Auto-generated constructor stub
  }
 
  
  /**
   * Function that validates the username and password
   */
  public int checkPassword(TextField username, PasswordField password) {
    int departmentScheduler = 1;
    int faculty = 2;
    int guest = 3;
    
    if (true) {
      return 1;
    }
    return 0;
  }

  /**
   * Function that fits the application to the screen size
   * @param primaryStage
   */
  public static void fitToScreen(Stage primaryStage) {
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

    primaryStage.setX(primaryScreenBounds.getMinX());
    primaryStage.setY(primaryScreenBounds.getMinY());
    primaryStage.setWidth(primaryScreenBounds.getWidth());
    primaryStage.setHeight(primaryScreenBounds.getHeight());
  }
  
  /**
   * Changes the image based on height and width 
   * @param imgView
   * @param x
   * @param y
   */
  public static void fitImage(ImageView imgView, int x, int y) {
    imgView.setFitHeight(x);
    imgView.setFitWidth(y);
    imgView.setPreserveRatio(true);
  }
  
  /**
   * Login Screen    
   * @param primaryStage
   */
  public void start(final Stage primaryStage) {
    StackPane root = new StackPane();
    VBox authentication = new VBox();
    HBox guestLogin = new HBox();
    TextField username = new TextField();
    Button loginButton = new Button();
    PasswordField password = new PasswordField();
    Image img = new Image("file:images/Logo.png");    // www.logomakr.com/5mcZwA
    ImageView imgView = new ImageView(img);
    BooleanProperty firstTime = new SimpleBooleanProperty(true); 
    Label guestLabel = new Label("Not a registered user?");
    Hyperlink guestUser = new Hyperlink();
    
    guestUser.setText("Login here");
    username.setStyle("-fx-background-radius: 10 10 10 10");
    password.setStyle("-fx-background-radius: 10 10 10 10");
    loginButton.setStyle("-fx-background-radius: 10 10 10 10");
    
    fitImage(imgView, 500, 500);
    
    authentication.setAlignment(Pos.CENTER);
    authentication.setPadding(new Insets(0, 100, 0, 100));
    username.setPromptText("Username");
    password.setPromptText("Password");
    loginButton.setText("Login");
    guestLogin.setAlignment(Pos.CENTER);
    
    //check if the username and password is correct 
    loginButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
          int permission = checkPassword(username, password);
          
          if (permission == 1) {
            calendarView(primaryStage);
          }
      }
    });
    
    //remove default focus from text field
    username.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
      if(newValue && firstTime.get()){
          authentication.requestFocus(); // Delegate the focus to container
          firstTime.setValue(false); // Variable value changed for future references
      }
    });
    
    guestLogin.getChildren().addAll(guestLabel, guestUser);
    authentication.setSpacing(15);
    authentication.getChildren().addAll(imgView, username, password, loginButton, guestLogin);
    root.getChildren().addAll(authentication);
    root.setStyle("-fx-background-color: transparent;");
    primaryStage.setTitle("ThinkInc");
    fitToScreen(primaryStage);
    primaryStage.setScene(new Scene(root, Color.LIGHTGREY));
    primaryStage.show();
  }
  
  public static HBox createHBox(String labelName, ObservableList<String> objects) {
    ListView<String> list = new ListView<String>();
    HBox hb = new HBox();
    Label l = new Label(labelName);
    l.setFont(new Font("Helvetica Light", 20));
    l.setAlignment(Pos.CENTER);
    ObservableList<String> options = FXCollections.observableArrayList(objects);
    list.setItems(options);
    list.setMaxWidth(100);

    
    hb.getChildren().addAll(l, list);
    hb.setPadding(new Insets(5, 5, 5, 5));
    return hb;
  }
  
  /**
   * Create filters 
   * @param primaryStage
   */
  public static VBox createFilters(Stage primaryStage) {
    Line line = new Line(200, 200, 0, 200);
    Line line2 = new Line(200, 300, 0, 300);
    Line line3 = new Line(200, 400, 0, 400);
    line.setStroke(Color.BLACK);
   
    String[] sYears = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
    ObservableList<String> years = FXCollections.observableList(Arrays.asList(sYears));
    HBox year = createHBox("Year: ", years);
    
    String[] terms = {"Fall", "Winter", "Spring"};
    ObservableList<String> oTerms = FXCollections.observableList(Arrays.asList(terms));
    HBox term = createHBox("Term: ", oTerms);
    
    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    ObservableList<String> oDays = FXCollections.observableList(Arrays.asList(days));
    HBox day = createHBox("Day: ", oDays); 
    
    String[] levels = {"100", "200", "300", "400", "500"};
    ObservableList<String> oLevels = FXCollections.observableList(Arrays.asList(levels));
    HBox courseLevels = createHBox("Level: ", oLevels);
    
    String[] timeRange = {"Morning", "Afternoon", "Evening", "Night"};
    ObservableList<String> oRanges = FXCollections.observableList(Arrays.asList(timeRange));
    HBox times = createHBox("Time: ", oRanges);
    
    VBox filters = new VBox();   
    filters.setStyle("-fx-background-color: #F9F9F9");
    filters.setMinWidth(150);
    filters.setPadding(new Insets(10, 10, 10, 10));
    filters.getChildren().addAll(year, term, line, day, line2, courseLevels, line3, times);
    
    return filters;
  }
  
  /**
   * Main Calendar View 
   */
  public static void calendarView(Stage primaryStage) {
    BorderPane bp = new BorderPane();
    StackPane sp = new StackPane();
    HBox menuBar = new HBox();
    Image img = new Image("file:images/PlanIt.png");   
    ImageView imgView = new ImageView(img); 

    
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    fitImage(imgView, 200, 200);
    
    bp.setTop(menuBar);
    bp.setLeft(createFilters(primaryStage));
    menuBar.setStyle("-fx-background-color: #D3D3D3");
    menuBar.setMaxHeight(40);
    menuBar.getChildren().addAll(imgView);
    menuBar.setAlignment(Pos.TOP_LEFT);
    sp.getChildren().addAll(bp);
    sp.setStyle("-fx-background-color: transparent;");
  
    fitToScreen(primaryStage);
    primaryStage.setScene(new Scene(sp));
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);

  }

}
