package java2gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * @author Portia Ocran
 */
public class SongList implements java.io.Serializable
{
     
   private ObservableList<Song> recordList;
  
   public SongList ()
   {
      this.recordList = FXCollections.observableArrayList();
   }

   public void add (Song song) {
        
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

   @Override
   public String toString ()
   {
      String song = "";
      for (Song a : this.recordList) {
         song += a.getSongTitle() + " - ";
         song += a.getSongArtist();

      }
      return song;
   }

}
