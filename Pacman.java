import java.util.Scanner;

public class Pacman {

    int x = 1, y = 1, width = 5, height = 5;
    int enemyPosX, enemyPosY;
    int score = 0;
    String[][] tabel = new String[width][height];

    Pacman() {
        Scanner in = new Scanner(System.in);
        String a = "";
        System.out.println("INFO: Type quit or exit to exit game");
        while (true) {
            deleteCurrentPos();
            spawnEnemy();
            tabel[x][y] = "C";
            table();
            System.out.println("type: left, right, up, down");
            a = in.next().toLowerCase();
            if (a.equals("quit") || a.equals("exit")) {
                System.out.println("Game ended by user");
                break;
            }

            if (a.equals("left")) {
                moveLeft();
            } else if (a.equals("right")) {
                moveRight();
            } else if (a.equals("up")) {
                moveUp();
            } else if (a.equals("down")) {
                moveDown();
            } else {
                System.out.println("Unknown movement");
                continue;
            }
            if (x >= width && y >= height) {
                System.out.println("Index exceeded limit!");
                continue;
            }
        }
    }

    void spawnEnemy() {
        if (x == enemyPosX && y == enemyPosY) {
            enemyPosX = 0;
            enemyPosY = 0;
            score += 1;
        }
        if (enemyPosX == 0 && enemyPosY == 0) {
            enemyPosX = (int) (Math.random() * (((height - 1) - 0) + 1)) + 0;
            enemyPosY = (int) (Math.random() * (((height - 1) - 0) + 1)) + 0;
            tabel[enemyPosX][enemyPosY] = "O";
            System.out.println("new threat appeared!");
        }
    }

    void deleteCurrentPos() {
        for (int i = 0; i < tabel.length; i++) {
            for (int j = 0; j < tabel[0].length; j++) {
                if (i == enemyPosX && j == enemyPosY) {
                    continue;
                } else {
                    tabel[i][j] = null;
                }

            }
        }
        System.out.println("Score : " + score);
    }

    void table() {
        for (int i = 0; i < tabel.length; i++) {
            for (int j = 0; j < tabel[0].length; j++) {
                if (tabel[i][j] != null) {
                    System.out.print(tabel[i][j]);
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    void moveLeft() {
        if (y >= 0 && y < width) {
            y = y - 1;
        }
    }

    void moveRight() {
        if (y >= 0 && y < width) {
            y = y + 1;
        }
    }

    void moveUp() {
        if (x >= 0 && x < height) {
            x = x - 1;
        }
    }

    void moveDown() {
        if (x >= 0 && x < height) {
            x = x + 1;
        }
    }

    void printPosition() {
        table();
    }

    void debug() {
        System.out.println("X = " + x);
        System.out.println("Y = " + y);
        System.out.println("Width = " + width);
        System.out.println("Height = " + height);
        System.out.printf("\nEnemy position at X: %d | Y: %d\n", enemyPosX, enemyPosY);
    }

    public static void main(String[] args) {
        Pacman start = new Pacman();
    }
}
