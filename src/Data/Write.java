package Data;

import Characters.*;
import Game.*;

import java.sql.*;

public class Write {
    private static final String url="jdbc:mysql://localhost/game_project";
    private static final String username="root";
    private static final String password="hhaa1382";

    public static void writeHeroForSave(Elements element, HeroCharacters character) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sql="insert into hero values ("+element.getType()+","+character.getPower()+","+character.getHealth()
                +","+character.getSpeed()+","+element.getX()+","+element.getY()+")";

        Statement st=connect.prepareStatement(sql);
        st.execute(sql);
    }

    public static void writeEnemyForSave(Elements element, EnemyCharacters character) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sql="insert into enemy values ("+element.getType()+","+character.getPower()+","+character.getHealth()
                +","+character.getSpeed()+","+element.getX()+","+element.getY()+")";

        Statement st=connect.prepareStatement(sql);
        st.execute(sql);
    }

    public static void writeAllInfo() throws SQLException, ClassNotFoundException {
        for(Elements el: Panel.heroes){
            writeHeroForSave(el, el.getHeroCharacter());
        }

        for(Elements el: Panel.enemies){
            writeEnemyForSave(el, el.getEnemyCharacter());
        }
    }

    public static void deleteInfo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sqlHero="delete from hero";
        Statement st=connect.prepareStatement(sqlHero);
        st.execute(sqlHero);

        String sqlEnemy="delete from enemy";
        st=connect.prepareStatement(sqlEnemy);
        st.execute(sqlEnemy);

        String sqlInfo="delete from gamesave";
        st=connect.prepareStatement(sqlInfo);
        st.execute(sqlInfo);
    }

    public static void writeInfoForSave(String backGround) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection(url,username,password);

        String sql="insert into gamesave values ('"+StartPage.level+"','"+backGround+"',"+
                Stage.numberOfEnemies+","+Stage.heroPower+")";
        Statement st=connect.prepareStatement(sql);
        st.execute(sql);
    }
}
