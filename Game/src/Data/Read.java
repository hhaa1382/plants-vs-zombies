package Data;

import Characters.LazyHero;
import Characters.NormalHero;
import Characters.StudyHero;
import Characters.WarriorHero;
import Game.*;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Read {
    private static final String url="jdbc:mysql://localhost/game_project";
    private static final String username="root";
    private static final String password="hhaa1382";

    public static void readHeroSaved() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sql="select * from hero";
        Statement st=connect.prepareStatement(sql);
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){
            Elements el=new Elements(rs.getInt("type"),rs.getInt("positionX"),
                    rs.getInt("positionY"),false);
        }
    }

    public static void readEnemySaved() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sql="select * from enemy";
        Statement st=connect.prepareStatement(sql);
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){
            Elements el=new Elements(rs.getInt("type"),rs.getInt("positionX"),
                    rs.getInt("positionY"),true);
        }
    }

    public static void readSavedGame() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sql="select * from gamesave";
        Statement st=connect.prepareStatement(sql);
        ResultSet rs=st.executeQuery(sql);

        if(rs.next()){
            StartPage.level=rs.getString("level");
            StartPage.backGroundName=rs.getString("backGround");
            Stage.heroPower=rs.getInt("heroPower");
            Stage.numberOfEnemies=rs.getInt("enemyNum");
        }
    }

    public static boolean checkContinue() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sql="select * from gamesave";
        Statement st=connect.prepareStatement(sql);
        ResultSet rs=st.executeQuery(sql);

        if(rs.next()){
            return true;
        }
        else{
            return false;
        }
    }

    public static void readHeroes(DefaultTableModel tm) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sql="select * from characters";
        Statement st=connect.prepareStatement(sql);
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){
            String name=rs.getString("name");
            int power=rs.getInt("power");
            int health=rs.getInt("health");
            int speed=rs.getInt("speed");

            tm.addRow(new String[]{name, String.valueOf(power),String.valueOf(health),String.valueOf(speed)});
        }
    }

    public static int readRemindEnemy() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sql="select * from enemy";
        Statement st=connect.prepareStatement(sql);
        ResultSet rs=st.executeQuery(sql);
        int counter=0;

        while (rs.next()){
            counter++;
        }

        return counter;
    }
}
