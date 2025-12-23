package Assignment6;

/**
 * Extended board for NxN Tic-Tac-Toe with custom win condition
 * Reuses the original Board class through inheritance
 */
public class ExtendedBoard extends Board {

    private final int winCondition;

    public ExtendedBoard(int size, int winCondition) {

        this.winCondition = winCondition;
        initializeCustomBoard(size);

    }

    private void initializeCustomBoard(int size) {

        try {
            
            java.lang.reflect.Field sizeField = Board.class.getDeclaredField("size");
            java.lang.reflect.Field gridField = Board.class.getDeclaredField("grid");

            sizeField.setAccessible(true);
            gridField.setAccessible(true);

            sizeField.set(this,size);
            gridField.set(this, new char[size][size]);

            initializeGrid(size);

        } catch (Exception e) {

            System.err.println("Error initializing extended board: " + e.getMessage());
        }
    }

    private void initializeGrid(int size) {

        try {
            
            java.lang.reflect.Field gridField = Board.class.getDeclaredField("grid");
            gridField.setAccessible(true);
            char[][] grid = (char[][]) gridField.get(this);

            for (int r = 0; r < size; r++) {

                for (int c = 0; c < size; c++) {

                    grid[r][c] = '-';

                }
            }

        } catch (Exception e) {

            System.err.println("Error initializing grid: " + e.getMessage());

        }
    }

    @Override
    public boolean checkWin(char symbol) {

        int size= getSize();

        for (int r = 0; r <= size - winCondition; r++) {

            for (int c = 0; c <= size - winCondition; c++) {

                if (checkConsecutive(r, c, 0, 1, symbol)) {

                    return true;

                }
            }
        }

        for (int c = 0; c < size; c++) {

            for (int r = 0; r <= size - winCondition; r++) {

                if (checkConsecutive(r, c, 1, 0, symbol)) {

                    return true;

                }
            }
        }

        for (int r = 0; r <= size - winCondition; r++) {

            for (int c = 0; c <= size - winCondition; c++)
             {
                if (checkConsecutive(r, c, 1, 1, symbol)) {

                    return true;

                }
            }
        }

        for (int r = 0; r <= size - winCondition; r++) {

            for (int c = winCondition - 1; c < size; c++) {

                if (checkConsecutive(r, c, 1, -1, symbol)) {

                    return true;

                }
            }
        }
        return false;
    }

    private boolean checkConsecutive( int startRow, int startCol, int rowStep, int colStep, char symbol) {

        for (int i = 0; i < winCondition; i++) {

            int r = startRow + i * rowStep;
            int c = startCol + i * colStep;
            if (getCell(r, c) != symbol) {

                return false;

            }
        }
        return true;
    }

    @Override
    public int getSize() {

        try {
            
            java.lang.reflect.Field sizeField = Board.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            return (int) sizeField.get(this);

        } catch (Exception e) {

            return 3;

        }
    }


    @Override
    public void display() {

        System.out.println("Board (" + getSize() + "x" + getSize() + "):");
        for (int r = 0; r < getSize(); r++) {

            for (int c = 0; c < getSize(); c++) {

                System.out.print(getCell(r, c) + " ");

            }
            System.out.println();
        }
        System.out.println();
    }
}