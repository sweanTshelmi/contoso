package org.inline;

public class ImageList {
    private ImageNode head;
    private ImageNode tail;
    private ImageNode current;

    public void addImage(String imagePath) {
        ImageNode newNode = new ImageNode(imagePath);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public void deleteCurrentImage() {
        if (current != null) {
            if (current.getPrev() != null) {
                current.getPrev().setNext(current.getNext());
            } else {
                head = current.getNext();
            }

            if (current.getNext() != null) {
                current.getNext().setPrev(current.getPrev());
            } else {
                tail = current.getPrev();
            }

            if (current.getNext() != null) {
                current = current.getNext();
            } else if (current.getPrev() != null) {
                current = current.getPrev();
            } else {
                current = null;
            }
        }
    }

    public void deleteImage(ImageNode node) {
        if (node != null) {
            if (node.getPrev() != null) {
                node.getPrev().setNext(node.getNext());
            } else {
                head = node.getNext();
            }

            if (node.getNext() != null) {
                node.getNext().setPrev(node.getPrev());
            } else {
                tail = node.getPrev();
            }
        }
    }

    public void restoreImage(ImageNode node) {
        if (node != null) {
            if (node.getPrev() != null) {
                node.getPrev().setNext(node);
            } else {
                head = node;
            }

            if (node.getNext() != null) {
                node.getNext().setPrev(node);
            } else {
                tail = node;
            }
        }
    }

    public ImageNode nextImage() {
        if (current != null && current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public ImageNode prevImage() {
        if (current != null && current.getPrev() != null) {
            current = current.getPrev();
        }
        return current;
    }

    public ImageNode getCurrentImage() {
        return current;
    }
}
