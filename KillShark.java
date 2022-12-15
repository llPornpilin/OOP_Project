/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Font;
import static javax.swing.text.StyleConstants.Size;
import java.awt.event.*;

public class KillShark implements MouseListener{
    private static JFrame frMonster;
    private JLabel lbCount, lbMonster;
    private ImageIcon imgMonster1, imgMonster2;
    private Clock clock;
    private Thread tClock;
    private static int countdown = 9;
    
    public KillShark(){
        frMonster = new JFrame();
        clock = new Clock();
        tClock = new Thread(clock);
        lbCount = new JLabel("Kill Monster 10 times !");
        imgMonster1 = new ImageIcon("D:\\_second_year\\OOP_Project\\ChefBa\\src\\objects\\liveShark.jpg");
        imgMonster2 = new ImageIcon(imgMonster1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        lbMonster = new JLabel(imgMonster2);
        lbMonster.addMouseListener(this);
        lbCount.setFont(new Font("Arial", 1, 28));
       
        frMonster.setLayout(null);
        Dimension sizeMon = lbMonster.getPreferredSize();
        lbMonster.setBounds(0, 0, sizeMon.width, sizeMon.height);
        
        Dimension sizeCount = lbCount.getPreferredSize();
        lbCount.setBounds(58, 340, sizeCount.width, sizeCount.height);
        
        frMonster.add(clock);
        frMonster.add(lbCount);
        frMonster.add(lbMonster);

        frMonster.setVisible(true);
        frMonster.setSize(415, 430);
        frMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tClock.start();
        
    }
    
    public synchronized void mouseClicked(MouseEvent ev){
        if (countdown > 0){
            lbCount.setText("You remain _" + countdown + "_ times.");
            this.setCountdown(countdown);
            countdown--;
        }
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseExited(MouseEvent m){}
    public void mousePressed(MouseEvent m){}
    public void mouseReleased(MouseEvent m){}
    
    public static int getCountDown(){
        return KillShark.countdown;
    }
    public static void setCountdown(int countdown){
        KillShark.countdown = countdown;
    }
    
    public static JFrame getMonFrame(){
        return KillShark.frMonster;
    }
    public static void setMonFrame(JFrame frMonster){
        KillShark.frMonster = frMonster;
    }
    public static void main(String[] args) {
        new KillShark();
    }
    
}
