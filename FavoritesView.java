    package org.inline;

    import javax.swing.*;
    import java.awt.*;

    public class FavoritesView extends JFrame {
        private DefaultListModel<ImageIcon> listModel;
        private JList<ImageIcon> favoritesList;

        public FavoritesView() {
            setTitle("Favorite Images");
            setSize(800, 600); // Increase the size of the frame
            setLayout(new BorderLayout());

            listModel = new DefaultListModel<>();
            favoritesList = new JList<>(listModel);

            // Set a custom cell renderer to display images
            favoritesList.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    label.setIcon((ImageIcon) value);
                    label.setText(""); // Remove the text, only display the image
                    return label;
                }
            });

            add(new JScrollPane(favoritesList), BorderLayout.CENTER);

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Keep the main window open
        }

        // Add an image to the favorites list with scaled size
        public void addFavorite(String imagePath) {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Scale image to 100x100 pixels
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            listModel.addElement(scaledIcon);
        }

        // Remove an image from the favorites list
        public void removeFavorite(String imagePath) {
            for (int i = 0; i < listModel.getSize(); i++) {
                ImageIcon imageIcon = listModel.getElementAt(i);
                if (imageIcon.getDescription().equals(imagePath)) {
                    listModel.removeElementAt(i);
                    break;
                }
            }
        }

        // Clear all favorites
        public void clearFavorites() {
            listModel.clear();
        }
    }
