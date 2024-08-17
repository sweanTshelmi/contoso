package org.inline;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private List<String> imagePaths;

    public Album(String name) {
        this.name = name;
        this.imagePaths = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void addImage(String imagePath) {
        imagePaths.add(imagePath);
    }

    public void removeImage(String imagePath) {
        imagePaths.remove(imagePath);
    }
}
