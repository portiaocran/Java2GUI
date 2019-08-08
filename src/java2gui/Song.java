package java2gui;
/**
 * @author Portia Ocran
 */
public class Song
{
   private String songTitle;
   private String songArtist;
   private String albumName;
   private Genre genre;
   private int year;
   private double price;
   private Explicit explicit;
   private int catalogNumber;
   private static int nextCatNum=1;
   private int plays;
   private int rating;
   private String size;
   private String songLength;
   private String songID;
   private Country country;
   private MusicVideo musicVideo;

     public Song (String songTitle, String songArtist, Genre genre, int year, double price, Explicit explicit, String albumName, int rating, String size, String songLength, Country country, MusicVideo musicVideo)
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

   public String toString2 ()
   {
      String song = "";
         song += getSongTitle() + ",";
         song += getSongArtist() + ",";
         if (genre == Genre.BLUES) 
             song+="BLUES" +",";
               else if (genre == Genre.COUNTRY) 
                    song+="COUNTRY" + ",";
                else if (genre == Genre.ROCK) 
                         song+="ROCK" +",";
                      else if (genre == Genre.HIPHOP) 
                          song+="HIPHOP" +",";
                        else if (genre == Genre.RAP) 
                              song+="RAP" + ",";
                          else if (genre == Genre.RNB) 
                                    song+="RNB" + ",";
                              else if (genre == Genre.REGGAE) 
                                              song+="REGGAE" + "," ;
                                         else if (genre == Genre.SOUL) 
                                                            song+="SOUL" + ",";
                                             else if (genre == Genre.FOLK) 
                                                            song+="FOLK" + ",";
                                                      else if (genre == Genre.JAZZ) 
                                                            song+="JAZZ" + ",";
                                                      else if (genre == Genre.CLASSICAL) 
                                                            song+="CLASSICAL" + ",";
                                                      else if (genre == Genre.ELECTRONIC) 
                                                            song+="ELECTRONIC" + ",";
                                                            else if (genre == Genre.POP) 
                                                                  song+="POP" + ",";
                                                                 else if (genre == Genre.FUNK) 
                                                                            song+="FUNK" + ",";
                                                                             else if (genre == Genre.RELIGIOUS) 
                                                                                song+="RELIGIOUS" + ",";
                                                                                     else if (genre == Genre.DANCEHALL) 
                                                                                           song+="DANCEHALL" + ",";
                                                                                               else if (genre == Genre.SOCA) 
                                                                                                    song+="SOCA" + ",";
                                                                                                      else if (genre == Genre.INTERNATIONAL) 
                                                                                                                song+="INTERNATIONAL" + ",";
            song += Integer.toString(year) + ",";
            song += Double.toString(price) + ",";
                if (explicit == Explicit.NO) 
                   song+= "NO" + ",";
                          else song+="YES" + ",";
             
        
            song += albumName + ",";
            song+=Integer.toString(rating) + ",";
            song+=size + ",";
            song+= songLength +",";
            if (country == Country.UNITED_STATES) 
                    song += "UNITED_STATES" + ",";
               else if (country == Country.UNITED_KINGDOM) 
                         song += "UNITED_KINGDOM" + ",";
                    else  if (country == Country.CANADA) 
                         song += "CANADA" + ",";
                         else
                              song+="INTERNATIONAL" +",";
                                if (musicVideo == MusicVideo.NO) 
                                               song+= "NO";
                                         else song+="YES";

      return song;
      
   }

}


