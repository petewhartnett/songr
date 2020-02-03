//package com.peterhartnett.songr;
//import javax.persistence.*;
//
//@Entity
//public class Song {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//   public long id;
//
//    @ManyToOne
//    Album album;
//
//    public String title;
//    public int length;
//    public int trackNumber;
//
//    public Song (String title, int length, int trackNumber, Album album){
//
//        this.title = title;
//        this.length = length;
//        this.trackNumber = trackNumber;
//        this.album = album;
//
//    }
//
//    public Song(){
//
//
//    }
//
//     public String toString(){
//
//        return String.format("This is a test of song : %s",title);
//     }
//
//
//
//
//}
