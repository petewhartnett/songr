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


@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

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



// Jerome helped me get the Path Variable to work

    @GetMapping("/capitalize/{test}")
    public String getWords(@PathVariable String test, Model m){

    m.addAttribute("test", test.toUpperCase());
    return "home";
    }




}
