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

public class Clock extends JLabel implements Runnable{
    private int sec = 10;
    private int second;
    private int remainTime;
    private int state = 0;
    
    public void run(){
        try {
            while(sec >= 0){
                Font font = new Font("Arial", Font.BOLD, 25);
                this.setFont(font);
                this.setText(String.format("%02d Seconds", sec));
                Dimension sizeClock = this.getPreferredSize();
                this.setBounds(120, 250, sizeClock.width, sizeClock.height);

                this.setRemainTime(sec);
                if ((this.getRemainTime() >= 0) && (Kill.getCountDown() <= 0)){ // Win Case
                    state = 1;
                    sec = 0;
                    Kill.getMonFrame().setVisible(false);
                    new DeadShark();
                }
                else if ((this.getRemainTime() == 0) && (Kill.getCountDown() > 0)){ // Lost Case
                    state = 2;
                    Kill.getMonFrame().setVisible(false);
                    new DeadShark();
                }
                
                Thread.sleep(1000);
                sec--;
            }
        }
        catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
    }
    
    public synchronized void setRemainTime(int sec){
        this.sec = sec;
    }
    
    public synchronized int getRemainTime(){
        return sec;
    }
    
}
