package java2gui;
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
/**
 * @author Portia Ocran
 */
public class TestClass extends Application
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

      btAddNew.setOnAction(e -> addSong(songList, lv, pane));

      primaryStage.setTitle("JukeBox Manager - Main Screen"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
//
      //Process Events for additional Information button

   }

   public static void main (String[] args)
   {
      launch(args);
   }
}
