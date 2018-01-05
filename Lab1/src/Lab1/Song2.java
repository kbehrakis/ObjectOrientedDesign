package Lab1;

import tester.*;
class Song2 {
  String title ;
  int lenInSeconds ;  // duration of the song
  Album onAlbum;
 
  Song2 (String title, Integer lenInSeconds, Album onAlbum) {
    this.title = title ;
    this.lenInSeconds = lenInSeconds;
    this.onAlbum = onAlbum;
  }
}

class SongExamples {
SongExamples () {};

Song2 song1 = new Song2("Rock Song", 240, new Album ("Artist1", "Rock"));
Song2 song2 = new Song2("Pop Song", 180, new Album ("Artist2", "Country"));
}

class Album {
	 String artist ;
	 String genre ;
	 
	 	Album (String artist, String genre) {
	      this.artist = artist ;
	      this.genre = genre ; 
	      }
}

/* 3.1
What errors do you see? 
In the Album class, there isn't a "this." before genre. 

What do you have to remember about programming in Java to avoid these mistakes?
It is important to remember what you need to 'save' using "this."

What error messages does Java produce for these mistakes? 
(run the code to find out – the errors don’t always make sense, 
but this exercise is designed to help you recognize having seen 
these messages before, in case they arise again in your own work).

Some of the errors were that the variables were not defined for the given class
(i.e. in the Example class).  It said that the variables could not be resolved.

*/


/* Code from code review

import tester.*;

class Song {
  String title ;
  int lenInSeconds ;  
  Album onAlbum;
 
  Song (String title, Integer lenInSeconds, Album on) {
    this.title = title ;
    this.lenInSeconds = lenInSeconds ;
    this.onAlbum = on;
  }
  
  // detemines whether two songs are on the same album
  boolean onSameAlbum(Song song1, Song song2) {
    return (song1.onAlbum == song2.onAlbum);
  }
  
}

class Album {
  String artist;
  String genre;
  
  Album(String artist, String genre) {
    this.artist = artist;
    genre = genre;
  }
  
  // determines whether album's genre is "rock"
  boolean hasRockMusic() {
    return genre.equals("rock");
  }
}

class Examples {
  
  Examples() {}
    
  marsalbum = new Album("Best of Mars", "rock");
  song1 = new Song("Curiosity", 165, marsalbum);
  song2 = new Song("Roving Around", 134, new Album("Best of Mars", "rock"));
  
  boolean test1 (Tester t) {
    return t.checkExpect(song1.onSameAlbum(song1, song2), true);
  }
  
  boolean test2 (Tester t) {
    return t.checkExpect(album1.hasRockMusic(), true);
  }


}

*/