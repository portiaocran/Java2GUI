package java2gui;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainUi extends Application 
{
                  
     //Instance variables for arraylist and GUI, to be accessed from anywere within class
             private static final SongList songList = new SongList(); // Main ArrayList to track songs
             private final ListView<Song> lv = new ListView<>(FXCollections.observableArrayList()); //observable list to update any changes

               //Buttons for Additional Info Window
             private final Button btAddInfo = new Button("Additional Info");
             private final Button btAddNew = new Button("Add New");
             private final Button btExit = new Button("Close");
             private final Button btSearch = new Button("Search");
             private final Button btAddNewAI = new Button("Add New");
             private final Button btSearchAI = new Button("Search");
             private final Button btEditAI = new Button("Edit");   
             private final Button btNextAI = new Button("Next"); 
             private final Button btDeleteAI = new Button("Delete");   
             private final Button btPrevAI = new Button("Prev");
             private final Button btExitAI = new Button("Exit");
             private final Button btSaveAI = new Button("Save");
              //Buttons for Add Song window
             private final Button btAddNewAS = new Button("Add New");
             private final Button btSearchAS = new Button("Search");
             private final Button btEditAS = new Button("Edit");
             private final Button btNextAS = new Button("Next");
             private final Button btDeleteAS = new Button("Delete");
             private final Button btPrevAS = new Button("Prev");
             private final Button btSaveAs = new Button("Save");
             private final Button btCancelAS = new Button("Cancel");
             private final Button saveEI = new Button("Save");
             //Textfields for Additional Info
             private final TextField artistAI = new TextField();
             private final TextField albumAI = new TextField();
             private final TextField songAI = new TextField();
             private final TextField genreAI = new TextField();
             private final TextField sizeAI = new TextField();
             private final TextField mvAI = new TextField();
             private final TextField timeAI = new TextField();
             private final TextField songIDAI = new TextField();
             private final TextField countryAI = new TextField();
             private final TextField yearAI = new TextField();
             private final TextField priceAI = new TextField();
             private final TextField explicitAI = new TextField();
             private final TextField catNumAI = new TextField();
             private final TextField playsAI = new TextField();
             private final TextField ratingAI = new TextField();
             private final TextField lengthAI = new TextField();
             private final TextField idAI = new TextField();
             private final TextField videoAI = new TextField();
             private final TextField tfArtist = new TextField();
             private final TextField tfAlbum = new TextField();
             private final TextField tfSong = new TextField();
             private final TextField tfGenre = new TextField();
             private Song song2;
             //Textfields for Add Song window
             private final TextField artistAS = new TextField();   // text field values
            private final TextField albumAS = new TextField();
             private final TextField songAS = new TextField();
             private final TextField songTime = new TextField();
             private final TextField yearAS = new TextField();
             private final TextField priceAS = new TextField();
             private final TextField songSize = new TextField();
             private final TextField songMB = new TextField();
             private final TextField playsAS = new TextField();
             private final TextField ratingAS = new TextField();
             private final TextField sizeAS = new TextField();
             private final TextField lengthAS = new TextField();
             private final TextField idAS = new TextField();
             private final TextField countryAS = new TextField();
             private final TextField videoAS = new TextField();
             private final ArrayList<Integer> years= new ArrayList<Integer>();
             private final ArrayList<Integer> rating= new ArrayList<Integer>();
             private final ArrayList<Double> price= new ArrayList<Double>();
             private ComboBox<Genre> cbGenre= new ComboBox<Genre>();
             private ComboBox<Integer> cbYear= new ComboBox<Integer>();
             private ComboBox<Explicit> cbExplicit= new ComboBox<Explicit>();
             private ComboBox<Country> cbCountry = new ComboBox<Country>();
             private ComboBox<MusicVideo> cbMV= new ComboBox<MusicVideo>();
             private ComboBox<Double> cbPrice= new ComboBox<Double>();
             private ComboBox<Integer> cbRating= new ComboBox<Integer>();
           
       @Override
           public void start (Stage primaryStage)
             { 
               //BorderPane pane will be used as main pane. Gridpane will be used to hold buttons and the label
                 BorderPane pane = new BorderPane();
                 GridPane gridPane = new GridPane();
                 HBox buttons = new HBox(10); //pane for first row of buttons
                 HBox buttons2 = new HBox(10); //second pane for second row of buttons
                 VBox vb = new VBox(20); //vertical box created to hold all nodes on the right
                 GridPane gPane = new GridPane(); //new gridPane from small pane containing information on songs
                 StackPane titlePane = new StackPane(); //pane for Title (JukeBox Manager) 
                 Label jB = new Label("JuxeBox Manager"); //Label for Main Screen
                 StackPane sp2 = new StackPane(); // StackPane for Scrollbar
                 Scene scene = new Scene(pane, 700, 450);
                  int rate=0;
                 double a=1.00;
                 
                 //ADDING SONGS

               Song s1 = new Song("Baby Be Mine", "Michael Jackson", Genre.POP, 1982, 2.50, Explicit.NO, "Thriller", 3, "5 MB", "3:21", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s1);
               Song s2 = new Song("The Girl is Mine", "Michael Jackson", Genre.POP, 1982, 2.00, Explicit.NO, "Thriller", 3, "5 MB", "1:30", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s2);
               Song s3 = new Song("Beat It", "Michael Jackson", Genre.ROCK, 1982, 3.50, Explicit.YES, "Thriller", 3, "2 MB", "3:45", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s3);
               Song s4 = new Song("Champion", "Kanye West", Genre.RAP, 2007, 1.75, Explicit.YES, "Graduation", 3, "2 MB", "3:15", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s4);
               Song s5 = new Song("Good Morning", "Kanye West", Genre.RAP, 2007,1.00, Explicit.YES, "Graduation", 2, "2 MB", "2:28", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s5);            
               Song s6 = new Song("Stronger", "Kanye West", Genre.RAP, 2007,4.00, Explicit.YES, "Graduation", 4, "2 MB", "5:11", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s6);
               Song s7 = new Song("Portland", "Drake, Quavo, Travis Scott", Genre.RAP, 2017,1.00, Explicit.YES, "More Life", 5, "3 MB", "3:55", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s7);
               Song s8 = new Song("Fake Love", "Drake", Genre.RAP, 2017,3.25, Explicit.YES, "More Life", 5, "1 MB", "1:47", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s8);
               Song s9 = new Song("Stir Fry", "Migos", Genre.RAP, 2018, 2.25, Explicit.YES, "Culture II", 2, "2.5 MB", "3:10", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s9);
               Song s10 = new Song("Bodak Yellow", "Cardi B", Genre.RAP, 2017,3.50, Explicit.YES, "Bodak Yellow", 2, "3 MB", "3:43", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s10);
               Song s11 = new Song("Fake Love", "Drake", Genre.RAP, 2017,3.25, Explicit.YES, "More Life", 5, "1 MB", "1:47", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s11);
               Song s12 = new Song("Ransom", "Lil' Tecca", Genre.RAP, 2019, 1.25, Explicit.NO, "Ransom", 2, "3.7 MB", "2:11", Country.UNITED_STATES, MusicVideo.NO);
               songList.add(s12);
               Song s13 = new Song("Rocket Man", "Elton John", Genre.POP, 1972,4.50, Explicit.NO, "Honky Chateau", 5, "3 MB", "4:42", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s13);
               Song s14 = new Song("Tiny Dancer", "Elton John", Genre.POP, 1972,4.50, Explicit.NO, "Honky Chateau", 4, "2 MB", "6:17", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s14);
               Song s15 = new Song("Your Song", "Elton John", Genre.ROCK, 1970, 3.25, Explicit.NO, "Elton John", 3, "2.9 MB", "3:59", Country.UNITED_STATES, MusicVideo.NO);
               songList.add(s15);
               Song s16 = new Song("Speed It Up", "Gunna", Genre.RAP, 2019,4.00, Explicit.YES, "Drip or Drown 2", 5, "3 MB", "4:42", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s16);
               Song s17 = new Song("EARFQUAKE", "Tyler, The Creator", Genre.RAP, 2019,2.50, Explicit.YES, "IGOR", 4, "1.9 MB", "3:10", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s17);
               Song s18 = new Song("U Say", "GoldLink & Tyler The Creator", Genre.RNB, 1970, 3.25, Explicit.NO, "Diaspora", 3, "3.2 MB", "3:21", Country.UNITED_STATES, MusicVideo.NO);
               songList.add(s18);
               Song s19 = new Song("Floor Seats", "A$AP Ferg", Genre.RAP, 2019,1.00, Explicit.YES, "Floor Seats", 2, "1 MB", "2:37", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s19);
               Song s20= new Song("Don't Waste My Time", "Krept & Konan", Genre.RAP, 2014,2.00, Explicit.YES, "Don't Waste My Time", 4, "1.9 MB", "3:10", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s20);
               Song s21 = new Song("Like a Prayer", "Madonna", Genre.POP, 1989, 5.00, Explicit.NO, "Like a Prayer", 5, "4.7 MB", "5:42", Country.UNITED_STATES, MusicVideo.NO);
               songList.add(s21);
               Song s22 = new Song("Floor Seats", "A$AP Ferg", Genre.RAP, 2019,1.00, Explicit.YES, "Floor Seats", 2, "1 MB", "2:37", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s22);
               Song s23= new Song("YMCA", "Village People", Genre.FUNK, 2002,2.00, Explicit.YES, "YMCA", 4, "2.1 MB", "4.44", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s23);
               Song s24 = new Song("Act Up", "City Girls", Genre.HIPHOP, 2019, 5.00, Explicit.NO, "Girl Code", 2, "2.7 MB", "2:39", Country.UNITED_STATES, MusicVideo.NO);
               songList.add(s24);
               Song s25 = new Song("Do For Love", "2PAC", Genre.RAP, 1997,1.00, Explicit.YES, "R U Still Down?",4, "3 MB", "3:00", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s25);
               Song s26 = new Song("Transportin'", "Kodak Black", Genre.RAP, 2017,3.50, Explicit.YES, "Project Baby Two", 5, "4.1 MB", "2:49", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s26);
               Song s27 = new Song("Moonlight", "City XXXTENTACION", Genre.HIPHOP, 2018, 3.50, Explicit.NO, "?", 2, "3.5 MB", "2:39", Country.UNITED_STATES, MusicVideo.NO);
               songList.add(s27);
               Song s28 = new Song("Do For Love", "2PAC", Genre.RAP, 1997,1.00, Explicit.YES, "R U Still Down?",4, "3 MB", "3:00", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s28);
               Song s29 = new Song("Someone Like You'", "Adele", Genre.POP, 2011,4.50, Explicit.NO, "21", 5, "4.1 MB", "2:49", Country.UNITED_STATES, MusicVideo.YES);
               songList.add(s29);
               Song s30 = new Song("Don't Stop Believing", "Journey", Genre.ROCK, 1981, 3.22, Explicit.NO, "Escape", 4, "3.5 MB", "4:45", Country.UNITED_STATES, MusicVideo.NO);
               songList.add(s30);

                  for (int i = 0 ; i < songList.getRecordList().size() ; i++) {
                              songList.getRecordList().get(i).setCatalogNumber(i+1);
                  }
               //Adding Songs to text file
                Path p = Paths.get("C:\\Users\\porti\\OneDrive\\Documents\\NetBeansProjects\\New Folder\\Java2GUI\\JBManager.txt");
                
                    String s="";
                  for (int i = 0 ; i < songList.getRecordList().size() ; i++) {
                         s += System.lineSeparator() + songList.getRecordList().get(i).toString();
                  }

                    try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
                    writer.write(s);
                } catch (IOException ioe) {
                    System.err.format("IOException: %s%n", ioe);
                }


                  
                         //formatting for nodes (font, pane, padding)
                         pane.setPadding(new Insets(15, 20, 20, 15));
                          gridPane.setPadding(new Insets(12, 13, 14, 15));
                          jB.setFont(new Font("Sans Serif", 50.0));
                          btAddInfo.setFont(new Font("Sans Serif", 15));
                          btAddNew.setFont(new Font("Sans Serif", 15));
                          btSearch.setFont(new Font("Sans Serif", 15));
                          btExit.setFont(new Font("Sans Serif", 15));
                          btAddNewAI.setFont(new Font("Sans Serif", 12));
                          btSearchAI.setFont(new Font("Sans Serif", 12));
                          btEditAI.setFont(new Font("Sans Serif", 12));
                          btNextAI.setFont(new Font("Sans Serif", 12));
                          btDeleteAI.setFont(new Font("Sans Serif", 12));
                          btPrevAI.setFont(new Font("Sans Serif", 12));
                          btExitAI.setFont(new Font("Sans Serif", 12));
                          btSaveAI.setFont(new Font("Sans Serif", 12)); 
                          tfArtist.setEditable(false);
                          tfArtist.prefWidthProperty().bind(gridPane.widthProperty().divide(1.5)); //Bind textfield to 
                          tfAlbum.setEditable(false);
                          tfSong.setEditable(false);
                          tfGenre.setEditable(false);
                          artistAI.setEditable(false);
                          albumAI.setEditable(false);
                          songAI.setEditable(false);
                          genreAI.setEditable(false);
                          yearAI.setEditable(false);
                          priceAI.setEditable(false);
                          explicitAI.setEditable(false);
                          catNumAI.setEditable(false);
                          playsAI.setEditable(false);
                          ratingAI.setEditable(false);
                          lengthAI.setEditable(false);
                          idAI.setEditable(false);
                          countryAI.setEditable(false);
                          videoAI.setEditable(false);
                          vb.setPadding(new Insets(15, 15, 15, 30));
                          titlePane.setAlignment(Pos.BASELINE_LEFT);
                          vb.prefHeightProperty().bind(pane.heightProperty().subtract(2)); //binding vertical box to scene
                          vb.prefWidthProperty().bind(pane.widthProperty().divide(1.5));
                          sp2.setAlignment(Pos.TOP_LEFT);

                         //Adding nodes to gridPane
                         gridPane.setHgap(5);
                         gridPane.setVgap(5);
                         gridPane.add(new Label("Song : "), 0, 0);
                         gridPane.add(tfSong, 1, 0);
                         gridPane.add(new Label("Album: "), 0, 1);
                         gridPane.add(tfAlbum, 1, 1);
                         gridPane.add(new Label("Artist: "), 0, 2);
                         gridPane.add(tfArtist, 1, 2);
                         gridPane.add(new Label("Genre: "), 0, 3);
                         gridPane.add(tfGenre, 1, 3);

                           //Add buttons to Hboxes
                          buttons.getChildren().add(btAddInfo);
                          buttons.getChildren().add(btAddNew);
                          buttons2.getChildren().add(btSearch);
                          buttons2.getChildren().add(btExit);
                          buttons.setAlignment(Pos.BASELINE_CENTER);
                          buttons.setPrefWidth(100);
                          buttons2.setAlignment(Pos.BASELINE_CENTER);
                          
                          //Adding nodes to panes, panes to scene, and scene to stage
                          titlePane.getChildren().add(jB); //adding title to titlePane
                          sp2.getChildren().add(new ScrollPane(lv)); //adding scrollbar to pane 
                          vb.getChildren().add(titlePane); //adding nodes to vertical box
                          vb.getChildren().add(gridPane);
                          vb.getChildren().add(buttons);
                          vb.getChildren().add(buttons2);
                          pane.setRight(vb); // placing all others nodes on right
                          pane.setLeft(sp2); //placing scroll bar on left
      
                          primaryStage.setTitle("JukeBox Manager - Main Screen"); // Set the stage title
                          primaryStage.setScene(scene); // Place the scene in the stage
                          primaryStage.show(); // Display the stage

                          lv.setItems(songList.getRecordList());
                          lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                          cbRating.setItems(FXCollections.observableArrayList(rating));
                                                  while (rate<=5) {   
                                                         rating.add(rate);
                                                         rate+=1;
                                                     }
                          cbGenre.setItems( FXCollections.observableArrayList( Genre.values()));
                          cbYear.setItems(FXCollections.observableArrayList( years));
                                                for(int i=1950;i<=2019;i++){
                                                     years.add(i);
                                                       }
                          cbExplicit.setItems(FXCollections.observableArrayList(Explicit.values()));
                          cbCountry.setItems(FXCollections.observableArrayList(Country.values()));
                          cbMV.setItems(FXCollections.observableArrayList(MusicVideo.values()));
                                                 while (a<4) {
                                                   price.add(a);
                                                   a+=0.50;
                                        }
                         
       
                          lv.prefHeightProperty().bind(pane.heightProperty().subtract(5)); //binding width and height of scrollbar to Scene
                          lv.prefWidthProperty().bind(pane.widthProperty().divide(3));

                          lv.getSelectionModel().selectedItemProperty().addListener( //controls main screen. if user selects song, information appears on screen
                            ov -> {
                                       for (Integer i : lv.getSelectionModel().getSelectedIndices()) {
                                              btAddInfo.setOnAction(e -> addInfo(songList.getRecordList().get(i), primaryStage));//Process 
                                              btAddNew.setOnAction(e -> addSong(primaryStage)); //Process Events for add button
                                              btSearch.setOnAction(l -> searchSong());//Process Events for search button
                                             
                                                                 tfGenre.setText(songList.getRecordList().get(i).getGenre().name());
                                                                  tfAlbum.setText(songList.getRecordList().get(i).getAlbumName());
                                                                 tfArtist.setText(songList.getRecordList().get(i).getSongArtist());
                                                                 tfSong.setText(songList.getRecordList().get(i).getSongTitle());
                                                                 cbGenre.getSelectionModel().select(songList.getRecordList().get(i).getGenre());
                                                                 cbCountry.getSelectionModel().select(songList.getRecordList().get(i).getCountry());
                                                                 cbYear.getSelectionModel().select(songList.getRecordList().get(i).getYear());
                                                                 cbPrice.getSelectionModel().select(songList.getRecordList().get(i).getPrice());
                                                                 
                                                                  }
                                       
                                                    lv.refresh();
                                       });                     
                          
                           btAddNew.setOnAction(e -> addSong(primaryStage));
                            btSearch.setOnAction(z -> searchSong());
                            btExit.setOnAction(q -> primaryStage.close());
              }
              
   //Additional Information method. When user selects additional info, a new window opens with more detailed information regarding song
              private void addInfo (Song song, Stage stage)
             {
                  
                          BorderPane paneAI = new BorderPane(); // main pane holder to hold other panes
                          Stage stageAI = new Stage(); //new stage that will appear after clicking additional info button
                          GridPane gridPaneAI = new GridPane();
                          StackPane paneTi = new StackPane(); //stackpane created to hold title
                          GridPane gpAI = new GridPane();
                          Label AI = new Label("Additional Info"); //Title
                          Font fontAI = new Font("Sans Serif", 50.0);
                          
                          //Event Processiong for different buttons
                          btAddNewAI.setOnAction(e -> addSong(stage));//Event Processing for new button
                          btExitAI.setOnAction(p -> { //Processing event for exit button
                                                                              stageAI.close();
                                                                             stage.show();
                                                                        });
                          btEditAI.setOnAction(e -> {
                               stageAI.close();
                               editSong(song); 
                                  }); 
                          btSearchAI.setOnAction(a -> searchSong()); //Event processing for search
                          btDeleteAI.setOnAction(s -> {
                                           Alert alert = new Alert(AlertType.CONFIRMATION);
                                                       alert.setTitle("Delete Song?");
                                                       alert.setHeaderText("Delete Song");
                                                       alert.setContentText("Are you sure you want to delete # " + song.toString());
                                                       ButtonType retry = new ButtonType("Yes");
                                                       ButtonType retry2 = new ButtonType("No");
                                                       alert.getButtonTypes().setAll(retry, retry2);
                                                       

                                                       alert.showAndWait().ifPresent(response -> {
    if (response == retry) {
              songList.getRecordList().remove(song);
              
                Alert alert2 = new Alert(AlertType.CONFIRMATION);
                                                       alert2.setTitle("Delete Song?");
                                                       alert2.setHeaderText("Your song has been deleted");
                                                       
                                 for (int i = 0 ; i < songList.getRecordList().size() ; i++) {
                              songList.getRecordList().get(i).setCatalogNumber(i+1);
                                      Path p = Paths.get("C:\\Users\\porti\\OneDrive\\Documents\\NetBeansProjects\\New Folder\\Java2GUI\\JBManager.txt");
                
                    String q="";
                  for (int a = 0 ; a < songList.getRecordList().size() ; a++) {
                         q += System.lineSeparator() + songList.getRecordList().get(a).toString();
                         
                                     try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
                    writer.write(q);
                } catch (IOException ioe) {
                    System.err.format("IOException: %s%n", ioe);
                }   }
                                 lv.refresh();
                                 alert2.show();
                                 stageAI.close();
    }
                  }
                  else if (response == retry2) {
                       stageAI.show();
}
                                  });
                          });
                          
                          paneAI.setPadding(new Insets(15)); //padding for main pane
                          gridPaneAI.setVgap(4);
                          AI.setFont(fontAI);
                          artistAI.prefWidthProperty().bind(paneAI.widthProperty().subtract(150)); //binding text field width to screen width
                          gpAI.setHgap(30);
                          gpAI.setVgap(15);
                          gpAI.setAlignment(Pos.CENTER);
                          
                          gridPaneAI.add(new Label("Artist : "), 0, 0);
                          gridPaneAI.add(artistAI, 1, 0);
                          gridPaneAI.add(new Label("Album: "), 0, 1);
                          gridPaneAI.add(albumAI, 1, 1);
                          gridPaneAI.add(new Label("Song: "), 0, 2);
                          gridPaneAI.add(songAI, 1, 2);
                          gridPaneAI.add(new Label("Genre: "), 0, 3);
                          gridPaneAI.add(genreAI, 1, 3);
                          gridPaneAI.add(new Label("Year: "), 0, 4);
                          gridPaneAI.add(yearAI, 1, 4);
                          gridPaneAI.add(new Label("Price : "), 0, 5);
                          gridPaneAI.add(priceAI, 1, 5);
                          gridPaneAI.add(new Label("Explicit: "), 0, 6);
                          gridPaneAI.add(explicitAI, 1, 6);
                          gridPaneAI.add(new Label("Catalog Number: "), 0, 7);
                          gridPaneAI.add(catNumAI, 1, 7);
                          gridPaneAI.add(new Label("# of Plays: "), 0, 8);
                          gridPaneAI.add(playsAI, 1, 8);
                          gridPaneAI.add(new Label("Rating: "), 0, 9);
                          gridPaneAI.add(ratingAI, 1, 9);
                          gridPaneAI.add(new Label("SongID: "), 0, 10);
                          gridPaneAI.add(songIDAI, 1, 10);
                          gridPaneAI.add(new Label("Country: "), 0, 11);
                          gridPaneAI.add(countryAI, 1, 11);
                          gridPaneAI.add(new Label("Music Video: "), 0, 12);
                          gridPaneAI.add(mvAI, 1, 12);
                          gridPaneAI.add(new Label("Size: "), 0, 13);
                          gridPaneAI.add(songSize, 1, 13);
                          gridPaneAI.add(new Label("Time: "), 0, 14);
                          gridPaneAI.add(songTime, 1, 14);
                          gpAI.add(btAddNewAI, 2, 0);
                          gpAI.add(btSearchAI, 2, 1);
                          gpAI.add(btEditAI, 1, 0);
                          gpAI.add(btNextAI, 1, 1);
                          gpAI.add(btDeleteAI, 4, 0);
                          gpAI.add(btPrevAI, 4, 1);
                          gpAI.add(btExitAI, 5, 0);
                          gpAI.add(btSaveAI, 5, 1);

                          paneTi.getChildren().add(AI);
                          paneAI.setTop(paneTi);
                          paneAI.setCenter(gridPaneAI);
                          paneAI.setBottom(gpAI);

                           //Setting text for text fields to song information
                          artistAI.setText(song.getSongArtist());
                          songAI.setText(song.getSongTitle());
                          albumAI.setText(song.getAlbumName());
                          yearAI.setText(Double.toString(song.getYear()));
                          priceAI.setText(Double.toString(song.getPrice()));
                          playsAI.setText(Integer.toString(song.getPlays()));
                          songSize.setText(song.getSize());
                          genreAI.setText(song.getGenre().name());
                          explicitAI.setText(song.getExplicit().name());
                          catNumAI.setText(Integer.toString(song.getCatalogNumber()));
                          songIDAI.setText(song.getSongID());
                          ratingAI.setText(Integer.toString(song.getRating()));
                           countryAI.setText(song.getCountry().getCountryName());
                        mvAI.setText(song.getMusicVideo().name());
                        songTime.setText(song.getSongLength());
                         
                          // Create a scene and place it in the stage
                          Scene scene2 = new Scene(paneAI, 700, 600);
                          stageAI.setTitle("Additional Information"); // Set title
                          stageAI.setScene(scene2); // Place the scene in the stage
                          stageAI.show(); // Display the stage

                         this.song2=song;
    
                          if (songList.getRecordList().indexOf(song) == songList.getRecordList().size()-1) {
                                        btNextAI.disableProperty();
                                        } 
                                   else {
                                                  btNextAI.setOnAction(e ->{ 
                                                  nextSong(this.song2); 
                                        });
                           }   
                          if (songList.getRecordList().indexOf(song) == 0) {
                                 btPrevAI.disableProperty();
                                        } 
                                   else {
                          btPrevAI.setOnAction(e ->{ 
                                 prevSong(this.song2);
                                    });
                              }
             }
              
                                                               
                                  
                                                               
             //Method to go to next song
             private void nextSong(Song song2) {
                          if (songList.getRecordList().indexOf(song2) == songList.getRecordList().size()-1) {
                                  btNextAI.disableProperty();
                                }
                                       else {
                               
                                       this.song2= songList.getRecordList().get(songList.getRecordList().indexOf(song2)+1);  
                                       this.songAI.setText(this.song2.getSongTitle()); 
                                       this.artistAI.setText(this.song2.getSongArtist());
                                       this.priceAI.setText(Double.toString(this.song2.getPrice()));
                                       this.ratingAI.setText(Integer.toString(this.song2.getRating()));
                                       this.playsAI.setText(Integer.toString(this.song2.getPlays()));
                                        this.catNumAI.setText((Integer.toString(this.song2.getCatalogNumber()))); 
                                        this.yearAI.setText(Integer.toString(this.song2.getYear()));
                                        this.songSize.setText(this.song2.getSize());
                                        this.albumAI.setText(this.song2.getAlbumName());        
                                        this.songSize.setText(this.song2.getSize());
                                        this.songTime.setText(this.song2.getSongLength());
                                        this.songIDAI.setText(this.song2.getSongID());
                                        this.countryAI.setText(this.song2.getCountry().getCountryName());
                                        this.mvAI.setText(this.song2.getMusicVideo().name());
                                        this.genreAI.setText(this.song2.getGenre().name());
                                         this.explicitAI.setText(this.song2.getExplicit().name());
                                         
                                                    btPrevAI.setOnAction(e ->{ 
                                          prevSong(this.song2); 
                    });
              }
             }
        
             //Method to go to previous song
               private void prevSong(Song song2) {
                          if (songList.getRecordList().indexOf(song2) == 0) {
                                   btNextAI.disableProperty();
                              }
                              else {
                                       this.song2= songList.getRecordList().get(songList.getRecordList().indexOf(song2)-1);  
                                       this.songAI.setText(this.song2.getSongTitle());    
                                       this.artistAI.setText(this.song2.getSongArtist());
                                       this.priceAI.setText(Double.toString(this.song2.getPrice()));
                                       this.ratingAI.setText(Integer.toString(this.song2.getRating()));
                                       this.playsAI.setText(Integer.toString(this.song2.getPlays()));
                                        this.yearAI.setText(Integer.toString(this.song2.getYear()));
                                        this.catNumAI.setText((Integer.toString(this.song2.getCatalogNumber())));
                                        this.albumAI.setText(this.song2.getAlbumName());        
                                        this.songSize.setText(this.song2.getSize());
                                        this.songTime.setText(this.song2.getSongLength());
                                        this.songIDAI.setText(this.song2.getSongID());
                                        this.countryAI.setText(this.song2.getCountry().getCountryName());
                                        this.mvAI.setText(this.song2.getMusicVideo().name());
                                        this.genreAI.setText(this.song2.getGenre().name());
                                        this.explicitAI.setText(this.song2.getExplicit().name());
                                        
                            btNextAI.setOnAction(e ->{ 
                                 nextSong(this.song2);
                                 });             
              }
               }
               
// Method to add song. If users selects add song button, they will enter another screen where they can then add a new song to the playlist
             private void addSong (Stage stage)
             {
                         Stage stageAS = new Stage();
                          GridPane gridPaneAS = new GridPane();
                          StackPane paneTi = new StackPane(); //stackpane created to hold title
                          Label AI = new Label("Add Song"); //Title  
                          Font fontAI = new Font("Sans Serif", 50.0);
                          GridPane gpAS = new GridPane();
                          GridPane gpAS2 = new GridPane();
                          BorderPane gpAS3= new BorderPane();
                          BorderPane paneAS = new BorderPane(); // main pane holder to hold other panes
                          HBox vbAS = new HBox(10);
                           HBox vbAS2 = new HBox(10);
                           VBox allAS= new VBox(10);
                           
                          //Formatting for panes and nodes
                          AI.setFont(fontAI);
                          gridPaneAS.setVgap(4);
                          paneAS.setPadding(new Insets(15)); //padding for add info screen
                          artistAS.prefWidthProperty().bind(paneAS.widthProperty().subtract(100)); //binding text field width to screen width
                          gpAS2.setPadding(new Insets(4, 0,0,0));
                          gpAS2.setHgap(10);
                          gpAS.setHgap(30);
                          gpAS.setVgap(15);
                          gpAS.setAlignment(Pos.CENTER);
                           cbGenre.prefWidthProperty().bind(paneAS.widthProperty().divide(7));
                          cbYear.prefWidthProperty().bind(paneAS.widthProperty().divide(9));
                          cbExplicit.prefWidthProperty().bind(paneAS.widthProperty().divide(11));
                          cbMV.prefWidthProperty().bind(paneAS.widthProperty().divide(11));
                          cbPrice.prefWidthProperty().bind(paneAS.widthProperty().divide(9));
                          cbCountry.prefWidthProperty().bind(paneAS.widthProperty().subtract(100));
                          cbRating.prefWidthProperty().bind(paneAS.widthProperty().subtract(100));
                          btAddNewAS.setFont(new Font("Sans Serif", 12));
                          btSearchAS.setFont(new Font("Sans Serif", 12));
                          btEditAS.setFont(new Font("Sans Serif", 12));
                          btNextAS.setFont(new Font("Sans Serif", 12));
                          btDeleteAS.setFont(new Font("Sans Serif", 12));
                          btPrevAS.setFont(new Font("Sans Serif", 12));
                          btSaveAs.setFont(new Font("Sans Serif", 12));
                          btCancelAS.setFont(new Font("Sans Serif", 12));
                          
                          vbAS.setPadding(new Insets(5));
     
//                          lbYear.setPadding
                          allAS.getChildren().addAll(vbAS, vbAS2);
                         
                          //adding buttons to gridpane
                          gridPaneAS.add(new Label("Title: "), 0, 0);
                          gridPaneAS.add(songAS, 1, 0);
                          artistAS.clear();
                          gridPaneAS.add(new Label("Artist: "), 0, 1);
                          gridPaneAS.add(artistAS, 1, 1);
                          albumAS.clear();
                          gridPaneAS.add(new Label("Album: "), 0, 2);
                          gridPaneAS.add(albumAS, 1, 2);
                          songAS.clear();
                          gridPaneAS.add(new Label("Size: "), 0, 3);
                          gridPaneAS.add(songSize, 1, 3);
                          songSize.clear();
                          gridPaneAS.add(new Label("Time: "), 0, 4);
                          gridPaneAS.add(songTime, 1, 4);
                          songTime.clear();
                          gridPaneAS.add(new Label("Country : "), 0, 5);
                          gridPaneAS.add(cbCountry, 1, 5);
                          cbCountry.getSelectionModel().clearSelection();
                          cbCountry.setItems( FXCollections.observableArrayList( Country.values()));  
                          gridPaneAS.add(new Label("Rating: "), 0, 6);
                          gridPaneAS.add(cbRating, 1, 6);
                          cbRating.getSelectionModel().clearSelection();
                          cbRating.setItems(FXCollections.observableArrayList(rating));  
                           gpAS2.add(new Label("Genre:  "), 0, 0);
                          gpAS2.add(cbGenre,1,0);
                          cbGenre.getSelectionModel().clearSelection();
                          cbGenre.setItems( FXCollections.observableArrayList( Genre.values()));  
                           gpAS2.add(new Label("Year:"), 2, 0);
                          gpAS2.add(cbYear,3,0);
                          cbYear.getSelectionModel().clearSelection();
                          cbYear.setItems(FXCollections.observableArrayList( years));
                          gpAS2.add(new Label("Explicit:"), 4, 0);
                          gpAS2.add(cbExplicit,5,0);
                          gpAS2.add(new Label("Price:"), 6, 0);
                          cbExplicit.getSelectionModel().clearSelection();
                          cbExplicit.setItems( FXCollections.observableArrayList( Explicit.values()));  
                          gpAS2.add(cbPrice,7,0);
                          cbPrice.getSelectionModel().clearSelection();
                          cbPrice.setItems(FXCollections.observableArrayList(price));
                           gpAS2.add(new Label("Video:"), 8, 0);
                          gpAS2.add(cbMV,9,0);
                          cbMV.getSelectionModel().clearSelection();
                          cbMV.setItems( FXCollections.observableArrayList( MusicVideo.values()));
                          gpAS.add(btAddNewAS, 2, 0);
                          gpAS.add(btSearchAS, 2, 1);
                          gpAS.add(btEditAS, 1, 0);
                          gpAS.add(btNextAS, 1, 1);
                          gpAS.add(btDeleteAS, 4, 0);
                          gpAS.add(btPrevAS, 4, 1);
                          gpAS.add(btSaveAs, 5, 0);
                          gpAS.add(btCancelAS, 5, 1);
                          gpAS.prefWidthProperty().bind(paneAS.widthProperty().subtract(2));
                          
                          gpAS3.setTop(gridPaneAS);
                          gpAS3.setCenter(gpAS2);
                          paneTi.getChildren().add(AI);

                          paneAS.setTop(paneTi);
                          paneAS.setCenter(gpAS3);
                          paneAS.setBottom(gpAS);

                          // Create a scene and place it in the stage
                          Scene scene2 = new Scene(paneAS, 700, 450);
                          stageAS.setTitle("JukeBox Manager"); // Set title
                          stageAS.setScene(scene2); // Place the scene in the stage
                          stageAS.show(); // Display the stage
                          
                          btCancelAS.setOnAction(e -> stageAS.close());
                          btSaveAs.setOnAction(e -> {  // Event processing for saving song, user must select save to add a song
                               
                               try{
                                        String title = songAS.getText();
                                        String artist = artistAS.getText();
                                        String album = albumAS.getText();
                                        double price = cbPrice.getValue();
                                        Genre genre= cbGenre.getValue();
                                        int years = cbYear.getValue();
                                        Explicit explicit= cbExplicit.getValue();
                                        int rating=cbRating.getValue();
                                        String size="0";
                                        String length= songTime.getText();
                                        Country country= cbCountry.getValue();
                                        MusicVideo mv= cbMV.getValue();
                                   
                                        if (genre == null) {
                                        Alert alert = new Alert(AlertType.ERROR);                            
                                        alert.setTitle("Song NOT Added");
                                        alert.setHeaderText("Song was not added to JukeBox Manager");
                                        alert.setContentText("Please enter a genre.");
                                        alert.showAndWait();
                                                    }
                                          
                                        else if (explicit == null) {
                                                    Alert alert = new Alert(AlertType.ERROR);                            
                                                     alert.setTitle("Song NOT Added");
                                                     alert.setHeaderText("Song was not added to JukeBox Manager");
                                                     alert.setContentText("Please enter if song is explicit, or not.");
                                                     alert.showAndWait();
                                                                   }
                                 
                                       else if (country == null) {
                                                    Alert alert = new Alert(AlertType.ERROR);                            
                                                    alert.setTitle("Song NOT Added");
                                                    alert.setHeaderText("Song was not added to JukeBox Manager");
                                                    alert.setContentText("Please enter which country this song was released in.");
                                                   alert.showAndWait();
                                                    }
                                     
                                        else if (mv == null) {
                                                    Alert alert = new Alert(AlertType.ERROR);                            
                                                    alert.setTitle("Song NOT Added");
                                                    alert.setHeaderText("Song was not added to JukeBox Manager");
                                                    alert.setContentText("Please enter if this song has a music video or not.");
                                                    alert.showAndWait();
                                                    }
                                        else if (cbYear == null) {
                                                    Alert alert = new Alert(AlertType.ERROR);                            
                                                    alert.setTitle("Song NOT Added");
                                                    alert.setHeaderText("Song was not added to JukeBox Manager");
                                                    alert.setContentText("Please enter if this song has a music video or not.");
                                                    alert.showAndWait();
                                                    }
                                        else if (price == 0) {
                                                    Alert alert = new Alert(AlertType.ERROR);                            
                                                    alert.setTitle("Song NOT Added");
                                                    alert.setHeaderText("Song was not added to JukeBox Manager");
                                                    alert.setContentText("Please enter if this song has a music video or not.");
                                                    alert.showAndWait();
                                                    }
                                        else {
                                                     Song song = new Song(title, artist, genre,years, price, explicit, album, rating, size, length, country, mv);
                                                     song.setCatalogNumber(songList.getRecordList().size()+1);
                                                     songList.add(song);
                                                     
                                                     Path p = Paths.get("C:\\Users\\porti\\OneDrive\\Documents\\NetBeansProjects\\New Folder\\Java2GUI\\JBManager.txt");
                                                     String s = System.lineSeparator() + song.toString();
                                                     try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
                                                                 writer.write(s);
                                                                 } catch (IOException ioe) {
                                                                      System.err.format("IOException: %s%n", ioe);
                                                                 }
                                                     
                                                    Alert alert = new Alert(AlertType.CONFIRMATION);
                                                    alert.setTitle("Song added to JukeBox Manager");
                                                    alert.setHeaderText( song.getSongTitle() + " - " + song.getSongArtist()+" has been added to JukeBox Manager!");
                                                    alert.showAndWait();
                                                    
                                                    Alert alert12 = new Alert(AlertType.INFORMATION);
                                                    alert12.setTitle("Add Song");
                                                    alert12.setHeaderText("Would you like to add another song?");
                                                    ButtonType yes = new ButtonType("yes");
                                                    ButtonType no = new ButtonType("no");
                                                    alert12.getButtonTypes().clear();
                                                    alert12.getButtonTypes().addAll(yes, no);
                                                    alert12.showAndWait().ifPresent(response -> {
    if (response == yes) {
         addSong(stage);
    }
    
    else if(response == no){
                                                    
                                                    
                                   stageAS.close(); //after selecting save, add song screen will close
                                   stage.show(); // main stage will show
                                         }
                            });
                                        }
                               
                               }
                                                            catch (Exception ioe) {
                                                            Alert alert = new Alert(AlertType.ERROR);
                                                       alert.setTitle("Song not added");
                                                       alert.setHeaderText("Missing Value in one or more fields.");
                                                       alert.setContentText("All fields are required. Complete all fields, and then save");
                                                       alert.showAndWait();
                                                     }
                                           
                          
             });
                          }
                                  
             
             private void editSong(Song song) 
                 {
                          Stage stageEdit = new Stage();
                          GridPane gpEdit = new GridPane();
                          StackPane paneTi = new StackPane(); //stackpane created to hold title
                          Label EI = new Label("Edit Song"); //Title  
                          Font fontEI = new Font("Sans Serif", 50.0);
                          GridPane gpEI = new GridPane();
                          GridPane gpEi2 = new GridPane();
                          BorderPane gpEi3= new BorderPane();
                          BorderPane paneEI = new BorderPane(); // main pane holder to hold other panes
                          HBox vbEI = new HBox(10);
                          HBox vbEI2 = new HBox(10);
                          VBox vbAllEI= new VBox(10);
                           
                           TextField artistEdit = new TextField();   // text field values
                           TextField albumEdit = new TextField();
                           TextField songEdit = new TextField();
                           TextField sizeEdit = new TextField();
                           TextField songLen= new TextField();
                           
                          //Formatting for panes and nodes
                          EI.setFont(fontEI);
                          gpEdit.setVgap(4);
                          paneEI.setPadding(new Insets(15)); //padding for add info screen
                          artistEdit.prefWidthProperty().bind(paneEI.widthProperty().subtract(100)); //binding text field width to screen width
                          gpEi2.setPadding(new Insets(4, 0,0,0));
                          gpEi2.setHgap(10);
                          gpEI.setHgap(30);
                          gpEI.setVgap(15);
                          gpEI.setAlignment(Pos.CENTER);
                           cbGenre.prefWidthProperty().bind(paneEI.widthProperty().divide(7));
                          cbYear.prefWidthProperty().bind(paneEI.widthProperty().divide(9));
                          cbExplicit.prefWidthProperty().bind(paneEI.widthProperty().divide(11));
                          cbMV.prefWidthProperty().bind(paneEI.widthProperty().divide(11));
                          cbPrice.prefWidthProperty().bind(paneEI.widthProperty().divide(9));
                          cbCountry.prefWidthProperty().bind(paneEI.widthProperty().subtract(100));
                          cbRating.prefWidthProperty().bind(paneEI.widthProperty().subtract(100));
                          btAddNewAS.setFont(new Font("Sans Serif", 12));
                          btSearchAS.setFont(new Font("Sans Serif", 12));
                          btEditAS.setFont(new Font("Sans Serif", 12));
                          btNextAS.setFont(new Font("Sans Serif", 12));
                          btDeleteAS.setFont(new Font("Sans Serif", 12));
                          btPrevAS.setFont(new Font("Sans Serif", 12));
                          btSaveAs.setFont(new Font("Sans Serif", 12));
                          btCancelAS.setFont(new Font("Sans Serif", 12));
                          
                          
                          vbEI.setPadding(new Insets(5));
                          //adding buttons to gridpane
                          gpEdit.add(new Label("Title: "), 0, 0);
                          gpEdit.add(songEdit, 1, 0);
                          songEdit.setText(song.getSongTitle());
                          gpEdit.add(new Label("Artist: "), 0, 1);
                          gpEdit.add(artistEdit, 1, 1);
                          artistEdit.setText(song.getSongArtist());
                          gpEdit.add(new Label("Album: "), 0, 2);
                          gpEdit.add(albumEdit, 1, 2);
                          albumEdit.setText(song.getAlbumName());
                          gpEdit.add(new Label("Time: "), 0, 3);
                          gpEdit.add(songLen, 1, 3);
                          songLen.setText(song.getSize());
                          gpEdit.add(new Label("Size: "), 0, 4);
                          gpEdit.add(sizeEdit, 1, 4);
                          sizeEdit.setText(song.getSongLength());
                          gpEdit.add(new Label("Country : "), 0, 5);
                          gpEdit.add(cbCountry, 1, 5);
                          cbCountry.getSelectionModel().select(song.getCountry());
                          cbCountry.setItems( FXCollections.observableArrayList( Country.values()));  
                          gpEdit.add(new Label("Rating: "), 0, 6);
                          gpEdit.add(cbRating, 1, 6);
                          cbRating.getSelectionModel().select(song.getRating());
                          cbRating.setItems(FXCollections.observableArrayList(rating));  
                           gpEi2.add(new Label("Genre:  "), 0, 0);
                          gpEi2.add(cbGenre,1,0);
                          cbGenre.getSelectionModel().select(song.getGenre());
                          cbGenre.setItems( FXCollections.observableArrayList( Genre.values()));  
                           gpEi2.add(new Label("Year:"), 2, 0);
                          gpEi2.add(cbYear,3,0);
                          int year =song.getYear();
                          cbYear.getSelectionModel().select(0);
                          cbYear.setItems(FXCollections.observableArrayList( years));
                          gpEi2.add(new Label("Explicit:"), 4, 0);
                          gpEi2.add(cbExplicit,5,0);
                          gpEi2.add(new Label("Price:"), 6, 0);
                          cbExplicit.getSelectionModel().select(song.getExplicit());
                          cbExplicit.setItems( FXCollections.observableArrayList( Explicit.values()));  
                          gpEi2.add(cbPrice,7,0);
                          cbPrice.getSelectionModel().select(song.getPrice());
                          cbPrice.setItems(FXCollections.observableArrayList(price));
                           gpEi2.add(new Label("Video:"), 8, 0);
                          gpEi2.add(cbMV,9,0);
                          cbMV.getSelectionModel().select(song.getMusicVideo());
                          cbMV.setItems( FXCollections.observableArrayList( MusicVideo.values()));
                          gpEI.add(btAddNewAS, 2, 0);
                          gpEI.add(btSearchAS, 2, 1);
                          gpEI.add(btEditAS, 1, 0);
                          gpEI.add(btNextAS, 1, 1);
                          gpEI.add(btDeleteAS, 4, 0);
                          gpEI.add(btPrevAS, 4, 1);
                          gpEI.add(saveEI, 5, 0);
                          gpEI.add(btCancelAS, 5, 1);
                          gpEI.prefWidthProperty().bind(paneEI.widthProperty().subtract(2));
                          vbAllEI.getChildren().addAll(vbEI, vbEI2);
                          gpEi3.setTop(gpEdit);
                          gpEi3.setCenter(gpEi2);
                          paneTi.getChildren().add(EI);
                          paneEI.setTop(paneTi);
                          paneEI.setCenter(gpEi3);
                          paneEI.setBottom(gpEI);

                          // Create a scene and place it in the stage
                          Scene scene2 = new Scene(paneEI, 700, 450);
                          stageEdit.setTitle("JukeBox Manager"); // Set title
                          stageEdit.setScene(scene2); // Place the scene in the stage
                          stageEdit.show(); // Display the stage

                          saveEI.setOnAction(e ->  
                          {
                                try{
                                        song.setSongTitle(songEdit.getText());
                                        song.setSongArtist(artistEdit.getText());
                                        song.setGenre(cbGenre.getValue());
                                        song.setSongLength(songLen.getText());
                                        song.setYear(cbYear.getValue());
                                        song.setPrice(cbPrice.getValue());
                                        song.setExplicit(cbExplicit.getValue());
                                        song.setAlbumName(albumEdit.getText());
                                        song.setSize(sizeEdit.getText());
                                        song.setCountry(cbCountry.getValue());
                                        song.setMusicVideo(cbMV.getValue());
                                                       Alert alert = new Alert(AlertType.CONFIRMATION);
                                                       alert.setTitle("Song Edit Successful");
                                                       alert.setHeaderText( song.getSongTitle() + " - " + song.getSongArtist()+" has been changed!");
                                                       alert.showAndWait();
                                        stageEdit.close();
                                        lv.refresh();
                          }catch (Exception ioe) {
                                                            Alert alert = new Alert(AlertType.ERROR);
                                                       alert.setTitle("Song Edit Unsucessful");
                                                       alert.setHeaderText("Missing Value in one or more fields.");
                                                       alert.setContentText("All fields are required. Complete all fields, and then save");

                                                       alert.showAndWait();
                                                     }
                          });
           
                 }

             // Method used to look up a song
             private void searchSong ()
             {
                          BorderPane paneSearch = new BorderPane();  //Main Pane to hold all Panes
                          BorderPane paneSearch2 = new BorderPane(); //Pane to hold Label and RadioButtons
                          Label searchL = new Label("Search Song"); //Label for search song window
                          Pane labelPane = new Pane(); //Pane to hold Label
                          Button btSearch = new Button("Search"); //Search Button
                          HBox searchHB = new HBox(15); //HBox to hold search button and search bar
                          VBox searchVB = new VBox(8);  //VBox created to place radio buttons vertically
                          VBox searchVB2 = new VBox(10);  //VBox created to place search bar and text area which will display song results
                          HBox tfSongHB = new HBox(); //HBOX to hold text area that will display results

                          TextField tfSearch = new TextField();  //Search Bar
                          TextArea tfSong = new TextArea(); //text area to display results
                          //Search by: text
                          Text txtSearch = new Text("Search by: ");
                          Font font = new Font("Sans Serif", 20);
                          //Radio buttons to search
                          RadioButton rbArtist = new RadioButton("Artist");
                          RadioButton rbAlbum = new RadioButton("Album");
                          RadioButton rbTitle = new RadioButton("Title");
                          RadioButton rbGenre = new RadioButton("Genre");
                              //Created new toggle group and added radio buttons, so only one can be selected at a time
                                       ToggleGroup searchTog = new ToggleGroup();
                                       rbArtist.setToggleGroup(searchTog);
                                       rbAlbum.setToggleGroup(searchTog);
                                       rbTitle.setToggleGroup(searchTog);
                                       rbGenre.setToggleGroup(searchTog);
      
                          //Formatting for nodes and panes
                          paneSearch.setPadding(new Insets(20)); // Setting padding for main pane
                          searchL.setFont(new Font("Sans Serif", 50)); // actual label
                          tfSearch.prefWidthProperty().bind(paneSearch.widthProperty().subtract(120));
                          searchHB.setPadding(new Insets(20, 5, 20, 5)); // padding for HBOX
                          tfSong.setEditable(false);
                          tfSong.prefWidthProperty().bind(paneSearch.widthProperty().subtract(120));
                          tfSong.prefHeightProperty().bind(paneSearch.heightProperty().divide(2));
                          tfSongHB.setPadding(new Insets(7, 5, 20, 5)); //padding for hbox holding textarea
                          tfSongHB.setPrefSize(400, 400); //set sizing for HBOX/text area
                          txtSearch.setFont(font);
                          
                          //Adding nodes to panes, panes to scene
                          tfSongHB.getChildren().add(tfSong); //added textarea to hbox
                                //Adding "Search by" text, and radio buttons to a vertical box, so all are placed in a straight line
                          searchVB.getChildren().add(txtSearch);
                          searchVB.getChildren().add(rbArtist);
                          searchVB.getChildren().add(rbAlbum);
                          searchVB.getChildren().add(rbTitle);
                          searchVB.getChildren().add(rbGenre);
                          searchVB2.getChildren().add(searchHB);
                          searchVB2.getChildren().add(tfSongHB);
                          //Adding search bar, and button to hbox so they sit side by side
                          searchHB.getChildren().addAll(tfSearch, btSearch);
                          searchHB.setAlignment(Pos.CENTER);
                         //Adding label to pane
                         labelPane.getChildren().add(searchL);
                         //adding pane w/ label to Pane with search bar and button
                         paneSearch2.setRight(labelPane);
                         paneSearch2.setLeft(searchVB);
                         //Adding panes to Main pane
                         paneSearch.setTop(paneSearch2);
                         paneSearch.setCenter(searchVB2);
      
                          //Creating stage, setting scene to stage, naming and displaying stage
                          Stage searchStage = new Stage();
                          Scene searchScene = new Scene(paneSearch, 700, 450);
                          searchStage.setScene(searchScene);
                          searchStage.setTitle("JuxeBox - Search Song");
                          searchStage.show();

                         //When user selects search button, the following method allows results to be displayed in text area
                         btSearch.setOnAction(g -> {
                         //If user searches by title
                         String songName = "";
                                       if (rbTitle.isSelected()) {
                                             Pattern pat= Pattern.compile((".*" + tfSearch.getText() + ".*"), Pattern.CASE_INSENSITIVE);
                                             for (int i = 0 ; i < songList.getRecordList().size() ; i++) {
                                                  Matcher mat= pat.matcher(songList.getRecordList().get(i).getSongTitle());
                                                  if (mat.matches()) 
                                                         songName+=songList.getRecordList().get(i).toString()+ "\n\n";
                                                    }
                          tfSong.setText(songName);
                                        }
                                       
                           //if user searches by artist
                                        else if(rbArtist.isSelected()) {
                                          Pattern pat= Pattern.compile((".*" + tfSearch.getText() + ".*"), Pattern.CASE_INSENSITIVE);
                                             for (int i = 0 ; i < songList.getRecordList().size() ; i++) {
                                                  Matcher mat= pat.matcher(songList.getRecordList().get(i).getSongArtist());
                                                  if (mat.matches()) 
                                                         songName+=songList.getRecordList().get(i).toString() + "\n\n";
                                                          continue;
                                                    }
                          tfSong.setText(songName);
                                        }
                                        else if (rbAlbum.isSelected()) {
                                                        Pattern pat= Pattern.compile((".*" + tfSearch.getText() + ".*"), Pattern.CASE_INSENSITIVE);
                                                                for (int i = 0 ; i < songList.getRecordList().size() ; i++) {
                                                                        Matcher mat= pat.matcher(songList.getRecordList().get(i).getAlbumName());
                                                                                   if (mat.matches()) 
                                                         songName+=songList.getRecordList().get(i).toString() + "\n\n";
                                                          continue;
                                                    }
                                                      tfSong.setText(songName);
                                                    }
            //   if user searches by genre
                                                                 else if (rbGenre.isSelected()) {
                                                                           for (int i = 0 ; i < songList.getRecordList().size() ; i++) {
                                                                                     if (songList.getRecordList().get(i).getGenre() == Genre.valueOf(tfSearch.getText())) 
                                                                                          songName += songList.getRecordList().get(i).getSongTitle() + " - " + songList.getRecordList().get(i).getSongArtist() + "\n\n";
                                                                                          continue;
                                                                              }
                                                          tfSong.setText(songName);
                                                    }
                           });
              }

             public static void main (String[] args)  {//main method to run program
                 
              
                              launch(args);
              
             }
}


