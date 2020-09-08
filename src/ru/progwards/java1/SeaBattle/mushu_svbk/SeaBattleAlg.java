package ru.progwards.java1.SeaBattle.mushu_svbk;

import ru.progwards.java1.SeaBattle.SeaBattle;
import ru.progwards.java1.SeaBattle.SeaBattle.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.progwards.java1.SeaBattle.SeaBattle.FireResult.*;

public class SeaBattleAlg {
    private int x;
    private Object Position;
    // Тестовое поле создаётся конструктором
    //     SeaBattle seaBattle = new SeaBattle(true);
    //
    // Обычное поле создаётся конструктором по умолчанию:
    //     SeaBattle seaBattle = new SeaBattle();
    //     SeaBattle seaBattle = new SeaBattle(false);
    //
    // Посомтреть результаты стрельбы можно в любой момент,
    // выведя объект класса SeaBattle на консоль. Например так:
    //     System.out.println(seaBattle);
    //
    //
    // Вид тестового поля:
    //
    //           0 1 2 3 4 5 6 7 8 9    координата x
    //         0|.|.|.|.|.|.|.|X|.|.|
    //         1|.|.|.|.|.|X|.|.|.|.|
    //         2|X|X|.|.|.|.|.|.|.|.|
    //         3|.|.|.|.|.|.|.|X|X|X|
    //         4|.|.|.|.|X|.|.|.|.|.|
    //         5|.|.|.|.|X|.|.|Х|.|.|
    //         6|.|.|.|.|.|.|.|Х|.|X|
    //         7|X|.|X|.|.|.|.|Х|.|X|
    //         8|X|.|.|.|.|.|.|X|.|.|
    //         9|X|.|.|.|X|.|.|.|.|.|

    enum FieldStatus {
        EMPTY,
        MISS,
        HIT,
        DESTROYED,
        UNKNOWN,
        CANTBE
    }

    private static final int MINUS = 0b01;
    private static final int PLUS = 0b10;

    FieldStatus[][] field;// поле боя. " " пустая ячейка (EMPTY), "*" - выстрел мимо (MISS), "х"- попали (HIT), "Х" - убит (DESTROYED)

    SeaBattle seaBattle;
    int direction; //направление стрельбы - плюс/минус
    private List<SeaBattle> battleShips;
    private static boolean shipDetectionMode = false;
    //private ArrayList<Coordinate> detected battleShips;

    int maxX, maxY;
    int[] shipsLeft;
    int maxShip;

    void Field(SeaBattle seaBattle) {
        maxX = seaBattle.getSizeX();
        maxY = seaBattle.getSizeY();
        field = new FieldStatus[maxX][maxY];
        for (int y = 0; y < maxX; y++)
            for (int x = 0; x < maxY; x++)
                field[x][y] = FieldStatus.UNKNOWN;
        shipsLeft = new int[]{0, 4, 3, 2, 1};
        maxShip = 4;
    }

    public void mark(int x, int y, SeaBattle.FireResult fireResult) {
        switch (fireResult) {
            case HIT:
                field[x][y] = FieldStatus.HIT;
                break;
            case DESTROYED:
                markDestroyed(x, y);
                minusShip(x, y);
                break;
            case MISS:
                field[x][y] = FieldStatus.MISS;
                break;
        }
    }

    void init (SeaBattle seaBattle) {
        this.seaBattle = seaBattle;
        field = new FieldStatus[seaBattle.getSizeX()][seaBattle.getSizeY()]; x++;
        Arrays.fill(field[x], FieldStatus.EMPTY);
        battleShips = new ArrayList<>();
        //detected battleShips = new ArrayList<>();
    }
    void  print(boolean doPrint, String str) {
        if (!doPrint)
            return;
        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            str = " | ";
        }
        for (int x = 0; x < seaBattle.getSizeY(); x++) {
            FieldStatus status = field [seaBattle.getSizeX()][seaBattle.getSizeY()];
            if (status == FieldStatus.EMPTY) {
                str += " " + " | ";
            } else
            if (status == FieldStatus.MISS) {
                str += "*" + " | ";
            } else
            if (status == FieldStatus.HIT) {
                str += "x" + " | ";
            } else
            if (status == FieldStatus.DESTROYED) {
                str += "X" + " | ";
            }
        }
    }

    void fireKill(int x, int y) {
        FireResult result = seaBattle.fire(x,y);
        if (result == HIT)
            killShip(x, y);
    }

    private void killShip (int x, int y) {
        boolean destroyd = killVertikal(x,y);
        if (!destroyd)
            killHorizontal(x,y);
    }

    private boolean killHorizontal(int x, int y) {
        SeaBattle.Position LastPosition;
        return true;
    }

    private boolean killVertikal(int x, int y) {
        SeaBattle.Position LastPosition;
        return true;
    }

    void markCantBe(int x, int y) {
        if (x < 0 || y < 0 || x >= maxX || y >= maxY) return;
        if (field[x][y] == FieldStatus.UNKNOWN)
            field[x][y] = FieldStatus.CANTBE;
        else if (field[x][y] == FieldStatus.HIT) {
            markDestroyed(x, y);
        }
    }


    void markDestroyed(int x, int y) {
        field[x][y] = FieldStatus.DESTROYED;
        markCantBe(x - 1, y + 1);
        markCantBe(x + 1, y + 1);
        markCantBe(x - 1, y - 1);
        markCantBe(x + 1, y - 1);
        markCantBe(x - 1, y);
        markCantBe(x + 1, y);
        markCantBe(x, y + 1);
        markCantBe(x, y - 1);
    }

    int getShipSize(int x, int y, int dir) {
        if (x < 0 || y < 0 || x >= maxX || y >= maxY) return 0;
        if (field[x][y] != FieldStatus.DESTROYED) return 0;
        switch (dir) {
            case 0:
                return 1 + getShipSize(x + 1, y, dir);
            case 1:
                return 1 + getShipSize(x - 1, y, dir);
            case 2:
                return 1 + getShipSize(x, y + 1, dir);
            case 3:
                return 1 + getShipSize(x, y - 1, dir);
        }
        return 0;
    }

    int getShipSize(int x, int y) {
        return 1 + getShipSize(x + 1, y, 0) + getShipSize(x - 1, y, 1)
                + getShipSize(x, y + 1, 2) + getShipSize(x, y - 1, 3);
    }

    void minusShip(int x, int y) {
        int s = getShipSize(x, y);
        shipsLeft[s]--;
        if (s == maxShip && shipsLeft[s] == 0) {
            maxShip = 0;
            for (int i = 0; i < shipsLeft.length; i++) if (shipsLeft[i] > 0) maxShip = i;
        }
    }

    boolean isShipsLeft() {
        return maxShip > 0;
    }

    int getMaxShipSize(int x, int y) {
        return maxShip;
    }


    public void battleAlgorithm(SeaBattle seaBattle) {
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
        int hits = 0;
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                FireResult fireResult = seaBattle.fire(x, y);
                if (fireResult != MISS) {
                    hits++;
                }
                if(hits >= 20) {
                    return;
                }
            }
        }

    }
    // функция для отладки
    public static void main(String[] args) {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());
    }

}
