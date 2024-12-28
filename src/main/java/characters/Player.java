/**
 * @author Michael Wilson
 * @version 1.0.0
 */

package rpg.src.main.java.characters;

import java.util.Random;

public class Player {
    private final int MIN_GROWTH = 1;
    private final int MAX_GROWTH = 5;
    private String name;
    private int maxHp;
    private int hp;
    private int attack;
    private int defense;
    private int speed;

    public Player(String name) {
        this.setName(name);
        this.createStats();
    }

    public void createStats() {
        this.setMaxHp(getSeed());
        this.setHp(this.maxHp);
        this.setAttack(getSeed());
        this.setDefense(getSeed());
        this.setSpeed(getSeed());
    }
 
    public void setName(String name) {
        this.name = name;        
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getStats() {
        return """
                Name: %s
                Hp: %d/%d
                Attack: %d
                Defense: %d
                Speed: %d
                """.formatted(name, hp, maxHp, attack, defense, speed);
    }

    private int getSeed() {
        Random rn = new Random();
        return rn.nextInt(MAX_GROWTH - MIN_GROWTH + 1) + 1;
    }

}
