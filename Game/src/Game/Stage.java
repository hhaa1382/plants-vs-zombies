package Game;

import Data.Write;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class Stage extends JFrame{
    ImageIcon icon1=new ImageIcon("Images\\Icons\\icon1.png");
    ImageIcon icon2=new ImageIcon("Images\\Icons\\icon2.png");
    ImageIcon icon3=new ImageIcon("Images\\Icons\\icon3.png");
    ImageIcon icon4=new ImageIcon("Images\\Icons\\icon4.png");
    private final JButton hero1=new JButton();
    private final JButton hero2=new JButton();
    private final JButton hero3=new JButton();
    private final JButton hero4=new JButton();

    ImageIcon backIcon=new ImageIcon("Images\\backColor.png");
    JLabel back=new JLabel(backIcon);

    MenuBar bar=new MenuBar();
    Menu menu=new Menu("Menu");
    MenuItem itemLeave=new MenuItem("Leave");
    MenuItem itemSave=new MenuItem("Save");

    static private final Object clickedObj =new Object();
    static private final Object closeObj=new Object();

    int type;
    public static int heroPower=800;
    public static int numberOfEnemies;
    public int enemyReminds;

    static JLabel lblHeroPower=new JLabel("Power : "+heroPower);

    private boolean isClicked=true;
    private boolean clicked=false;

    private static boolean win=false;
    private boolean closed=false;

    private final int width=1000;
    private final int height=850;
    private final int panel_height=600;
    private final int panel_y=30;
    private final int panel_x=0;
    private final int y_Position1=20;
    private final int y_Position2=220;
    private final int y_Position3=410;
    private final int x_Hero_Position=0;
    private final int x_Enemy_Position=950;

    public Stage() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        Panel scene=new Panel(this);
        this.setTitle("Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(width,height));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        if(!StartPage.continueCheck){
            setLevelsEnemy();
        }

        menu.add(itemSave);
        menu.add(itemLeave);
        bar.add(menu);
        this.setMenuBar(bar);

        itemLeave.addActionListener(e ->  {
            try {
                closed=true;
                this.close();
                scene.endMassage="Leave";

                this.dispose();
                new StartPage();
                StartPage.playMusic();
            }
            catch (LineUnavailableException | IOException | UnsupportedAudioFileException |
                    SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        itemSave.addActionListener(e -> {
            try {
                Write.deleteInfo();
                Write.writeAllInfo();
                Write.writeInfoForSave(StartPage.backGroundName);
            }
            catch (SQLException | ClassNotFoundException ignore) {
                System.out.println(ignore.getMessage());
            }
        });

        back.setBounds(0,0,1000,800);

        lblHeroPower.setBounds(10,0,100,30);
        this.add(lblHeroPower);

        hero1.setIcon(icon1);
        hero1.setBounds(104,640,120,140);

        hero1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isClicked) {
                    if(!clicked) {
                        hero1.setBackground(Color.GREEN);
                        clicked = true;
                        type = 1;
                    }

                    else if(type==1){
                        hero1.setBackground(Color.WHITE);
                        clicked = false;
                    }
                }
            }
        });
        this.add(hero1);

        hero2.setIcon(icon2);
        hero2.setBounds(328,640,120,140);

        hero2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isClicked) {
                    if(!clicked) {
                        hero2.setBackground(Color.GREEN);
                        clicked = true;
                        type = 2;
                    }

                    else if(type==2) {
                        hero2.setBackground(Color.WHITE);
                        clicked = false;
                    }
                }
            }
        });
        this.add(hero2);

        hero3.setIcon(icon3);
        hero3.setBounds(552,640,120,140);

        hero3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isClicked) {
                    if (!clicked) {
                        hero3.setBackground(Color.GREEN);
                        clicked = true;
                        type = 3;
                    }

                    else if(type==3) {
                        hero3.setBackground(Color.WHITE);
                        clicked = false;
                    }
                }
            }
        });
        this.add(hero3);

        hero4.setIcon(icon4);
        hero4.setBounds(776,640,120,140);

        hero4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isClicked) {
                    if(!clicked) {
                        hero4.setBackground(Color.GREEN);
                        clicked = true;
                        type = 4;
                    }

                    else if(type==4){
                        hero4.setBackground(Color.WHITE);
                        clicked = false;
                    }
                }
            }
        });
        this.add(hero4);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean check=false;

                if (clicked) {
                    if ((e.getX() > 0 && e.getX() < 820) && (e.getY() > 0 && e.getY() < 270)) {
                        new Elements(type, x_Hero_Position, y_Position1, false);
                        check=true;
                    }

                    else if ((e.getX() > 0 && e.getX() < 820) && (e.getY() > 0 && e.getY() < 470)) {
                        new Elements(type, x_Hero_Position, y_Position2, false);
                        check=true;
                    }

                    else if ((e.getX() > 0 && e.getX() < 820) && (e.getY() > 0 && e.getY() < 650)) {
                        new Elements(type, x_Hero_Position, y_Position3, false);
                        check=true;
                    }

                    if(check){
                        synchronized (clickedObj) {
                            clickedObj.notify();
                        }

                        isClicked = true;
                        clicked = false;
                        setButtonBackground(Color.YELLOW);
                    }
                }
            }
        });

        Thread startGame=new Thread(() -> {
            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Musics\\4.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
                Thread.sleep(4000);
                isClicked = false;
            }
            catch (UnsupportedAudioFileException | LineUnavailableException |
                    IOException | InterruptedException ignore) {}
        });

        if(!StartPage.continueCheck) {
            startGame.start();
        }

        Thread putEnemy=new Thread(() -> {
            try {
                Thread.sleep(4000);
            }
            catch (InterruptedException e) {}

            Random random=new Random();
            int counter=0;

            while (counter<enemyReminds && !closed){
                int type=random.nextInt(4)+1;
                int yType=checkNextEnemy();

                if(yType==0) {
                    yType=random.nextInt(3)+1;
                }

                if (yType == 1) {
                    yType = y_Position1;
                }

                else if (yType == 2) {
                    yType = y_Position2;
                }

                else {
                    yType = y_Position3;
                }

                new Elements(type,x_Enemy_Position,yType,true);
                int time=checkNextEnemy();

                if(time==0){
                    time=random.nextInt(8)+1;
                }
                else{
                    time=1;
                }
                counter++;

                try {
                    Thread.sleep(time*1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        putEnemy.start();

        Thread checkHeroTaken=new Thread(new Runnable() {
            @Override
            public void run() {
                while (!closed) {
                    try {
                        checkClicked();
                    }
                    catch (InterruptedException e) {}
                }
            }
        });
        checkHeroTaken.start();

        Thread closeCheck=new Thread(() ->{
            synchronized (closeObj){
                try {
                    closeObj.wait();
                    if(win){
                        scene.endMassage="You Win!";
                        gameWinSound();
                    }
                    else {
                        scene.endMassage="You Lose!";
                        gameLoseSound();
                    }

                    Write.deleteInfo();

                    Thread.sleep(4000);
                    closed=true;

                    synchronized (clickedObj){
                        clickedObj.notify();
                    }

                    this.close();
                    this.dispose();

                    new StartPage();
                    StartPage.playMusic();
                }
                catch (InterruptedException | UnsupportedAudioFileException | LineUnavailableException
                        | IOException | ClassNotFoundException | SQLException ignore) {
                    System.out.println(ignore.getMessage());
                }
            }
        });
        closeCheck.start();

        this.add(back);
        this.add(scene);
        scene.setBounds(panel_x,panel_y,width,panel_height);
        this.setVisible(true);
    }

    public void setLevelsEnemy(){
        if(StartPage.level.equals("Easy")){
            numberOfEnemies=8;
        }
        else if(StartPage.level.equals("Medium")){
            numberOfEnemies=16;
        }
        else{
            numberOfEnemies=25;
        }
        enemyReminds=numberOfEnemies;
    }

    public void setRemindEnemy(int number){
        enemyReminds=numberOfEnemies;
        enemyReminds-=number;
    }

    public void setIsClicked(boolean isClicked){
        this.isClicked=isClicked;
    }

    void setButtonBackground(Color color){
        hero1.setBackground(color);
        hero2.setBackground(color);
        hero3.setBackground(color);
        hero4.setBackground(color);
    }

    void gameWinSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Musics\\2.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();
    }
    void gameLoseSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Musics\\3.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();
    }

    void close(){
        heroPower=800;
        win=false;
        lblHeroPower.setText("Power = "+heroPower);
    }

    int checkNextEnemy(){
        if(numberOfEnemyInLine(20)<numberOfHeroInLine(20)){
            return 1;
        }
        else if(numberOfEnemyInLine(220)<numberOfHeroInLine(220)){
            return 2;
        }
        else if(numberOfEnemyInLine(410)<numberOfHeroInLine(410)){
            return 3;
        }
        return 0;
    }

    int numberOfEnemyInLine(int line){
        int counter=0;
        for(Elements e:Panel.enemies){
            if(e.getY()==line){
                counter++;
            }
        }
        return counter;
    }

    int numberOfHeroInLine(int line){
        int counter=0;
        for(Elements e:Panel.heroes){
            if(e.getY()==line){
                counter++;
            }
        }
        return counter;
    }

    public static void checkWin(){
        if(numberOfEnemies==0){
            synchronized (closeObj){
                win=true;
                closeObj.notify();
            }
        }
    }

    public static void checkLose(){
        if(heroPower==0){
            synchronized (closeObj){
                closeObj.notify();
            }
        }
    }

    void checkClicked() throws InterruptedException {
        synchronized (clickedObj){
            clickedObj.wait();
            if(!closed) {
                Thread.sleep(4000);
                setButtonBackground(Color.WHITE);
                isClicked = false;
            }
        }
    }
}
