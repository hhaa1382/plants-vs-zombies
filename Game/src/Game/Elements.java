package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Characters.*;

public class Elements extends JPanel implements ActionListener {
    Image image;
    Image heroImage1;
    Image heroImage2;
    Image heroImage3;
    Image heroImage4;
    Image heroImage5;
    Image heroImage6;
    Image heroImage7;
    Image heroImage8;
    Image heroImage9;
    Image heroImage10;

    Image heroFightImage1;
    Image heroFightImage2;
    Image heroFightImage3;
    Image heroFightImage4;
    Image heroFightImage5;
    Image heroFightImage6;
    Image heroFightImage7;
    Image heroFightImage8;
    Image heroFightImage9;
    Image heroFightImage10;

    Image enemyImage1;
    Image enemyImage2;
    Image enemyImage3;
    Image enemyImage4;
    Image enemyImage5;
    Image enemyImage6;
    Image enemyImage7;
    Image enemyImage8;
    Image enemyImage9;
    Image enemyImage10;

    Image enemyFightImage1;
    Image enemyFightImage2;
    Image enemyFightImage3;
    Image enemyFightImage4;
    Image enemyFightImage5;
    Image enemyFightImage6;
    Image enemyFightImage7;
    Image enemyFightImage8;
    Image enemyFightImage9;
    Image enemyFightImage10;

    private int x;
    private final int y;
    private int dis=1;

    private int counter=0;
    private int enemyCounter=0;

    private final Timer timer;

    private final boolean enemy;
    private boolean stop=false;

    private final int type;
    private boolean fighting=false;
    private boolean isFighting=false;

    private HeroCharacters heroCharacter;
    private EnemyCharacters enemyCharacter;

    public Elements(int type,int x,int y,boolean enemy){
        this.type=type;
        this.x=x;
        this.y=y;
        this.enemy=enemy;

        if(enemy){
            enemyCharacter=getEnemyCharacter();
            setEnemyCount();
            setEnemyFightImage();
            setEnemyImage();
            Panel.enemies.add(this);
        }
        else{
            heroCharacter=getHeroCharacter();
            dis*=heroCharacter.getSpeed();
            setHeroImages();
            setHeroFightImages();
            image=heroImage1;
            Panel.heroes.add(this);
        }

        timer=new Timer(50,this);
        timer.start();
    }

    void setEnemyCount(){
        if(StartPage.level.equals("Medium")){
            dis+=1;
        }
        else if(StartPage.level.equals("Hard")){
            dis+=2;
        }
        dis*=(-1)*enemyCharacter.getSpeed();
    }

    void setEnemyImage(){
        if(type==1) {
            enemyImage1 = new ImageIcon("Images\\Enemy1\\e1.0.png").getImage();
            enemyImage2 = new ImageIcon("Images\\Enemy1\\e1.1.png").getImage();
            enemyImage3 = new ImageIcon("Images\\Enemy1\\e1.2.png").getImage();
            enemyImage4 = new ImageIcon("Images\\Enemy1\\e1.3.png").getImage();
            enemyImage5 = new ImageIcon("Images\\Enemy1\\e1.4.png").getImage();
            enemyImage6 = new ImageIcon("Images\\Enemy1\\e1.5.png").getImage();
            enemyImage7 = new ImageIcon("Images\\Enemy1\\e1.6.png").getImage();
            enemyImage8 = new ImageIcon("Images\\Enemy1\\e1.7.png").getImage();
            enemyImage9 = new ImageIcon("Images\\Enemy1\\e1.8.png").getImage();
            enemyImage10 = new ImageIcon("Images\\Enemy1\\e1.9.png").getImage();
        }

        else if(type==2){
            enemyImage1 = new ImageIcon("Images\\Enemy2\\e2.0.png").getImage();
            enemyImage2 = new ImageIcon("Images\\Enemy2\\e2.1.png").getImage();
            enemyImage3 = new ImageIcon("Images\\Enemy2\\e2.2.png").getImage();
            enemyImage4 = new ImageIcon("Images\\Enemy2\\e2.3.png").getImage();
            enemyImage5 = new ImageIcon("Images\\Enemy2\\e2.4.png").getImage();
            enemyImage6 = new ImageIcon("Images\\Enemy2\\e2.5.png").getImage();
            enemyImage7 = new ImageIcon("Images\\Enemy2\\e2.6.png").getImage();
            enemyImage8 = new ImageIcon("Images\\Enemy2\\e2.7.png").getImage();
            enemyImage9 = new ImageIcon("Images\\Enemy2\\e2.8.png").getImage();
            enemyImage10 = new ImageIcon("Images\\Enemy2\\e2.9.png").getImage();
        }

        else if(type==3){
            enemyImage1 = new ImageIcon("Images\\Enemy3\\e3.0.png").getImage();
            enemyImage2 = new ImageIcon("Images\\Enemy3\\e3.1.png").getImage();
            enemyImage3 = new ImageIcon("Images\\Enemy3\\e3.2.png").getImage();
            enemyImage4 = new ImageIcon("Images\\Enemy3\\e3.3.png").getImage();
            enemyImage5 = new ImageIcon("Images\\Enemy3\\e3.4.png").getImage();
            enemyImage6 = new ImageIcon("Images\\Enemy3\\e3.5.png").getImage();
            enemyImage7 = new ImageIcon("Images\\Enemy3\\e3.6.png").getImage();
            enemyImage8 = new ImageIcon("Images\\Enemy3\\e3.7.png").getImage();
            enemyImage9 = new ImageIcon("Images\\Enemy3\\e3.8.png").getImage();
            enemyImage10 = new ImageIcon("Images\\Enemy3\\e3.9.png").getImage();
        }

        else if(type==4){
            enemyImage1 = new ImageIcon("Images\\Enemy4\\e4.0.png").getImage();
            enemyImage2 = new ImageIcon("Images\\Enemy4\\e4.1.png").getImage();
            enemyImage3 = new ImageIcon("Images\\Enemy4\\e4.2.png").getImage();
            enemyImage4 = new ImageIcon("Images\\Enemy4\\e4.3.png").getImage();
            enemyImage5 = new ImageIcon("Images\\Enemy4\\e4.4.png").getImage();
            enemyImage6 = new ImageIcon("Images\\Enemy4\\e4.5.png").getImage();
            enemyImage7 = new ImageIcon("Images\\Enemy4\\e4.6.png").getImage();
            enemyImage8 = new ImageIcon("Images\\Enemy4\\e4.7.png").getImage();
            enemyImage9 = new ImageIcon("Images\\Enemy4\\e4.8.png").getImage();
            enemyImage10 = new ImageIcon("Images\\Enemy4\\e4.9.png").getImage();
        }
    }

    void setHeroImages(){
        if(type==1){
            heroImage1=new ImageIcon("Images\\Hero1\\h1.0.png").getImage();
            heroImage2=new ImageIcon("Images\\Hero1\\h1.1.png").getImage();
            heroImage3=new ImageIcon("Images\\Hero1\\h1.2.png").getImage();
            heroImage4=new ImageIcon("Images\\Hero1\\h1.3.png").getImage();
            heroImage5=new ImageIcon("Images\\Hero1\\h1.4.png").getImage();
            heroImage6=new ImageIcon("Images\\Hero1\\h1.5.png").getImage();
            heroImage7=new ImageIcon("Images\\Hero1\\h1.6.png").getImage();
            heroImage8=new ImageIcon("Images\\Hero1\\h1.7.png").getImage();
            heroImage9=new ImageIcon("Images\\Hero1\\h1.8.png").getImage();
            heroImage10=new ImageIcon("Images\\Hero1\\h1.9.png").getImage();
        }
        else if(type==2){
            heroImage1=new ImageIcon("Images\\Hero2\\h2.0.png").getImage();
            heroImage2=new ImageIcon("Images\\Hero2\\h2.1.png").getImage();
            heroImage3=new ImageIcon("Images\\Hero2\\h2.2.png").getImage();
            heroImage4=new ImageIcon("Images\\Hero2\\h2.3.png").getImage();
            heroImage5=new ImageIcon("Images\\Hero2\\h2.4.png").getImage();
            heroImage6=new ImageIcon("Images\\Hero2\\h2.5.png").getImage();
            heroImage7=new ImageIcon("Images\\Hero2\\h2.6.png").getImage();
            heroImage8=new ImageIcon("Images\\Hero2\\h2.7.png").getImage();
            heroImage9=new ImageIcon("Images\\Hero2\\h2.8.png").getImage();
            heroImage10=new ImageIcon("Images\\Hero2\\h2.9.png").getImage();
        }
        else if(type==3){
            heroImage1=new ImageIcon("Images\\Hero3\\h3.0.png").getImage();
            heroImage2=new ImageIcon("Images\\Hero3\\h3.1.png").getImage();
            heroImage3=new ImageIcon("Images\\Hero3\\h3.2.png").getImage();
            heroImage4=new ImageIcon("Images\\Hero3\\h3.3.png").getImage();
            heroImage5=new ImageIcon("Images\\Hero3\\h3.4.png").getImage();
            heroImage6=new ImageIcon("Images\\Hero3\\h3.5.png").getImage();
            heroImage7=new ImageIcon("Images\\Hero3\\h3.6.png").getImage();
            heroImage8=new ImageIcon("Images\\Hero3\\h3.7.png").getImage();
            heroImage9=new ImageIcon("Images\\Hero3\\h3.8.png").getImage();
            heroImage10=new ImageIcon("Images\\Hero3\\h3.9.png").getImage();
        }
        else if(type==4){
            heroImage1=new ImageIcon("Images\\Hero4\\h4.0.png").getImage();
            heroImage2=new ImageIcon("Images\\Hero4\\h4.1.png").getImage();
            heroImage3=new ImageIcon("Images\\Hero4\\h4.2.png").getImage();
            heroImage4=new ImageIcon("Images\\Hero4\\h4.3.png").getImage();
            heroImage5=new ImageIcon("Images\\Hero4\\h4.4.png").getImage();
            heroImage6=new ImageIcon("Images\\Hero4\\h4.5.png").getImage();
            heroImage7=new ImageIcon("Images\\Hero4\\h4.6.png").getImage();
            heroImage8=new ImageIcon("Images\\Hero4\\h4.7.png").getImage();
            heroImage9=new ImageIcon("Images\\Hero4\\h4.8.png").getImage();
            heroImage10=new ImageIcon("Images\\Hero4\\h4.9.png").getImage();
        }
    }

    void setEnemyFightImage(){
        if(type==1){
            enemyFightImage1=new ImageIcon("Images\\Enemy1\\e1.10.png").getImage();
            enemyFightImage2=new ImageIcon("Images\\Enemy1\\e1.11.png").getImage();
            enemyFightImage3=new ImageIcon("Images\\Enemy1\\e1.12.png").getImage();
            enemyFightImage4=new ImageIcon("Images\\Enemy1\\e1.13.png").getImage();
            enemyFightImage5=new ImageIcon("Images\\Enemy1\\e1.14.png").getImage();
            enemyFightImage6=new ImageIcon("Images\\Enemy1\\e1.15.png").getImage();
            enemyFightImage7=new ImageIcon("Images\\Enemy1\\e1.16.png").getImage();
            enemyFightImage8=new ImageIcon("Images\\Enemy1\\e1.17.png").getImage();
            enemyFightImage9=new ImageIcon("Images\\Enemy1\\e1.18.png").getImage();
            enemyFightImage10=new ImageIcon("Images\\Enemy1\\e1.19.png").getImage();
        }
        else if(type==2){
            enemyFightImage1=new ImageIcon("Images\\Enemy2\\e2.10.png").getImage();
            enemyFightImage2=new ImageIcon("Images\\Enemy2\\e2.11.png").getImage();
            enemyFightImage3=new ImageIcon("Images\\Enemy2\\e2.12.png").getImage();
            enemyFightImage4=new ImageIcon("Images\\Enemy2\\e2.13.png").getImage();
            enemyFightImage5=new ImageIcon("Images\\Enemy2\\e2.14.png").getImage();
            enemyFightImage6=new ImageIcon("Images\\Enemy2\\e2.15.png").getImage();
            enemyFightImage7=new ImageIcon("Images\\Enemy2\\e2.16.png").getImage();
            enemyFightImage8=new ImageIcon("Images\\Enemy2\\e2.17.png").getImage();
            enemyFightImage9=new ImageIcon("Images\\Enemy2\\e2.18.png").getImage();
            enemyFightImage10=new ImageIcon("Images\\Enemy2\\e2.19.png").getImage();
        }
        else if(type==3){
            enemyFightImage1=new ImageIcon("Images\\Enemy3\\e3.10.png").getImage();
            enemyFightImage2=new ImageIcon("Images\\Enemy3\\e3.11.png").getImage();
            enemyFightImage3=new ImageIcon("Images\\Enemy3\\e3.12.png").getImage();
            enemyFightImage4=new ImageIcon("Images\\Enemy3\\e3.13.png").getImage();
            enemyFightImage5=new ImageIcon("Images\\Enemy3\\e3.14.png").getImage();
            enemyFightImage6=new ImageIcon("Images\\Enemy3\\e3.15.png").getImage();
            enemyFightImage7=new ImageIcon("Images\\Enemy3\\e3.16.png").getImage();
            enemyFightImage8=new ImageIcon("Images\\Enemy3\\e3.17.png").getImage();
            enemyFightImage9=new ImageIcon("Images\\Enemy3\\e3.18.png").getImage();
            enemyFightImage10=new ImageIcon("Images\\Enemy3\\e3.19.png").getImage();
        }
        else if(type==4){
            enemyFightImage1=new ImageIcon("Images\\Enemy4\\e4.10.png").getImage();
            enemyFightImage2=new ImageIcon("Images\\Enemy4\\e4.11.png").getImage();
            enemyFightImage3=new ImageIcon("Images\\Enemy4\\e4.12.png").getImage();
            enemyFightImage4=new ImageIcon("Images\\Enemy4\\e4.13.png").getImage();
            enemyFightImage5=new ImageIcon("Images\\Enemy4\\e4.14.png").getImage();
            enemyFightImage6=new ImageIcon("Images\\Enemy4\\e4.15.png").getImage();
            enemyFightImage7=new ImageIcon("Images\\Enemy4\\e4.16.png").getImage();
            enemyFightImage8=new ImageIcon("Images\\Enemy4\\e4.17.png").getImage();
            enemyFightImage9=new ImageIcon("Images\\Enemy4\\e4.18.png").getImage();
            enemyFightImage10=new ImageIcon("Images\\Enemy4\\e4.19.png").getImage();
        }
    }

    void setHeroFightImages(){
        if(type==1){
            heroFightImage1=new ImageIcon("Images\\Hero1\\h1.10.png").getImage();
            heroFightImage2=new ImageIcon("Images\\Hero1\\h1.11.png").getImage();
            heroFightImage3=new ImageIcon("Images\\Hero1\\h1.12.png").getImage();
            heroFightImage4=new ImageIcon("Images\\Hero1\\h1.13.png").getImage();
            heroFightImage5=new ImageIcon("Images\\Hero1\\h1.14.png").getImage();
            heroFightImage6=new ImageIcon("Images\\Hero1\\h1.15.png").getImage();
            heroFightImage7=new ImageIcon("Images\\Hero1\\h1.16.png").getImage();
            heroFightImage8=new ImageIcon("Images\\Hero1\\h1.17.png").getImage();
            heroFightImage9=new ImageIcon("Images\\Hero1\\h1.18.png").getImage();
            heroFightImage10=new ImageIcon("Images\\Hero1\\h1.19.png").getImage();
        }
        else if(type==2){
            heroFightImage1=new ImageIcon("Images\\Hero2\\h2.10.png").getImage();
            heroFightImage2=new ImageIcon("Images\\Hero2\\h2.11.png").getImage();
            heroFightImage3=new ImageIcon("Images\\Hero2\\h2.12.png").getImage();
            heroFightImage4=new ImageIcon("Images\\Hero2\\h2.13.png").getImage();
            heroFightImage5=new ImageIcon("Images\\Hero2\\h2.14.png").getImage();
            heroFightImage6=new ImageIcon("Images\\Hero2\\h2.15.png").getImage();
            heroFightImage7=new ImageIcon("Images\\Hero2\\h2.16.png").getImage();
            heroFightImage8=new ImageIcon("Images\\Hero2\\h2.17.png").getImage();
            heroFightImage9=new ImageIcon("Images\\Hero2\\h2.18.png").getImage();
            heroFightImage10=new ImageIcon("Images\\Hero2\\h2.19.png").getImage();
        }
        else if(type==3){
            heroFightImage1=new ImageIcon("Images\\Hero3\\h3.10.png").getImage();
            heroFightImage2=new ImageIcon("Images\\Hero3\\h3.11.png").getImage();
            heroFightImage3=new ImageIcon("Images\\Hero3\\h3.12.png").getImage();
            heroFightImage4=new ImageIcon("Images\\Hero3\\h3.13.png").getImage();
            heroFightImage5=new ImageIcon("Images\\Hero3\\h3.14.png").getImage();
            heroFightImage6=new ImageIcon("Images\\Hero3\\h3.15.png").getImage();
            heroFightImage7=new ImageIcon("Images\\Hero3\\h3.16.png").getImage();
            heroFightImage8=new ImageIcon("Images\\Hero3\\h3.17.png").getImage();
            heroFightImage9=new ImageIcon("Images\\Hero3\\h3.18.png").getImage();
            heroFightImage10=new ImageIcon("Images\\Hero3\\h3.19.png").getImage();
        }
        else if(type==4){
            heroFightImage1=new ImageIcon("Images\\Hero4\\h4.10.png").getImage();
            heroFightImage2=new ImageIcon("Images\\Hero4\\h4.11.png").getImage();
            heroFightImage3=new ImageIcon("Images\\Hero4\\h4.12.png").getImage();
            heroFightImage4=new ImageIcon("Images\\Hero4\\h4.13.png").getImage();
            heroFightImage5=new ImageIcon("Images\\Hero4\\h4.14.png").getImage();
            heroFightImage6=new ImageIcon("Images\\Hero4\\h4.15.png").getImage();
            heroFightImage7=new ImageIcon("Images\\Hero4\\h4.16.png").getImage();
            heroFightImage8=new ImageIcon("Images\\Hero4\\h4.17.png").getImage();
            heroFightImage9=new ImageIcon("Images\\Hero4\\h4.18.png").getImage();
            heroFightImage10=new ImageIcon("Images\\Hero4\\h4.19.png").getImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(enemy) {
            isFighting=checkEnemyFighting();
            if(!isFighting){
                if(enemyCounter==0) {
                    stop = checkEnemyDistance();
                }

                if(!stop) {
                    int index = Panel.enemies.indexOf(this);

                    if (this.x < 60) {
                        Stage.heroPower-=1;
                        Stage.lblHeroPower.setText("Power : "+Stage.heroPower);
                        Stage.checkLose();
                        counter=7;
                        dis = 0;
                    }
                    this.x = this.x + dis;

                    if (counter == 0) {
                        image = enemyImage1;
                        counter++;
                    }
                    else if (counter == 1) {
                        image = enemyImage2;
                        counter++;
                    }
                    else if (counter == 2) {
                        image = enemyImage3;
                        counter++;
                    }
                    else if (counter == 3) {
                        image = enemyImage4;
                        counter++;
                    }
                    else if (counter == 4) {
                        image = enemyImage5;
                        counter++;
                    }
                    else if (counter == 5) {
                        image = enemyImage6;
                        counter++;
                    }
                    else if (counter == 6) {
                        image = enemyImage7;
                        counter++;
                    }
                    else if (counter == 7) {
                        image = enemyImage8;
                        counter++;
                    }
                    else if (counter == 8) {
                        image = enemyImage9;
                        counter++;
                    }
                    else if (counter == 9) {
                        image = enemyImage10;
                        counter = 0;
                    }

                    Panel.enemies.remove(index);
                    Panel.enemies.add(index, this);
                }

                else{
                    image=enemyImage8;
                    int counterCheck=enemyCounter%10;

                    if(counterCheck==0){
                        image=enemyFightImage1;
                        enemyCounter++;
                    }

                    else if(counterCheck==1){
                        image=enemyFightImage2;
                        enemyCounter++;
                    }

                    else if(counterCheck==2){
                        image=enemyFightImage3;
                        enemyCounter++;
                    }

                    else if(counterCheck==3){
                        image=enemyFightImage4;
                        enemyCounter++;
                    }

                    else if(counterCheck==4){
                        image=enemyFightImage5;
                        enemyCounter++;
                    }

                    else if(counterCheck==5){
                        image=enemyFightImage6;
                        enemyCounter++;
                    }

                    else if(counterCheck==6){
                        image=enemyFightImage7;
                        enemyCounter++;
                    }

                    else if(counterCheck==7){
                        image=enemyFightImage8;
                        enemyCounter++;
                    }

                    else if(counterCheck==8){
                        image=enemyFightImage9;
                        enemyCounter++;
                    }

                    else if(counterCheck==9){
                        image=enemyFightImage10;
                        enemyCounter++;
                    }

                    if(enemyCounter==20){
                        if(enemyCharacter.getHealth()<=0) {
                            Panel.enemies.remove(this);
                            Stage.numberOfEnemies--;
                            Stage.checkWin();
                            timer.stop();
                        }
                        else{
                            fighting=false;
                            enemyCounter=0;
                        }
                    }
                }
                if(enemyCounter==0 && enemyCharacter.getHealth()<=0){
                    Panel.enemies.remove(this);
                    Stage.numberOfEnemies--;
                    Stage.checkWin();
                    timer.stop();
                }
            }
            else{
                image=enemyImage8;
            }
        }

        else{
            isFighting=checkHeroFighting();
            if(!isFighting) {
                if (enemyCounter == 0) {
                    stop = checkHeroDistance();
                }

                if (!stop) {
                    int index = Panel.heroes.indexOf(this);

                    if (this.x >= 1000 - image.getWidth(null)-60) {
                        counter=7;
                        dis = 0;
                    }
                    this.x = this.x + dis;

                    if (counter == 0) {
                        image = heroImage1;
                        counter++;
                    }
                    else if (counter == 1) {
                        image = heroImage2;
                        counter++;
                    }
                    else if (counter == 2) {
                        image = heroImage3;
                        counter++;
                    }
                    else if (counter == 3) {
                        image = heroImage4;
                        counter++;
                    }
                    else if (counter == 4) {
                        image = heroImage5;
                        counter++;
                    }
                    else if (counter == 5) {
                        image = heroImage6;
                        counter++;
                    }
                    else if (counter == 6) {
                        image = heroImage7;
                        counter++;
                    }
                    else if (counter == 7) {
                        image = heroImage8;
                        counter++;
                    }
                    else if (counter == 8) {
                        image = heroImage9;
                        counter++;
                    }
                    else if (counter == 9) {
                        image = heroImage10;
                        counter = 0;
                    }

                    Panel.heroes.remove(index);
                    Panel.heroes.add(index, this);
                }
                else {
                    image = heroImage8;
                    int counterCheck=enemyCounter%10;

                    if(counterCheck==0){
                        image=heroFightImage1;
                        enemyCounter++;
                    }

                    else if(counterCheck==1){
                        image=heroFightImage2;
                        enemyCounter++;
                    }

                    else if(counterCheck==2){
                        image=heroFightImage3;
                        enemyCounter++;
                    }

                    else if(counterCheck==3){
                        image=heroFightImage4;
                        enemyCounter++;
                    }

                    else if(counterCheck==4){
                        image=heroFightImage5;
                        enemyCounter++;
                    }

                    else if(counterCheck==5){
                        image=heroFightImage6;
                        enemyCounter++;
                    }

                    else if(counterCheck==6){
                        image=heroFightImage7;
                        enemyCounter++;
                    }

                    else if(counterCheck==7){
                        image=heroFightImage8;
                        enemyCounter++;
                    }

                    else if(counterCheck==8){
                        image=heroFightImage9;
                        enemyCounter++;
                    }

                    else if(counterCheck==9){
                        image=heroFightImage10;
                        enemyCounter++;
                    }

                    if (enemyCounter == 20) {
                        if (heroCharacter.getHealth() <= 0) {
                            Panel.heroes.remove(this);
                            timer.stop();
                        }
                        else {
                            fighting = false;
                            enemyCounter = 0;
                        }
                    }
                }
                if (enemyCounter == 0 && heroCharacter.getHealth() <= 0) {
                    Panel.heroes.remove(this);
                    timer.stop();
                }
            }

            else{
                image=heroImage8;
            }
        }
    }

    public HeroCharacters getHeroCharacter(){
        if(type==1){
            return new NormalHero();
        }

        else if(type==2){
            return new StudyHero();
        }

        else if(type==3){
            return new LazyHero();
        }

        else{
            return new WarriorHero();
        }
    }

    public EnemyCharacters getEnemyCharacter(){
        if(type==1){
            return new NormalEnemy();
        }

        else if(type==2){
            return new IceEnemy();
        }

        else if(type==3){
            return new SpeedEnemy();
        }

        else{
            return new WarriorEnemy();
        }
    }

    public boolean checkHeroDistance(){
        ArrayList<Elements> enemies=new ArrayList<>();

        for(Elements e:Panel.enemies){
            if(e.enemy && this.y==e.y){
                enemies.add(e);
            }
        }

        for(Elements e1:enemies){
            if(e1.x-this.x<100){
                int enemyPower = e1.getEnemyCharacter().getPower();
                int heroHealth = heroCharacter.getHealth();
                heroHealth -=enemyPower;

                heroCharacter.setHealth(heroHealth);
                fighting=true;
                return true;
            }
        }
        return false;
    }

    public boolean checkEnemyDistance(){
        ArrayList<Elements> heroes=new ArrayList<>();

        for(Elements e: Panel.heroes){
            if(!e.enemy && this.y==e.y){
                heroes.add(e);
            }
        }

        for(Elements e1:heroes){
            if(this.x-e1.x<100){
                int heroPower = e1.getHeroCharacter().getPower();
                int enemyHealth = enemyCharacter.getHealth();
                enemyHealth -=heroPower;

                enemyCharacter.setHealth(enemyHealth);
                fighting=true;
                return true;
            }
        }
        return false;
    }

    public boolean checkEnemyFighting(){
        ArrayList<Elements> enemies=new ArrayList<>();

        for(Elements e: Panel.enemies){
            if(e.enemy && this.y==e.y && e!=this && e.fighting){
                enemies.add(e);
            }
        }

        for(Elements e1:enemies){
            if(this.x-e1.x<100){
                return true;
            }
        }
        return false;
    }

    public boolean checkHeroFighting(){
        ArrayList<Elements> heroes=new ArrayList<>();

        for(Elements e: Panel.heroes){
            if(!e.enemy && this.y==e.y && e!=this && e.fighting){
                heroes.add(e);
            }
        }

        for(Elements e1:heroes){
            if(e1.x-this.x<100){
                return true;
            }
        }
        return false;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

    public void close(){
        this.timer.stop();
    }
}
