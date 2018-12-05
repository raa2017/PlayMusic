package com.playMusic;

public class Song extends Play
{
	/**
	 * songName to store songName in HashMap
	 */
  private String songName;
  
  
  /**
	 * Initialize constructor
	 */
  public Song(String songName)
  {
    this.songName = songName;
   
  }
  
  public String getSongName() {
    return songName;
  }
  
  public void setSongName(String songName) {
    this.songName = songName;
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
      return song.getPlay()==this.getPlay();
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