package java2gui;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * @author Portia Ocran
 */
public class SongList
{
   private ArrayList<Song> recordList;
   private ObservableList<String> nameList;

   public SongList ()
   {

      this.nameList = FXCollections.observableArrayList();
      this.recordList = new ArrayList<Song>();
   }

   public void add (Song song)
   {

      this.nameList.add(song.getSongTitle() + " - " + song.getSongArtist());
      this.recordList.add(song);

   }

   public ArrayList<Song> getRecordList ()
   {
      return recordList;
   }

   public void setRecordList (ArrayList<Song> recordList)
   {
      this.recordList = recordList;
   }

   public ObservableList<String> getNameList ()
   {
      return nameList;
   }

   public void setNameList (ObservableList<String> nameList)
   {
      this.nameList = nameList;
   }


}
