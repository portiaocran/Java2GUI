package java2gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

   //created instance variable for the arraylist and buttons on main stage so they can be accessed throughout all methods

   SongList songList = new SongList(); // Main ArrayList to track songs

   Button btAddInfo = new Button("Additional Info");
   Button btAddNew = new Button("Add New");
   Button btSearch = new Button("Search");
   Button btEdit = new Button("Edit");


   @Override
   public void start (Stage primaryStage)
   {
      //font for buttons
      btAddInfo.setFont(new Font("Sans Serif", 15));
      btAddNew.setFont(new Font("Sans Serif", 15));
      btSearch.setFont(new Font("Sans Serif", 15));
      btEdit.setFont(new Font("Sans Serif", 15));

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

      gridPane.setHgap(5); //Adding nodes to gridPane
      gridPane.setVgap(5);
      gridPane.add(new Label("Song : "), 0, 0);
      gridPane.add(tfSong, 1, 0);
      gridPane.add(new Label("Album: "), 0, 1);
      gridPane.add(tfAlbum, 1, 1);
      gridPane.add(new Label("Artist: "), 0, 2);
      gridPane.add(tfArtist, 1, 2);
      gridPane.add(new Label("Genre: "), 0, 3);
      gridPane.add(tfGenre, 1, 3);


      songList.add(new Song("Jesus Walks", "Kanye West"));  // added songs to list to test functionality, will remove
      songList.add(new Song("Heard Em Say", "Kanye West"));

      Song song = new Song("Nothing", "Portia");
      song.setGenre(Genre.RNB);
      song.setAlbumName("Greatness");
      songList.add(song);

      songList.add(new Song("Song", "Vadym", Genre.BLUES, 2009));

      //New Listivew which will track NameList that contains strings for song name and artist
      ListView<String> lv = new ListView<>(FXCollections.observableArrayList());
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
                       tfGenre.setText(songList.getRecordList().get(i).getGenre().name());
                    }

                    if ((songList.getRecordList().get(i).getAlbumName() == null)) {
                       tfAlbum.setText("------");
                    }
                    else {
                       tfAlbum.setText(songList.getRecordList().get(i).getAlbumName());
                    }
                    tfArtist.setText(songList.getRecordList().get(i).getSongArtist());
                    tfSong.setText(songList.getRecordList().get(i).getSongTitle());

                 }
                 lv.refresh();
              });

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
//      pane.setStyle("-fx-background-color: ");

      primaryStage.setTitle("JukeBox Manager - Main Screen"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
      btAddNew.setOnAction(e -> addSong(primaryStage));
      btSearch.setOnAction(l -> searchSong());
   }

   //Additional Information method. When user selects additional info, a new window opens with more detailed information regarding song
   private void addInfo (Song song, Stage stage)
   {
      BorderPane paneAI = new BorderPane(); // main pane holder to hold other panes
      paneAI.setPadding(new Insets(15)); //padding for main pane

      // text field values. Set to uneditable so user can't make changes
      TextField artistAI = new TextField();
      artistAI.setEditable(false);
      TextField albumAI = new TextField();
      albumAI.setEditable(false);
      TextField songAI = new TextField();
      songAI.setEditable(false);
      TextField genreAI = new TextField();
      genreAI.setEditable(false);
      TextField yearAI = new TextField();
      yearAI.setEditable(false);
      TextField priceAI = new TextField();
      priceAI.setEditable(false);
      TextField explicitAI = new TextField();
      explicitAI.setEditable(false);
      TextField catNumAI = new TextField();
      catNumAI.setEditable(false);
      TextField playsAI = new TextField();
      playsAI.setEditable(false);
      TextField ratingAI = new TextField();
      ratingAI.setEditable(false);
      TextField sizeAI = new TextField();
      TextField lengthAI = new TextField();
      lengthAI.setEditable(false);
      TextField idAI = new TextField();
      idAI.setEditable(false);
      TextField countryAI = new TextField();
      countryAI.setEditable(false);
      TextField videoAI = new TextField();
      videoAI.setEditable(false);


      Stage stageAI = new Stage(); //new stage that will appear after clicking additional info button

      GridPane gridPaneAI = new GridPane();
      gridPaneAI.setVgap(4);

      Label AI = new Label("Additional Info"); //Title
      Font fontAI = new Font("Sans Serif", 50.0);
      AI.setFont(fontAI);

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
      albumAI.setText(song.getAlbumName());
      yearAI.setText(Double.toString(song.getYear()));
      priceAI.setText(Double.toString(song.getPrice()));
//      explicitAI.setText(song.getExplicit().toString());
//      playsAI.setText(year);

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
      });

      btSearchAI.setOnAction(a -> searchSong());
   }

// Method to add song. If users selects add song button, they will enter another screen where they can then add a new song to the playlist
   private void addSong (Stage stage)
   {
      TextField artistAS = new TextField("Required");   // text field values
      TextField albumAS = new TextField();
      TextField songAS = new TextField("Required");
      TextField genreAS = new TextField("Required");
      TextField yearAS = new TextField();
      TextField priceAS = new TextField();
      TextField explicitAS = new TextField();
      TextField catNumAS = new TextField();
      TextField playsAS = new TextField();
      TextField ratingAS = new TextField();
      TextField sizeAS = new TextField();
      TextField lengthAS = new TextField();
      TextField idAS = new TextField();
      TextField countryAS = new TextField();
      TextField videoAS = new TextField();

      Stage stageAS = new Stage(); //new stage that will appear after clicking add song info button
      GridPane gridPaneAS = new GridPane();
      Label AI = new Label("Add Song"); //Title
      Font fontAI = new Font("Sans Serif", 50.0);
      AI.setFont(fontAI);

      gridPaneAS.setVgap(4);

      BorderPane paneAS = new BorderPane(); // main pane holder to hold other panes
      paneAS.setPadding(new Insets(15)); //padding for add info screen

      artistAS.prefWidthProperty().bind(paneAS.widthProperty().subtract(150)); //binding text field width to screen width

      StackPane paneTi = new StackPane(); //stackpane created to hold title
      //adding buttons to gridpane
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
      //gridPaneAI.add(btAddSong, 1, 5);

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
      Button btSaveAs = new Button("Save");
      btSaveAs.setFont(new Font("Sans Serif", 12));
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
      gpAS.add(btSaveAs, 5, 0);
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

      btSaveAs.setOnAction(e -> {  // user must select save to add a song
         {
            String title = songAS.getText();
            String artist = artistAS.getText();
            String album = albumAS.getText();
            Double year = Double.parseDouble(yearAS.getText());
            Double price = Double.parseDouble(priceAS.getText());

            Song song = new Song(title, artist, album);
            song.setGenre(Genre.valueOf(genreAS.getText()));
            song.setYear(year);
            song.setPrice(price);
            song.setExplicit(true);

            songList.add(song);
            stageAS.close(); //after selecting save, add song screen will close
            stage.show(); // main stage will show

         }
      });
   }


   // Method used to look up a song
   private void searchSong ()
   {
      BorderPane paneSearch = new BorderPane();  //Main Pane to hold all Panes
      paneSearch.setPadding(new Insets(20)); // Setting padding for main pane
      BorderPane paneSearch2 = new BorderPane(); //Pane to hold Label and RadioButtons

      Label searchL = new Label("Search Song"); //Label for search song window
      Pane labelPane = new Pane(); //Pane to hold Label 

      searchL.setFont(new Font("Sans Serif", 50)); // actual label
      TextField tfSearch = new TextField();  //Search Bar
      tfSearch.prefWidthProperty().bind(paneSearch.widthProperty().subtract(120));

      Button btSearch = new Button("Search"); //Search Button
      HBox searchHB = new HBox(15); //HBox to hold search button and search bar
      searchHB.setPadding(new Insets(20, 5, 20, 5)); // padding for HBOX

      VBox searchVB = new VBox(8);  //VBox created to place radio buttons vertically
      VBox searchVB2 = new VBox(10);  //VBox created to place search bar and text area which will display song results

      TextArea tfSong = new TextArea(); //text area to display results
      tfSong.setEditable(false);
      tfSong.prefWidthProperty().bind(paneSearch.widthProperty().subtract(120));
      tfSong.prefHeightProperty().bind(paneSearch.heightProperty().divide(2));
      HBox tfSongHB = new HBox(); //HBOX to hold text area that will display results
      tfSongHB.getChildren().add(tfSong); //added textarea to hbox
      tfSongHB.setPadding(new Insets(7, 5, 20, 5)); //padding for hbox holding textarea

      tfSongHB.setPrefSize(400, 400); //set sizing for HBOX/text area

      //Radio buttons to search
      RadioButton rbArtist = new RadioButton("Artist");
      RadioButton rbAlbum = new RadioButton("Album");
      RadioButton rbTitle = new RadioButton("Title");
      RadioButton rbGenre = new RadioButton("Genre");

      //Search by: text
      Text txtSearch = new Text("Search by: ");
      Font font = new Font("Sans Serif", 20);
      txtSearch.setFont(font);

      //Created new toggle group and added radio buttons, so only one can be selected at a time
      ToggleGroup searchTog = new ToggleGroup();

      rbArtist.setToggleGroup(searchTog);
      rbAlbum.setToggleGroup(searchTog);
      rbTitle.setToggleGroup(searchTog);
      rbGenre.setToggleGroup(searchTog);

      //Adding "Searh by" text, and radio buttons to a vertical box, so all are placed in a straight line
      searchVB.getChildren().add(txtSearch);
      searchVB.getChildren().add(rbArtist);
      searchVB.getChildren().add(rbAlbum);
      searchVB.getChildren().add(rbTitle);
      searchVB.getChildren().add(rbGenre);
      searchVB2.getChildren().add(searchHB);
      searchVB2.getChildren().add(tfSongHB);


// Adding search bar, and button to hbox so they sit side by side
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
         if (rbTitle.isSelected()) {
            String songName = "";
            for (int i = 0; i < songList.getRecordList().size(); i++) {
               if (tfSearch.getText().equalsIgnoreCase(songList.getRecordList().get(i).getSongTitle())) {
                  songName += songList.getRecordList().get(i).getSongTitle() + " - " + songList.getRecordList().get(i).getSongArtist() + "\n\n";
               }
            }
            tfSong.setText(songName);
         }
         //if user searches by artist
         else if (rbArtist.isSelected()) {
            String songName = "";
            for (int i = 0; i < songList.getRecordList().size(); i++) {
               if (tfSearch.getText().equalsIgnoreCase(songList.getRecordList().get(i).getSongArtist())) {
                  songName += songList.getRecordList().get(i).getSongTitle() + " - " + songList.getRecordList().get(i).getSongArtist() + "\n\n";
               }
            }
            tfSong.setText(songName);
         }
         else if (rbAlbum.isSelected()) {
            String songName = "";
            for (int i = 0; i < songList.getRecordList().size(); i++) {
               if (tfSearch.getText().equalsIgnoreCase(songList.getRecordList().get(i).getAlbumName())) {
                  songName += songList.getRecordList().get(i).getSongTitle() + " - " + songList.getRecordList().get(i).getSongArtist() + "\n\n";
               }
            }
            tfSong.setText(songName);
         }
         //   if user searches by genre
         else if (rbGenre.isSelected()) {
            String songName = "";
            for (int i = 0; i < songList.getRecordList().size(); i++) {
               if (songList.getRecordList().get(i).getGenre() == Genre.valueOf(tfSearch.getText())) {
                  songName += songList.getRecordList().get(i).getSongTitle() + " - " + songList.getRecordList().get(i).getSongArtist() + "\n\n";
               }
//               else {
//                  songName = "Sorry, no song matches this genre.";
//               }
            }
            tfSong.setText(songName);
         }

      });
   }

   public static void main (String[] args) //main method to run program
   {
      launch(args);
   }

}
