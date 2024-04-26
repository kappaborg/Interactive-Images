import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InteractiveImageApp extends JFrame implements MouseListener {
    public InteractiveImageApp() {
        setTitle("Interactive Images");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Declare our window width and height as a startup like default.
        setSize(1200, 1200);
        JPanel imagePanel = new JPanel(new FlowLayout());
        //Here we create new icon for image and we declare our image location
        ImageIcon imageIcon = new ImageIcon("/Users/kappasutra/msgA/src/image/jay.jpg"); 
        //Create second image
        ImageIcon imageIcon2 = new ImageIcon("/Users/kappasutra/msgA/src/image/car.jpg");
        //Scaling our image to visualize softly
        Image scaledImage = imageIcon.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);       
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        // Change "sample.jpg" to the path of your image file to the up
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        //We set Jframes and Jbuttons
        JLabel imageLabel = new JLabel(scaledIcon);
        JLabel imageLabel2 = new JLabel(scaledIcon2);
        imageLabel.addMouseListener(this);  
        imageLabel2.addMouseListener(this);  
        imagePanel.add(imageLabel);
        imagePanel.add(imageLabel2);
        imageLabel.setFocusable(true);  
        imageLabel2.setFocusable(true);  
        getContentPane().add(imagePanel, BorderLayout.CENTER); 
            
    }
    public void mouseClicked(MouseEvent e) {
        //Here we listen our mouse clicks by location and will be displayed as a pop message
        JLabel clickedLabel = (JLabel) e.getSource();
        String message = "Image clicked at:" + clickedLabel.getIcon().toString();
        //Creating pop up display message
        JOptionPane.showMessageDialog(this, message, "Clicked Coordinates", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mousePressed(MouseEvent e) {}   
    public void mouseReleased(MouseEvent e) {} 
    public void mouseEntered(MouseEvent e) {} 
    public void mouseExited(MouseEvent e) {}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InteractiveImageApp().setVisible(true);
        });
    }
}
