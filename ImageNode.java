package org.inline;

public class ImageNode {
    private String imagePath;
    private ImageNode next;
    private ImageNode prev;
    private boolean isFavorite; // New attribute to track favorite status

    public ImageNode(String imagePath) {
        this.imagePath = imagePath;
        this.isFavorite = false; // Default is not a favorite
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setNext(ImageNode next) {
        this.next = next;
    }

    public ImageNode getNext() {
        return next;
    }

    public void setPrev(ImageNode prev) {
        this.prev = prev;
    }

    public ImageNode getPrev() {
        return prev;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
