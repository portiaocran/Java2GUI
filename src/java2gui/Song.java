package java2gui;
/**
 * @author Portia Ocran
 */
public class Song
{
   private String songTitle;
   private String songArtist;
   private Genre genre;
   private double year;
   private double price;
   private Boolean explicit;
   private Double catalogNumber;
   private int plays;
   private String albumName;
   private int rating;
   private int size;
   private String songLength;
   private double songID;
   private Country country;
   private Boolean musicVideo;

   public Song (String songTitle)
   {
      this.songTitle = songTitle;
   }

   public Song (String songTitle, String songArtist, Genre genre, double year)
   {
      this.songTitle = songTitle;
      this.songArtist = songArtist;
      this.genre = genre;
      this.year = year;
   }

   public Song (String songTitle, String songArtist, String albumName)
   {
      this.songTitle = songTitle;
      this.songArtist = songArtist;
      this.albumName = albumName;
   }

   public Song (String songTitle, String songArtist)
   {
      this.songTitle = songTitle;
      this.songArtist = songArtist;
   }

   public Song (Genre genre)
   {
      this.genre = genre;
   }

   public Song (double year)
   {
      this.year = year;
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

   public double getYear ()
   {

      return year;
   }

   public void setYear (double year)
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

   public Boolean getExplicit ()
   {
      return explicit;
   }

   public void setExplicit (Boolean explicit)
   {
      this.explicit = explicit;
   }

   public Double getCatalogNumber ()
   {
      return catalogNumber;
   }

   public void setCatalogNumber (Double catalogNumber)
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

   public int getSize ()
   {
      return size;
   }

   public void setSize (int size)
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

   public double getSongID ()
   {
      return songID;
   }

   public void setSongID (double songID)
   {
      this.songID = songID;
   }

   public Country getCountry ()
   {
      return country;
   }

   public void setCountry (Country country)
   {
      this.country = country;
   }

   public Boolean getMusicVideo ()
   {
      return musicVideo;
   }

   public void setMusicVideo (Boolean musicVideo)
   {
      this.musicVideo = musicVideo;
   }

}
