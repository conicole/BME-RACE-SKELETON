import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nicole on 08/05/2015.
 */
public class startTimer extends JPanel implements ActionListener {


    private Timer declencheur;
    private Font font;
    private int size;
    private int time;
    private String txt="";
    static int STARTSIZE = 30;
    private int width = this.getWidth();
    private boolean blockGame = true;

    public startTimer(){
        declencheur = new Timer(50, this);
        declencheur.start();
        size = STARTSIZE;
        font = new Font("Arial",Font.BOLD,size);
        this.setOpaque(false);
        time = 0;

    }

    public void updateText(){
        switch(time){
            case 0:
                txt= "READY ?";
                break;
            case 20:
                size = STARTSIZE;
                txt = "";
                break;
            case 30 :
                txt = "3";
                break;
            case 50:
                size=STARTSIZE;
                txt = "";
                break;
            case 60:
                txt = "2";
                break;
            case 80:
                size=STARTSIZE;
                txt = "";
                break;
            case 90:
                txt = "1";
                break;
            case 110:
                size = STARTSIZE;
                txt = "";
                break;
            case 120:
                txt = "GO !";
                blockGame = false;
                break;
            case 140:
                txt ="";
                declencheur.stop();
                break;
        }
      //  System.out.println(txt + " " + time);
    }

    public void updateWidth(){
        if(time < 20){
            width = (this.getWidth()/2)-(size*2);
        }
        else if(time < 120){
            width = this.getWidth()/2 - (size/4);
        }
        else{
            width = this.getWidth()/2 - size;
        }
    }


    public void WaitEndTimer(){
        while( declencheur.isRunning() );
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(txt,width ,this.getHeight()/2);
    }

    public void actionPerformed(ActionEvent e) {
        size += 3;
        font = new Font("Arial",Font.BOLD,size);
        updateText();
        updateWidth();
  //      System.out.println(width);
        time++;
        validate();
        repaint();
    }
}
