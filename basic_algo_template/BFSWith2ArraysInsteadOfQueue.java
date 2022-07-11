package basic_algo_template;

import java.util.ArrayList;
import java.util.List;

//Algo to do BFS without queue -> rather maintain CurrentLayer & NextLayer alone
public class BFSWith2ArraysInsteadOfQueue {
    public void bfsWith2Arrays() {
        List<Integer> currentLayer = new ArrayList<>();
        List<Integer> nextLayer = new ArrayList<>();
        int initialElement = 0; // the starting graph node
        currentLayer.add(initialElement);

        while (!currentLayer.isEmpty()) {
            for (int cell : currentLayer) {
                for (int neighbor : getNeighbors(cell)) {
                    nextLayer.add(neighbor);
                }
            }

            // Set up for processing the next layer.
            currentLayer = nextLayer;
            nextLayer = new ArrayList<>();
        }
    }

    private int[] getNeighbors(int cell) {
        return new int[]{1, 2, 3, 4};
    }
}
