package org.superbiz.moviefun.albumsapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {
    Logger logger = LoggerFactory.getLogger(AlbumsClient.class);
    private String albumUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<AlbumInfo>> movieListType =
            new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public AlbumsClient(String albumUrl, RestOperations restOperations) {
        this.albumUrl = albumUrl;
        this.restOperations = restOperations;
    }



    public void addAlbum(AlbumInfo album) {

        logger.info("albums url: {}",albumUrl);
        restOperations.postForEntity(albumUrl, album, AlbumInfo.class);
    }

    public List<AlbumInfo> getAlbums() {
        logger.info("inside getAlbum");

        return restOperations.exchange(albumUrl, GET, null, movieListType).getBody();
    }
}
