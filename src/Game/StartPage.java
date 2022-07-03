package Game;

import Data.Read;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class StartPage extends JFrame {
    ImageIcon icon=new ImageIcon("Images\\wallpaper.jpg");
    JLabel backGround=new JLabel();
    JButton btnExit=new JButton("Exit");
    JButton btnTable=new JButton("Heroes");
    JButton btnNew=new JButton("New Game");
    JButton btnContinue=new JButton("Continue");
    public static String backGroundName=null;
    public static boolean continueCheck;
    public static String level="Easy";

    private static final String path="Musics\\1.wav";
    private static final File musicPath=new File(path);
    private static Clip clip;

    public StartPage() throws LineUnavailableException, SQLException, ClassNotFoundException {
        this.setTitle("Plants Vs Zombies");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(800,620));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        continueCheck=Read.checkContinue();

        backGround.setIcon(icon);
        backGround.setBounds(0,0,800,600);

        btnContinue.setBounds(470,450,200,50);
        btnContinue.setFocusPainted(true);
        btnContinue.setBackground(Color.RED);
        btnContinue.setHorizontalTextPosition(JButton.LEFT);
        btnContinue.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
        btnContinue.setForeground(Color.white);
        btnContinue.setOpaque(true);

        btnNew.setBounds(370,400,100,20);
        btnNew.setFocusPainted(true);
        btnNew.setBackground(Color.RED);
        btnNew.setHorizontalTextPosition(JButton.LEFT);
        btnNew.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,12));
        btnNew.setForeground(Color.white);
        btnNew.setOpaque(true);

        btnTable.setBounds(520,400,100,20);
        btnTable.setFocusPainted(true);
        btnTable.setBackground(Color.RED);
        btnTable.setHorizontalTextPosition(JButton.LEFT);
        btnTable.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,12));
        btnTable.setForeground(Color.white);
        btnTable.setOpaque(true);

        btnExit.setBounds(670,400,100,20);
        btnExit.setFocusPainted(true);
        btnExit.setBackground(Color.RED);
        btnExit.setHorizontalTextPosition(JButton.LEFT);
        btnExit.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,12));
        btnExit.setForeground(Color.white);
        btnExit.setOpaque(true);

        if(continueCheck){
            this.add(btnContinue);
        }
        else{
            btnNew.setBounds(450,450,200,50);
            btnNew.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
            btnTable.setBounds(400,400,100,20);
            btnExit.setBounds(600,400,100,20);
        }

        btnContinue.addActionListener(e -> {
            dispose();
            try {
                Read.readSavedGame();
                Read.readHeroSaved();
                Read.readEnemySaved();
                stopMusic();
                Stage stage=new Stage();
                stage.setIsClicked(false);
                stage.setRemindEnemy(Read.readRemindEnemy());
            }
            catch (ClassNotFoundException | SQLException | UnsupportedAudioFileException |
                    LineUnavailableException | InterruptedException | IOException ex) {
                ex.printStackTrace();
            }
        });

        btnNew.addActionListener(e -> {
            backGroundPart();
        });

        btnTable.addActionListener(e -> {
            try {
                showInfo();
            }
            catch (SQLException | ClassNotFoundException ignore) {
                System.out.println(ignore.getMessage());
            }
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        Thread playMusic=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    playMusic();
                }
                catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
        });
        playMusic.start();

        this.add(btnNew);
        this.add(btnTable);
        this.add(btnExit);
        this.add(backGround);
        this.setVisible(true);
    }

    static void playMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audio = AudioSystem.getAudioInputStream(musicPath);
        clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();
    }

    void stopMusic(){
        clip.stop();
    }

    void showInfo() throws SQLException, ClassNotFoundException {
        JButton btnBack=new JButton("Back");
        JFrame temp=new JFrame();

        temp.setTitle("Heroes");
        temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        temp.setSize(new Dimension(800,200));
        temp.setResizable(false);
        temp.setLocationRelativeTo(null);
        temp.setLayout(null);

        DefaultTableModel tableModel=new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Power");
        tableModel.addColumn("Health");
        tableModel.addColumn("Speed");

        Read.readHeroes(tableModel);

        JTable table=new JTable(tableModel);
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(0,0,800,86);

        btnBack.setBounds(350,100,80,20);
        btnBack.addActionListener(e -> {
            temp.dispose();
        });

        temp.add(scroll);
        temp.add(btnBack);

        temp.setVisible(true);
    }

    void backGroundPart(){
        JComboBox<String> levels=new JComboBox<>(new String[]{"Easy","Medium","Hard"});
        JButton btnBack=new JButton("Back");
        JButton btnOk=new JButton("Ok");
        ImageIcon icon1=new ImageIcon("Images\\Icons\\background_icon1.jpg");
        ImageIcon icon2=new ImageIcon("Images\\Icons\\background_icon2.jpg");
        JButton back1=new JButton(icon1);
        JButton back2=new JButton(icon2);

        ImageIcon icon3=new ImageIcon("Images\\backColor.png");
        JLabel backColor=new JLabel();

        JFrame temp=new JFrame();

        temp.setTitle("Background");
        temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        temp.setSize(new Dimension(800,400));
        temp.setResizable(false);
        temp.setLocationRelativeTo(null);
        temp.setLayout(null);

        backColor.setIcon(icon3);
        backColor.setBounds(0,0,800,400);

        back1.setBounds(50,10,300,148);
        back1.setFocusPainted(true);
        back1.setOpaque(true);
        back1.addActionListener(e -> {
            backGroundName="underground";
        });

        back2.setBounds(400,10,300,148);
        back2.setFocusPainted(true);
        back2.setOpaque(true);
        back2.addActionListener(e -> {
            backGroundName="forest";
        });

        levels.setSelectedIndex(0);
        levels.setBounds(350,200,100,30);

        levels.addActionListener(e -> {
            level= (String) levels.getSelectedItem();
        });

        btnBack.setBounds(300,280,80,20);
        btnOk.setBounds(400,280,80,20);

        btnBack.addActionListener(e -> {
            temp.dispose();
        });
        btnOk.addActionListener(e -> {
            if(backGroundName==null){
                JOptionPane.showMessageDialog(null,"Choose a background!!");
            }
            else {
                continueCheck=false;
                this.dispose();
                stopMusic();
                try {
                    new Stage();
                } catch (UnsupportedAudioFileException | LineUnavailableException |
                        IOException | InterruptedException ignore) {
                }
                temp.dispose();
            }
        });

        temp.add(back1);
        temp.add(back2);
        temp.add(levels);
        temp.add(btnOk);
        temp.add(btnBack);
        temp.add(backColor);

        temp.setVisible(true);
    }
}
