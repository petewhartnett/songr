
package com.peterhartnett.songr;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


    @Entity
    public class Album {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;
    String title;
    String artist;
    int songCount;
    int length;
    public String url;

    public Album(String title, String artist, int songCount, int length, String url){
    this.title = title;
    this.artist = artist;
    this.songCount = songCount;
     this.length = length;
     this.url = url;

    }

    public Album(){

    }

    public String toString(){

        return String.format (" Title: %s, Artist: %s, Song Count: %d, Length: %d", this.title, this.artist, this.songCount, this.length);
    }

}
