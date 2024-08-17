package org.inline;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.io.File;

public class ImageController {
    private ImageList model;
    private ImageView view;
    private FavoritesView favoritesView;
    private Stack<ImageNode> undoStack;
    private Stack<ImageNode> redoStack;

    public ImageController(ImageList model, ImageView view) {
        this.model = model;
        this.view = view;
        this.favoritesView = new FavoritesView();
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();

        model.addImage("C:\\Workspace\\pro\\Image Viewer\\src\\main\\java\\org\\inline\\images\\new.jpg");
        model.addImage("C:\\Workspace\\pro\\Image Viewer\\src\\main\\java\\org\\inline\\images\\new2.jpg");
        model.addImage("C:\\Workspace\\pro\\Image Viewer\\src\\main\\java\\org\\inline\\images\\new3.jpg");

        updateView();

        view.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.nextImage();
                updateView();
            }
        });

        view.getPrevButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.prevImage();
                updateView();
            }
        });

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    model.addImage(selectedFile.getAbsolutePath());
                    model.nextImage();
                    updateView();
                }
            }
        });

        view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageNode currentImage = model.getCurrentImage();
                if (currentImage != null) {
                    undoStack.push(currentImage); // Push to undo stack
                    redoStack.clear(); // Clear redo stack on new action
                    if (currentImage.isFavorite()) {
                        favoritesView.removeFavorite(currentImage.getImagePath());
                    }
                    model.deleteCurrentImage();
                    updateView();
                }
            }
        });

        view.getFavoriteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageNode currentImage = model.getCurrentImage();
                if (currentImage != null) {
                    if (currentImage.isFavorite()) {
                        currentImage.setFavorite(false);
                        favoritesView.removeFavorite(currentImage.getImagePath());
                    } else {
                        currentImage.setFavorite(true);
                        favoritesView.addFavorite(currentImage.getImagePath());
                    }
                    updateView();
                }
            }
        });

        view.getViewFavoritesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                favoritesView.setVisible(true);
            }
        });

        view.getUndoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!undoStack.isEmpty()) {
                    ImageNode lastDeleted = undoStack.pop();
                    redoStack.push(lastDeleted); // Push to redo stack
                    model.restoreImage(lastDeleted);
                    if (lastDeleted.isFavorite()) {
                        favoritesView.addFavorite(lastDeleted.getImagePath());
                    }
                    updateView();
                }
            }
        });

        view.getRedoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!redoStack.isEmpty()) {
                    ImageNode lastUndo = redoStack.pop();
                    undoStack.push(lastUndo); // Push back to undo stack
                    if (lastUndo.isFavorite()) {
                        favoritesView.removeFavorite(lastUndo.getImagePath());
                    }
                    model.deleteImage(lastUndo);
                    updateView();
                }
            }
        });
    }

    private void updateView() {
        ImageNode currentImageNode = model.getCurrentImage();
        if (currentImageNode != null) {
            ImageIcon imageIcon = new ImageIcon(currentImageNode.getImagePath());
            view.setImageIcon(imageIcon);
        } else {
            view.setImageIcon(null);
        }
    }
}
