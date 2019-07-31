package java2gui;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * @author Portia Ocran
 */
public class SongList
{
   private ObservableList<Song> recordList;
   private ObservableList<String> nameList;

   public SongList ()
   {

      this.nameList = FXCollections.observableArrayList();
      this.recordList = FXCollections.observableArrayList();
   }

   public void add (Song song)
   {

      this.nameList.add(song.getSongTitle() + " - " + song.getSongArtist());
      this.recordList.add(song);

   }

   public ObservableList<Song> getRecordList ()
   {
      return recordList;
   }

   public void setRecordList (ObservableList<Song> recordList)
   {
      this.recordList = recordList;
   }

   public ObservableList<String> getNameList ()
   {
      Collections.sort(nameList);
      return nameList;
   }

   public void setNameList (ObservableList<String> nameList)
   {
      this.nameList = nameList;
   }

   @Override
   public String toString ()
   {
      String song = "";
      for (Song a : recordList) {
         song += a.getSongTitle() + " - ";
         song += a.getSongArtist();

      }
      return song;
   }

}
