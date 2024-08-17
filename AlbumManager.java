package org.inline;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AlbumManager {
    private Map<String, Album> albums;

    public AlbumManager() {
        this.albums = new HashMap<>();
    }

    public void createAlbum(String name) {
        if (!albums.containsKey(name)) {
            albums.put(name, new Album(name));
        }
    }

    public void deleteAlbum(String name) {
        albums.remove(name);
    }

    public Album getAlbum(String name) {
        return albums.get(name);
    }

    public Set<String> getAlbumNames() {
        return albums.keySet();
    }

    public void addImageToAlbum(String albumName, String imagePath) {
        Album album = albums.get(albumName);
        if (album != null) {
            album.addImage(imagePath);
        }
    }

    public void removeImageFromAlbum(String albumName, String imagePath) {
        Album album = albums.get(albumName);
        if (album != null) {
            album.removeImage(imagePath);
        }
    }

    public Map<String, Album> getAllAlbums() {
        return albums;
    }
}
