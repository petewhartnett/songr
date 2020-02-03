package com.peterhartnett.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


// Research was done at https://spring.io/guides, and also https://www.baeldung.com, and code 401 class 11 demo


@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

//    @Autowired
//    SongRepository songRepository;

    @GetMapping("/hello")
    public String hello(){
    String test = "hello";

    return "home";
}

    @GetMapping("/capitalize")
    public String capitalize(){


        return "home";
    }

    @GetMapping("/album")
    public String getAlbum(Model m){
       // Album testAlbum = new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" );
         //Album[] album = new Album[]{new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" ), new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" ), new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" ),new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" )};
        List<Album>albums = albumRepository.findAll();

       m.addAttribute("albumList", albums);
       //albumRepository.save(testAlbum);
        return "album";
    }


    @PostMapping("/album")
    public RedirectView postAlbum(String title, String artist, int songCount, int length, String url){
        Album album = new Album(title, artist, songCount, length, url);
        albumRepository.save(album);

        return new RedirectView("/album");
    }

    @GetMapping("/album/view/{id}")
    public String getOneAlbum(Model m, @PathVariable long id){
        // Album testAlbum = new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" );
        //Album[] album = new Album[]{new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" ), new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" ), new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" ),new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" )};
        Album albumView = albumRepository.getOne(id);
       // List<Song> songs = songRepository.findAlbum(albumView);
     //   m.addAttribute("songs", songs);

        return "albumview";
    }

    // Code Fellows 401d7 class 13 demo was referenced for the song- album one to many relationship
//    @PostMapping("/song")
//    public String addSong(long id, String title, int length, int trackNumber, Model m){
//      Album album = albumRepository.getOne(id);
//      Song newSong = new Song(title, length, trackNumber, album);
//
//      songRepository.save(newSong);
//        m.addAttribute("album", album);
//
//        return "newSong";
//    }

    @GetMapping("/albumview")
    public String getSongs(Model m){
        // Album testAlbum = new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" );
        //Album[] album = new Album[]{new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" ), new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" ), new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" ),new Album("High Voltage", "ACDC", 12, 4, "http://www.acdc.com/templates/default/images/og_image.jpg" )};
      //  List<Song>song = songRepository.findAll();

       // m.addAttribute("songlist", song);
        //albumRepository.save(testAlbum);
        return "albumview";
    }

    // class 13 demo was referenced for the delete mapping https://github.com/codefellows/seattle-java-401d7/blob/master/class-13/songr/src/main/java/com/ncarignan/songr/HomeController.java
    @PostMapping("/album/delete/{id}")
    public RedirectView deleteAlbum(@PathVariable long id){
        albumRepository.deleteById(id);


        return new RedirectView("/album");
    }



// Jerome helped me get the Path Variable to work

    @GetMapping("/capitalize/{test}")
    public String getWords(@PathVariable String test, Model m){

    m.addAttribute("test", test.toUpperCase());
    return "home";
    }




}
