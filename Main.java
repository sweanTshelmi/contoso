package org.inline;

public class Main {
    public static void main(String[] args) {
        ImageList model = new ImageList();
        ImageView view = new ImageView();
        ImageController controller = new ImageController(model, view);

        view.setVisible(true);
    }
}
