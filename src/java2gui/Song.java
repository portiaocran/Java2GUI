package java2gui;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * @author Portia Ocran
 */
public class Song implements java.io.Serializable
{
   private transient String songTitle;
   private transient String songArtist;
   private transient String albumName;
   private transient Genre genre;
   private transient int year;
   private transient double price;
   private transient Explicit explicit;
   private transient int catalogNumber;
   private static int nextCatNum=1;
   private transient int plays;
   private transient int rating;
   private transient String size;
   private transient String songLength;
   private transient String songID;
   private transient Country country;
   private transient MusicVideo musicVideo;

     public
     Song (String songTitle, String songArtist, Genre genre, int year, double price, Explicit explicit, String albumName, int rating, String size, String songLength, Country country, MusicVideo musicVideo)
     {
          this.songTitle = songTitle;
          this.songArtist = songArtist;
          this.genre = genre;
          this.year = year;
          this.price = price;
          this.explicit = explicit;
          this.catalogNumber= Song.nextCatNum;
          Song.nextCatNum++;
          this.plays = 0;
          this.albumName = albumName;
          this.rating = rating;
          this.size = size;
          this.songLength = songLength;
          this.songID = this.songTitle.charAt(0) +"" + this.songArtist.charAt(0);
          this.country = country;
          this.musicVideo = musicVideo;
     }

     public
     Song (String songTitle, String songArtist)
     {
          this.songTitle = songTitle;
          this.songArtist = songArtist;
     }

     public
     Song ()
     {
     }
     
     

   public String getSongTitle ()
   {
      return songTitle;
   }

   public void setSongTitle (String songTitle)
   {
      this.songTitle = songTitle;
   }

   public String getSongArtist ()
   {

      return songArtist;
   }

   public void setSongArtist (String songArtist)
   {
      this.songArtist = songArtist;
   }

   public Genre getGenre ()
   {

      return genre;
   }


   public void setGenre (Genre genre)
   {
      this.genre = genre;
   }

   public int getYear ()
   {

      return year;
   }

   public void setYear (int year)
   {
      this.year = year;
   }

   public double getPrice ()
   {
      return price;
   }

   public void setPrice (double price)
   {
      this.price = price;
   }

   public Explicit getExplicit ()
   {
      return explicit;
   }

   public void setExplicit (Explicit explicit)
   {
      this.explicit = explicit;
   }

   public int getCatalogNumber ()
   {
    
      return catalogNumber;
   }

   public void setCatalogNumber (int catalogNumber)
   {
      this.catalogNumber = catalogNumber;
   }

   public int getPlays ()
   {
      return plays;
   }

   public void setPlays (int plays)
   {
      this.plays = plays;
   }

   public String getAlbumName ()
   {
        if (albumName == null) {
             return "----";
        }
      return albumName;
   }

   public void setAlbumName (String albumName)
   {
      this.albumName = albumName;
   }

   public int getRating ()
   {
      return rating;
   }

   public void setRating (int rating)
   {
      this.rating = rating;
   }

   public String getSize ()
   {
      return size;
   }

   public void setSize (String size)
   {
      this.size = size;
   }

   public String getSongLength ()
   {
      return songLength;
   }

   public void setSongLength (String songLength)
   {
      this.songLength = songLength;
   }

   public String getSongID ()
   {
      return songID;
   }

   public Country getCountry ()
   {
      return country;
   }

   public void setCountry (Country country)
   {
      this.country = country;
   }

   public MusicVideo getMusicVideo ()
   {
      return musicVideo;
   }

   public void setMusicVideo (MusicVideo musicVideo)
   {
      this.musicVideo = musicVideo;
   }
   
      @Override
   public String toString ()
   {
      String song = "";
         song+= getCatalogNumber() + ". ";
         song += getSongTitle() + " - ";
         song += getSongArtist();

      return song;
   }

 private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(getSongTitle());
        out.writeObject(getSongArtist());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.songTitle =((String) in.readObject());
        this.songArtist =((String) in.readObject());
    }
}


