package org.inline;

import javax.swing.*;
import java.awt.*;

public class ImageView extends JFrame {
    private JLabel imageLabel;
    private JButton nextButton;
    private JButton prevButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton favoriteButton;
    private JButton viewFavoritesButton;
    private JButton undoButton;
    private JButton redoButton;

    public ImageView() {
        // Set up the main layout
        setLayout(new BorderLayout());

        // Create and configure the image display area
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Panel for the top buttons (Add Image, Add to Favorites, View Favorites)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("Add Image");
        favoriteButton = new JButton("Add to Favorites");
        viewFavoritesButton = new JButton("View Favorites");
        topPanel.add(addButton);
        topPanel.add(favoriteButton);
        topPanel.add(viewFavoritesButton);
        add(topPanel, BorderLayout.NORTH);

        // Panel for the bottom buttons (Previous, Next)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        bottomPanel.add(prevButton);
        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Panel for the right-side buttons (Delete, Undo, Redo)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(10, 1, 5, 5)); // Adjust layout as needed
        deleteButton = new JButton("Delete Image");
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");
        rightPanel.add(deleteButton);
        rightPanel.add(undoButton);
        rightPanel.add(redoButton);
        add(rightPanel, BorderLayout.EAST);

        // Frame configuration
        setTitle("Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setImageIcon(ImageIcon imageIcon) {
        imageLabel.setIcon(imageIcon);
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getPrevButton() {
        return prevButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getFavoriteButton() {
        return favoriteButton;
    }

    public JButton getViewFavoritesButton() {
        return viewFavoritesButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public JButton getRedoButton() {
        return redoButton;
    }
}
