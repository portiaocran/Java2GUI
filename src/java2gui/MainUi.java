package java2gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainUi extends Application
{


   SongList songList = new SongList();

   Button btAddInfo = new Button("Additional Info");
   Button btAddNew = new Button("Add New");
   Button btSearch = new Button("Search");
   Button btEdit = new Button("Edit");


   @Override
   public void start (Stage primaryStage)
   {

      Label jB = new Label("JuxeBox Manager"); //Label for Main Screen
      jB.setFont(new Font("Sans Serif", 50.0));


      BorderPane pane = new BorderPane(); //MAIN PANE!
      pane.setPadding(new Insets(15, 20, 20, 15)); //padding for main pane

      GridPane gridPane = new GridPane(); //Gridpane for buttons and labels
      gridPane.setPadding(new Insets(12, 13, 14, 15));

      TextField tfArtist = new TextField(); //Textfields for main screen
      tfArtist.setEditable(false);
      tfArtist.prefWidthProperty().bind(gridPane.widthProperty().divide(1.5)); //Bind textfield to 
      TextField tfAlbum = new TextField();
      tfAlbum.setEditable(false);
      TextField tfSong = new TextField();
      tfSong.setEditable(false);
      TextField tfGenre = new TextField();
      tfGenre.setEditable(false);

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


      songList.add(new Song("Jesus Walks", "Kanye West"));
      songList.add(new Song("Heard Em Say", "Kanye West"));

      songList.add(new Song("Song", "Vadym", "Weights", Genre.BLUES, 2009));

      //Buttons for main Jukebox screen
//      Button btAddInfo = new Button("Additional Info");
      btAddInfo.setFont(new Font("Sans Serif", 15));
//      Button btAddNew = new Button("Add New");
      btAddNew.setFont(new Font("Sans Serif", 15));
//      Button btSearch = new Button("Search");
      btSearch.setFont(new Font("Sans Serif", 15));
//      Button btEdit = new Button("Edit");
      btEdit.setFont(new Font("Sans Serif", 15));

      ListView<String> lv = new ListView<>(FXCollections.observableArrayList()); //New Listivew which will track NameList that contains strings for song name and artist
      lv.setItems(songList.getNameList());
      lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
      lv.prefHeightProperty().bind(pane.heightProperty().subtract(5)); //binding width and height of scrollbar to Scene
      lv.prefWidthProperty().bind(pane.widthProperty().divide(3));

      lv.getSelectionModel().selectedItemProperty().addListener( //controls main screen. if user selects song, information appears on screen
              ov -> {
                 for (Integer i : lv.getSelectionModel().getSelectedIndices()) {
                    btAddInfo.setOnAction(e -> addInfo(songList.getRecordList().get(i), primaryStage)); //Process Events for additional Information button
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
                 lv.refresh();
              });

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


      pane.setRight(vb); // placing all others nodes on right
      pane.setLeft(sp2); //placing scroll bar on left
      sp2.setAlignment(Pos.TOP_LEFT);
      Scene scene = new Scene(pane, 700, 450);
      pane.setStyle("-fx-background-color: pink");

      primaryStage.setTitle("JukeBox Manager - Main Screen"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
      btAddNew.setOnAction(e -> addSong(primaryStage));
      btSearch.setOnAction(l -> searchSong());
   }

   //Additional Information method. When user selects additional info, a new window opens with more detailed information regarding song
   private void addInfo (Song song, Stage stage)
   {
      // Get values from text fields
      TextField artistAI = new TextField();   // text field values
      artistAI.setEditable(false);
      TextField albumAI = new TextField();
      albumAI.setEditable(false);
      TextField songAI = new TextField();
      songAI.setEditable(false);
      TextField genreAI = new TextField();
      genreAI.setEditable(false);
      TextField yearAI = new TextField();
      yearAI.setEditable(false);
      TextField priceAI = new TextField();   // text field values
      priceAI.setEditable(false);
      TextField explicitAI = new TextField();
      explicitAI.setEditable(false);
      TextField catNumAI = new TextField();
      catNumAI.setEditable(false);
      TextField playsAI = new TextField();
      playsAI.setEditable(false);
      TextField ratingAI = new TextField();
      ratingAI.setEditable(false);
      TextField sizeAI = new TextField();   // text field values
      sizeAI.setEditable(false);
      TextField lengthAI = new TextField();
      lengthAI.setEditable(false);
      TextField idAI = new TextField();
      idAI.setEditable(false);
      TextField countryAI = new TextField();
      countryAI.setEditable(false);
      TextField videoAI = new TextField();
      videoAI.setEditable(false);
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
      Scene scene2 = new Scene(paneAI, 700, 450);
      stageAI.setTitle("Additional Information"); // Set title
      stageAI.setScene(scene2); // Place the scene in the stage
      stageAI.show(); // Display the stage
      btCancelAI.setOnAction(g -> {
         stageAI.close();
         stage.show();
      });

      btAddNewAI.setOnAction(e -> addSong(stage));
      btExitAI.setOnAction(p -> {
         stageAI.close();
         stage.show();
      }
      );
   }


   private void addSong (Stage stage)
   {

      TextField artistAS = new TextField("Required");   // text field values
      TextField albumAS = new TextField();
      TextField songAS = new TextField("Required");
      TextField genreAS = new TextField("Required");
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
      Scene scene2 = new Scene(paneAS, 700, 450);
      stageAS.setTitle("JukeBox Manager"); // Set title
      stageAS.setScene(scene2); // Place the scene in the stage
      stageAS.show(); // Display the stage


      btExitAS.setOnAction(e -> {
         {
            String title = songAS.getText();
            String artist = artistAS.getText();
            Song song = new Song(title, artist);
            songList.add(song);
            stageAS.close();
            for (int i = 0; i < songList.getRecordList().size(); i++) {
               System.out.println(songList.getRecordList().get(i).getSongTitle());
            }
            stage.show();

         }
      });

   }

   private void searchSong ()
   {

      BorderPane paneSearch = new BorderPane();
      Pane labelPane = new Pane();
      Label searchL = new Label("Search Song"); //Label to for search song window
      searchL.setFont(new Font("Sans Serif", 50));

      labelPane.getChildren().add(searchL);

      paneSearch.setCenter(labelPane);





      Stage searchStage = new Stage();

      Scene searchScene = new Scene(paneSearch, 700, 450);
      searchScene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
      searchStage.setScene(searchScene);
      searchStage.setTitle("JuxeBox - Search Song");
      searchStage.show();


   }

   public static void main (String[] args) //main method to run program
   {
      launch(args);
   }

}
