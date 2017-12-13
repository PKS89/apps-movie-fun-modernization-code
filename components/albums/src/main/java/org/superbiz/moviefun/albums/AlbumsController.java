package org.superbiz.moviefun.albums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AlbumsBean albumsBean;


    @GetMapping
    public List<Album> album(){
        logger.info("Inside get Album");
        return albumsBean.getAlbums();
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album){
        albumsBean.addAlbum(album);
    }


}
