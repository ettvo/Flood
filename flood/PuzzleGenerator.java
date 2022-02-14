package flood;

import java.util.Random;

import static flood.Utils.*;

/** A creator of random Flood puzzles.
 *  @author Evelyn Vo
 */
class PuzzleGenerator implements PuzzleSource {

    /** A new PuzzleGenerator whose random-number source is seeded
     *  with SEED. */
    PuzzleGenerator(long seed) {
        _random = new Random(seed);
    }

    @Override
    public Model getPuzzle(int width, int height, int ncolors, int extra) {
        int[][] initial = new int[height][width];
        for (int row = 0; row < height; row += 1) {
            for (int col = 0; col < width; col += 1) {
                initial[row][col] = _random.nextInt(ncolors);
            }
        }
        Model puzzle = new Model(initial, ncolors);

        int expectedMoves = Solver.movesNeeded(puzzle);
        puzzle.setLimit(expectedMoves + extra);
        return puzzle;
    }


    @Override
    public void setSeed(long seed) {
        _random.setSeed(seed);
    }

    /** My PNRG. */
    private Random _random;

}
