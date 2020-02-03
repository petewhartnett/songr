
package com.peterhartnett.songr;


import javax.persistence.*;
import java.util.List;


@Entity
    public class Album {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;

//
//        @OneToMany(mappedBy = "album")
//        public List<Song> songs;

   public  String title;
   public String artist;
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

    public long getId(){

        return id;
    }

    public String toString(){

        return String.format (" Title: %s, Artist: %s, Song Count: %d, Length: %d", this.title, this.artist, this.songCount, this.length);
    }

}
