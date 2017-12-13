package org.superbiz.moviefun.albums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AlbumServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(AlbumServiceApplication.class, args);
    }


}
