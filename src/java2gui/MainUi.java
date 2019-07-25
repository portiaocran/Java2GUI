package java2gui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainUi extends Application
{
   @Override
   public void start (Stage primaryStage)
   {
      SongList songList = new SongList();

      Label jB = new Label("JuxeBox Manager");
      Font font1 = new Font("Sans Serif", 50.0);

      BorderPane pane = new BorderPane(); //main pane
      pane.setPadding(new Insets(15, 20, 20, 15)); //padding for main pane

      GridPane gridPane = new GridPane(); //grid pane to hold textfields and labels
      gridPane.setPadding(new Insets(12, 13, 14, 15));

      TextField tfArtist = new TextField(); //Textfields for main screen
      TextField tfAlbum = new TextField();
      TextField tfSong = new TextField();
      TextField tfGenre = new TextField();

      gridPane.setHgap(5);
      gridPane.setVgap(5);
      gridPane.add(new Label("Artist : "), 0, 0);
      gridPane.add(tfArtist, 1, 0);
      gridPane.add(new Label("Album: "), 0, 1);
      gridPane.add(tfAlbum, 1, 1);
      gridPane.add(new Label("Song: "), 0, 2);
      gridPane.add(tfSong, 1, 2);
      gridPane.add(new Label("Genre: "), 0, 3);
      gridPane.add(tfGenre, 1, 3);


      tfArtist.prefWidthProperty().bind(gridPane.widthProperty().divide(1.5)); //binding text fields to scene


      jB.setFont(font1);

      songList.add(new Song("Jesus Walks", "Kanye West"));
      songList.add(new Song("Heard Em Say", "Kanye West"));

      songList.add(new Song("Song", "Vadym", "Weights", Genre.BLUES, 2009));

      songList.getRecordList().get(2).setPlays(100);


      ListView<String> lv = new ListView<>(FXCollections.observableArrayList(songList.getNameList()));
      lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


      //Buttons
      Button btAddInfo = new Button("Additional Info");
      btAddInfo.setFont(new Font("Sans Serif", 15));
      Button btAddNew = new Button("Add New");
      btAddNew.setFont(new Font("Sans Serif", 15));
      Button btSearch = new Button("Search");
      btSearch.setFont(new Font("Sans Serif", 15));
      Button btEdit = new Button("Edit");
      btEdit.setFont(new Font("Sans Serif", 15));

      //set Padding for both Hboxes holding buttons
//      buttons.setPadding(new Insets(11, 11, 11, 11));
//      buttons2.setPadding(new Insets(11, 11, 11, 11));
      HBox buttons = new HBox(10); //pane for first row of buttons
      HBox buttons2 = new HBox(10); //second pane for second row of buttons
      //Add buttons to Hboxes
      buttons.getChildren().add(btAddInfo);
      buttons.getChildren().add(btAddNew);
      buttons2.getChildren().add(btSearch);
      buttons2.getChildren().add(btEdit);
      buttons.setAlignment(Pos.BASELINE_CENTER);
      buttons.setPrefWidth(100);
      buttons2.setAlignment(Pos.BASELINE_CENTER);
      VBox vb = new VBox(20); //vertical box created to hold all nodes on the right
      GridPane gPane = new GridPane(); //new gridPane from small pane containing information on songs

      StackPane titlePane = new StackPane(); //pane for Title (JukeBox Manager) 
      vb.setPadding(new Insets(15, 15, 15, 30));

      titlePane.setAlignment(Pos.BASELINE_LEFT);

      titlePane.getChildren().add(jB); //adding title to titlePane

      StackPane sp2 = new StackPane(); // StackPane for Scrollbar
      sp2.getChildren().add(new ScrollPane(lv)); //adding scrollbar to pane 

      vb.prefHeightProperty().bind(pane.heightProperty().subtract(2)); //binding vertical box to scene
      vb.prefWidthProperty().bind(pane.widthProperty().divide(1.5));
      vb.getChildren().add(titlePane); //adding nodes to vertical box
      vb.getChildren().add(gridPane);
      vb.getChildren().add(buttons);
      vb.getChildren().add(buttons2);



      lv.prefHeightProperty().bind(pane.heightProperty().subtract(5)); //binding width and height of scrollbar to Scene
      lv.prefWidthProperty().bind(pane.widthProperty().divide(3));


      lv.getSelectionModel().selectedItemProperty().addListener( //controls main screen. if user selects song, information appears on screen
              ov -> {
                 for (Integer i : lv.getSelectionModel().getSelectedIndices()) {
                    btAddInfo.setOnAction(e -> addInfo(songList.getRecordList().get(i))); //Process Events for additional Information button
                    if ((songList.getRecordList().get(i).getGenre()) == null) {
                       tfGenre.setText("------");
                    }
                    else {
                       tfGenre.setText("Genre:" + songList.getRecordList().get(i).getGenre().name());
                    }

                    if ((songList.getRecordList().get(i).getAlbumName() == null)) {
                       tfAlbum.setText("------");
                    }
                    else {
                       tfGenre.setText(songList.getRecordList().get(i).getGenre().name());
                    }

                    tfArtist.setText(songList.getRecordList().get(i).getSongArtist());
                    tfSong.setText(songList.getRecordList().get(i).getSongTitle());
                 }
              });

      pane.setRight(vb); // placing all others nodes on right
      pane.setLeft(sp2); //placing scroll bar on left
      sp2.setAlignment(Pos.TOP_LEFT);
      Scene scene = new Scene(pane, 700, 450);


      primaryStage.setTitle("JukeBox Manager - Main Screen"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
      btAddNew.setOnAction(e -> addSong(songList.getRecordList(), primaryStage));
//
      //Process Events for additional Information button
   }

   //Additional Information method. When user selects additional info, a new window opens with more detailed information regarding song
   private void addInfo (Song song)
   {
      // Get values from text fields
      TextField artistAI = new TextField();   // text field values
      TextField albumAI = new TextField();
      TextField songAI = new TextField();
      TextField genreAI = new TextField();
      TextField yearAI = new TextField();
      TextField priceAI = new TextField();   // text field values
      TextField explicitAI = new TextField();
      TextField catNumAI = new TextField();
      TextField playsAI = new TextField();
      TextField ratingAI = new TextField();
      TextField sizeAI = new TextField();   // text field values
      TextField lengthAI = new TextField();
      TextField idAI = new TextField();
      TextField countryAI = new TextField();
      TextField videoAI = new TextField();
//      Button btAddSong = new Button("Add");
      Stage stageAI = new Stage(); //new stage that will appear after clicking additional info button
      GridPane gridPaneAI = new GridPane();
      Label AI = new Label("Additional Info"); //Title
      Font fontAI = new Font("Sans Serif", 50.0);
      AI.setFont(fontAI);

      gridPaneAI.setVgap(4);

      BorderPane paneAI = new BorderPane(); // main pane holder to hold other panes
      paneAI.setPadding(new Insets(15)); //padding for add info screen

      artistAI.prefWidthProperty().bind(paneAI.widthProperty().subtract(150)); //binding text field width to screen width

      StackPane paneTi = new StackPane(); //stackpane created to hold title


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
//      gridPaneAI.add(btAddSong, 1, 5);

      Button btAddNewAI = new Button("Add New");
      btAddNewAI.setFont(new Font("Sans Serif", 12));
      Button btSearchAI = new Button("Search");
      btSearchAI.setFont(new Font("Sans Serif", 12));
      Button btEditAI = new Button("Edit");
      btEditAI.setFont(new Font("Sans Serif", 12));
      Button btNextAI = new Button("Next");
      btNextAI.setFont(new Font("Sans Serif", 12));
      Button btDeleteAI = new Button("Delete");
      btDeleteAI.setFont(new Font("Sans Serif", 12));
      Button btPrevAI = new Button("Prev");
      btPrevAI.setFont(new Font("Sans Serif", 12));
      Button btExitAI = new Button("Exit");
      btExitAI.setFont(new Font("Sans Serif", 12));
      Button btCancelAI = new Button("Cancel");
      btCancelAI.setFont(new Font("Sans Serif", 12));

      GridPane gpAI = new GridPane();
      gpAI.setHgap(30);
      gpAI.setVgap(15);
//      gpAI.setPadding(new Insets(12, 13, 14, 20));

      gpAI.setAlignment(Pos.CENTER);

      gpAI.add(btAddNewAI, 2, 0);
      gpAI.add(btSearchAI, 2, 1);
      gpAI.add(btEditAI, 1, 0);
      gpAI.add(btNextAI, 1, 1);
      gpAI.add(btDeleteAI, 4, 0);
      gpAI.add(btPrevAI, 4, 1);
      gpAI.add(btExitAI, 5, 0);
      gpAI.add(btCancelAI, 5, 1);


      paneTi.getChildren().add(AI);

      paneAI.setTop(paneTi);
      paneAI.setCenter(gridPaneAI);
      paneAI.setBottom(gpAI);

      artistAI.setText(song.getSongArtist());
      songAI.setText(song.getSongTitle());
      String year = Double.toString(song.getYear());
      playsAI.setText(year);

      if (song.getGenre() == null) {
         genreAI.setText("-----");
      }
      else {
         genreAI.setText(song.getGenre().name());


      }





      // Create a scene and place it in the stage
      Scene scene2 = new Scene(paneAI, 600, 500);
      stageAI.setTitle("Additional Information"); // Set title
      stageAI.setScene(scene2); // Place the scene in the stage
      stageAI.show(); // Display the stage


   }

   private void addSong (ArrayList<Song> songList2, Stage stage)
   {

      TextField artistAS = new TextField();   // text field values
      TextField albumAS = new TextField();
      TextField songAS = new TextField();
      TextField genreAS = new TextField();
      TextField yearAS = new TextField();
      TextField priceAS = new TextField();   // text field values
      TextField explicitAS = new TextField();
      TextField catNumAS = new TextField();
      TextField playsAS = new TextField();
      TextField ratingAS = new TextField();
      TextField sizeAS = new TextField();   // text field values
      TextField lengthAS = new TextField();
      TextField idAS = new TextField();
      TextField countryAS = new TextField();
      TextField videoAS = new TextField();

      if (songAS.getText() != null) {
         String Title = songAS.getText();
         Song song = new Song(Title);
      }


      //      Button btAddSong = new Button("Add");
      Stage stageAS = new Stage(); //new stage that will appear after clicking additional info button
      GridPane gridPaneAS = new GridPane();
      Label AI = new Label("Add Song"); //Title
      Font fontAI = new Font("Sans Serif", 50.0);
      AI.setFont(fontAI);

      gridPaneAS.setVgap(4);

      BorderPane paneAS = new BorderPane(); // main pane holder to hold other panes
      paneAS.setPadding(new Insets(15)); //padding for add info screen

      artistAS.prefWidthProperty().bind(paneAS.widthProperty().subtract(150)); //binding text field width to screen width

      StackPane paneTi = new StackPane(); //stackpane created to hold title

      gridPaneAS.add(new Label("Artist : "), 0, 0);
      gridPaneAS.add(artistAS, 1, 0);
      gridPaneAS.add(new Label("Album: "), 0, 1);
      gridPaneAS.add(albumAS, 1, 1);
      gridPaneAS.add(new Label("Song: "), 0, 2);
      gridPaneAS.add(songAS, 1, 2);
      gridPaneAS.add(new Label("Genre: "), 0, 3);
      gridPaneAS.add(genreAS, 1, 3);
      gridPaneAS.add(new Label("Year: "), 0, 4);
      gridPaneAS.add(yearAS, 1, 4);
      gridPaneAS.add(new Label("Price : "), 0, 5);
      gridPaneAS.add(priceAS, 1, 5);
      gridPaneAS.add(new Label("Explicit: "), 0, 6);
      gridPaneAS.add(explicitAS, 1, 6);
      gridPaneAS.add(new Label("Catalog Number: "), 0, 7);
      gridPaneAS.add(catNumAS, 1, 7);
      gridPaneAS.add(new Label("# of Plays: "), 0, 8);
      gridPaneAS.add(playsAS, 1, 8);
      gridPaneAS.add(new Label("Rating: "), 0, 9);
      gridPaneAS.add(ratingAS, 1, 9);
//      gridPaneAI.add(btAddSong, 1, 5);

      Button btAddNewAS = new Button("Add New");
      btAddNewAS.setFont(new Font("Sans Serif", 12));
      Button btSearchAS = new Button("Search");
      btSearchAS.setFont(new Font("Sans Serif", 12));
      Button btEditAS = new Button("Edit");
      btEditAS.setFont(new Font("Sans Serif", 12));
      Button btNextAS = new Button("Next");
      btNextAS.setFont(new Font("Sans Serif", 12));
      Button btDeleteAS = new Button("Delete");
      btDeleteAS.setFont(new Font("Sans Serif", 12));
      Button btPrevAS = new Button("Prev");
      btPrevAS.setFont(new Font("Sans Serif", 12));
      Button btExitAS = new Button("Save");
      btExitAS.setFont(new Font("Sans Serif", 12));
      Button btCancelAS = new Button("Cancel");
      btCancelAS.setFont(new Font("Sans Serif", 12));

      //Retrieve text from user, store in variable and create song object with given attributes




      GridPane gpAS = new GridPane();
      gpAS.setHgap(30);
      gpAS.setVgap(15);
//      gpAI.setPadding(new Insets(12, 13, 14, 20));

      gpAS.setAlignment(Pos.CENTER);

      gpAS.add(btAddNewAS, 2, 0);
      gpAS.add(btSearchAS, 2, 1);
      gpAS.add(btEditAS, 1, 0);
      gpAS.add(btNextAS, 1, 1);
      gpAS.add(btDeleteAS, 4, 0);
      gpAS.add(btPrevAS, 4, 1);
      gpAS.add(btExitAS, 5, 0);
      gpAS.add(btCancelAS, 5, 1);


      paneTi.getChildren().add(AI);

      paneAS.setTop(paneTi);
      paneAS.setCenter(gridPaneAS);
      paneAS.setBottom(gpAS);


      // Create a scene and place it in the stage
      Scene scene2 = new Scene(paneAS, 600, 500);
      stageAS.setTitle("JukeBox Manager"); // Set title
      stageAS.setScene(scene2); // Place the scene in the stage
      stageAS.show(); // Display the stage

      btExitAS.setOnAction(e -> saveSong(stageAS, stage, songList2));


   }

   private void saveSong (Stage stage, Stage stage2, ArrayList<Song> recordList)
   {

      stage.close();
      for (int i = 0; i < recordList.size(); i++) {
         System.out.println(recordList.get(i));
      }
      stage2.show();

   }


   public static void main (String[] args) //main method to run program
   {
      launch(args);
   }

}



//

//

//
//   
//
//}
//
//   private void calculateLoanPayment ()
//   {
//      // Get values from text fields
//      String songTitle = song.getText();
//      String songArtist = artist.getText();
//      Genre genre = Genre.valueOf(tfgenre.getText());
//      double songYear = Double.parseDouble(year.getText());
//
//      // Create a loan object. Loan defined in Listing 10.2
//      Song song = new Song(songTitle, songArtist, genre, songYear);
//
//
//      songList.recordList.add(song);
//
////      for (int i = 0; i < songList.recordList.size(); i++) {
////         if (songList.recordList.isEmpty()) {
////            System.out.println("The songlist is empty");
////         }
////         else {
//      System.out.println(songList.recordList.get((songList.recordList.indexOf(song))).getSongTitle());
//
//}
//}
//       Display monthly payment and total payment
//
//   }
//
//         songList.recordList.add(song);
//      for (int i = 0; i < songList.recordList.size(); i++) {
//         if (songList.recordList.isEmpty()) {
//            System.out.println("The songlist is empty");
//         }
//         else {
//         System.out.println(songList.recordList.get((songList.recordList.indexOf(song))).getSongTitle());
//         }
//      }
//      // Display monthly payment and total payment
//      }
//private TextField artist = new TextField();
//   private TextField album = new TextField();
//   private TextField song = new TextField();
//   private TextField tfgenre = new TextField();
//   private TextField year = new TextField();
//   private Button btAddSong = new Button("Add");
//
//   @Override // Override the start method in the Application class
//        public void start (Stage primaryStage)
//   {
//      // Create UI
//      GridPane gridPane = new GridPane();
//
////      StackPane stackPane = new StackPane();
////      Label l1 = new Label("JuxeBox Manager");
//
//
////      gridPane.getChildren().add(l1);
//      gridPane.setHgap(5);
//      gridPane.setVgap(5);
//      gridPane.add(new Label("Artist : "), 0, 0);
//      gridPane.add(artist, 1, 0);
//      gridPane.add(new Label("Album: "), 0, 1);
//      gridPane.add(album, 1, 1);
//      gridPane.add(new Label("Song: "), 0, 2);
//      gridPane.add(song, 1, 2);
//      gridPane.add(new Label("Genre: "), 0, 3);
//      gridPane.add(tfgenre, 1, 3);
//      gridPane.add(new Label("Year: "), 0, 4);
//      gridPane.add(year, 1, 4);
//      gridPane.add(btAddSong, 1, 5);
//      gridPane.setPadding(new Insets(12, 13, 14, 15));
//
//
//
//      // Set properties for UI
//      gridPane.setAlignment(Pos.CENTER_LEFT);
////      l1.setAlignment(Pos.TOP_RIGHT);
////      artist.setAlignment(Pos.BOTTOM_RIGHT);
////      album.setAlignment(Pos.BOTTOM_RIGHT);
////      song.setAlignment(Pos.BOTTOM_RIGHT);
////      tfgenre.setAlignment(Pos.BOTTOM_RIGHT);
////      year.setAlignment(Pos.BOTTOM_RIGHT);
////      tfMonthlyPayment.setEditable(false);
////      tfTotalPayment.setEditable(false);
//      GridPane.setHalignment(btAddSong, HPos.RIGHT);
//
//      // Process events
//      btAddSong.setOnAction(e -> calculateLoanPayment());
//
//      // Create a scene and place it in the stage
//      Scene scene = new Scene(gridPane, 450, 300);
//      primaryStage.setTitle("LoanCalculator"); // Set title
//      primaryStage.setScene(scene); // Place the scene in the stage
//      primaryStage.show(); // Display the stage
//   }
//
//   private void calculateLoanPayment ()
//   {
//      // Get values from text fields
//      String songTitle = song.getText();
//      String songArtist = artist.getText();
//      Genre genre = Genre.valueOf(tfgenre.getText());
//      double songYear = Double.parseDouble(year.getText());
//
//      // Create a loan object. Loan defined in Listing 10.2
//      Song song = new Song(songTitle, songArtist, genre, songYear);
//
//
//      songList.recordList.add(song);
//
////      for (int i = 0; i < songList.recordList.size(); i++) {
////         if (songList.recordList.isEmpty()) {
////            System.out.println("The songlist is empty");
////         }
////         else {
//      System.out.println(songList.recordList.get((songList.recordList.indexOf(song))).getSongTitle());
//
////         }
////      }
////      // Display monthly payment and total payment
//
//   }
/**
 * The main method is only needed for the IDE with limited
 * JavaFX support. Not needed for running from the command line.
 */
