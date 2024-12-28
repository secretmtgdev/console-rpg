/**
 * @author Michael Wilson
 * @version 1.0.0
 */

package rpg.src.main.java;

import rpg.src.main.java.characters.Player;

public class GameManager {
    private static GameManager gameManager_instance = null;
    private Player player;

    private GameManager() {}

    /**
     * @return Singleton instance of this class
     */
    public static synchronized GameManager getInstance() {
        if (gameManager_instance == null) {
            gameManager_instance = new GameManager();
        }

        return gameManager_instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void createPlayer(String name) {
        player = new Player(name);
    }
}
