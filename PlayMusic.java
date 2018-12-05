package com.playMusic;

import java.util.ArrayList;

/**
 * 
 * @author ravi.gupta
 * Main class from where all method execution will start
 */
public class PlayMusic {
  
  
  public static void main(String[] args) { 
	  
	  
	  PlayList list = new PlayList();
    
   //Default selection method which will run sequentially to play all 100 songs
    list.playAllSong(new ArrayList<Song>(100));
    
    //call previous button method or logic to play the song
    list.playPrevSong(new Song("zxy"));
    
    //call next button methid or logic to play the song
    list.playNextSong(new Song("bbb"));
    
    //method to stop playing song if all 100 songs played
    list.playedAllSong();
  }
}