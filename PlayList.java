package com.playMusic;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayList
{
	/**
	 * Declare arrayList of playedSongList
	 */
  private ArrayList<Song> playedSongList;
  
  /**
	 * Declare arrayList of remainingSongList
	 */
  private ArrayList<Song> remainingSongList;
  
  /**
   * Declare Hashmap to store the selected song played and its status either '1' or '0'
   */
  Map<String, Integer> hashMap = new HashMap<>();

  /**
   * 
   * Initialize all 100 songs
   */
  public PlayList()
  {
    playedSongList = new ArrayList<Song>();
  }
  
  /**
   * Method to get Random song from the list
   */
  private Song getRandomSong(){
	  
	  double randomNum = Math.random();
	  int songNo = (int)(randomNum * (remainingSongList.size() - 1));
	  
	  Song song = remainingSongList.get(songNo);
	  removePlayedSong(remainingSongList, songNo);
	  
	  return song;
	  
  }

  /**
   * Method to remove already Played Song
   */
  private void removePlayedSong(ArrayList<Song> remainingSongList, int songNo) {
	  remainingSongList.remove(songNo);
  }
  
  /**
   * 
   * Method to check all song played or not 
   */
  public boolean playedAllSong() {
    if (remainingSongList.isEmpty()) {
      System.out.println("All songs already been Played");
      return true;
    }
    return false;
  }
  
  /**
   * 
   * Logic to check whether same song is being played twice or not
   */
  public void sameSong(Song sameSong, int num) {
    if (num == 1) {
      System.out.println(sameSong.getSongName() + "already played");
      return;
    }
  }
  
  /**
   * Logic to play previous song,validate song then only play it
   * 
   * So that we can track it whether selected song has been played or not
   * 
   */
  public void playPrevSong(Song song) { 
	  Song prevSong = getPreviousSong(song);
	  playSong(prevSong);
	  
  }

  /**
   * Method to get Previous selected Song
   */
private Song getPreviousSong(Song song) {
	int index = playedSongList.indexOf(song);
	  if(index == 0){
		  // TODO no prev songs
	  }
	  Song prevSong = playedSongList.get(index - 1);
	return prevSong;
}
  
  /**
   * 
   * Logic to play the next song if previously not played it
   * 
   * So that we can track it whether selected song has been played or not
   */
  public void playNextSong(Song song)
  {
	  
	  Song nextSong = getNextSong(song);
	  playSong(nextSong);
	  
  }

  /**
   * Method to play next song
   */
private Song getNextSong(Song song) {
	int index = playedSongList.indexOf(song);
	  if(index+2 > playedSongList.size() ) {
		  // TODO no next song
	  }
	  Song nextSong = playedSongList.get(++index);
	return nextSong;
}
  
  /**
   * 
   * Method to play song sequentially
   * Set value integer '1' whenever we are playing song in HashMap
   */
  public void playAllSong(ArrayList<Song> songList)
  {
	  
	  while(playedAllSong()) {
		  Song song = getRandomSong();
		  playSong(song);
	  }
  }

  /**
   * Method to play song
   */

  private void playSong(Song song) {
	  addPlayedSong(song);
	  play(song);
  }


  /**
   * Method to add playedSongList
   */
  private void addPlayedSong(Song song) {
	  
	  if(playedSongList.contains(song)){
		  return;
	  }
	  
	  playedSongList.add(song);
  }
  
  /**
   * 
   * Method to start the song whenever selected
   * Set value integer '1' whenever we are playing song in HashMap
   */
  public void play(Song startSong)
  {
	hashMap.put(startSong.getSongName(),1);
    startSong.setPlay(startSong);
  }
  
  /**
   * 
   * Equals method to compare objects
   * 
   */
  
  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      Song song = (Song) o;
      return song.getPlay()==this.getRandomSong().getPlay();
  }
  
  /**
   * 
   * Method to generate hashcode
   * 
   */
  public int hashCode(){
	  
	  return (int) Math.random();
  }
}