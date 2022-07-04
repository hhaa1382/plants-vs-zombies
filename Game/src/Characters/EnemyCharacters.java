package Characters;

public class EnemyCharacters {
    private String name;
    private int power;
    private int health;
    private int speed;

    public EnemyCharacters(String name, int power, int health, int speed) {
        this.name=name;
        this.power = power;
        this.health = health;
        this.speed = speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }
}
