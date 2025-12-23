package Assignment6;

/**
 * Defines strategy for computer players
 * Allows different AI strategies to be implements
 */
public interface MoveStrategy {

    int[] generateMove(Board board);

}


