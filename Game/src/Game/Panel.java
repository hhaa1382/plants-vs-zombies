package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel extends JPanel implements ActionListener {
    Timer timer;
    public static ArrayList<Elements> heroes=new ArrayList<>();
    public static ArrayList<Elements> enemies=new ArrayList<>();
    Image back=new ImageIcon("Images\\Backgrounds\\"+StartPage.backGroundName+".jpg").getImage();

    String endMassage=null;

    public Panel(JFrame m){
        timer=new Timer(50,this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D) g;

        g2.drawImage(back,0,0,null);

        if(endMassage==null) {
            for (Elements heroImage : heroes) {
                g2.drawImage(heroImage.getImage(), heroImage.getX(), heroImage.getY(), null);
            }

            for (Elements enemyImage : enemies) {
                g2.drawImage(enemyImage.getImage(), enemyImage.getX(), enemyImage.getY(), null);
            }
        }

        else{
            g2.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 80));
            g2.setPaint(Color.BLACK);
            g2.drawString(endMassage,300,300);
            close();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void close(){
        for(Elements el:heroes){
            el.close();
        }
        for(Elements el:enemies){
            el.close();
        }

        heroes.clear();
        enemies.clear();
        timer.stop();
    }
}
