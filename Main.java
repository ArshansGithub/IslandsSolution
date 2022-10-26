import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;

  public class Main{
    public static void main(String[] args) {

        Queue<Coord> queue = new PriorityQueue<Coord>(); 

        /*int[] array = {
            4,
            4,
            1, 0, 1, 0,
            1, 1, 0, 1,
            0, 0, 0, 1,
            0, 1, 0, 1
        };*/

        int[] array = {
            5,
            5,
            1, 1, 1, 1, 1,
            1, 0, 0, 0, 1,
            1, 0, 1, 0, 1,
            1, 0, 0, 0, 1,
            1, 1, 1, 1, 1   
        };
        int[][] arrayed = new int[array[0]][array[1]];
        //for (int column=0; column!=array[1]; )
        int islands = 0;
        Coord size = new Coord(array[0], array[1]);
        int counter2 = 0;
        int counter3 = 0;
        int row = 0;
        for (int counter = 0; counter!=array[1]; counter++) {
            while (row!=array[0]) {
                /*System.out.println(Arrays.deepToString(arrayed));
                System.out.println("On 2d array " + counter);*/
                arrayed[counter][counter2] = array[counter3+row+2];
                counter2++;
                row++;
            }
            counter3+=row;
            row=0;
            counter2=0;
        }
        
        //System.out.println(Arrays.deepToString(arrayed));
        for (int outer=0; outer!=array[0]; outer++) {
            for (int inner=0; inner!=arrayed[outer].length; inner++) {
                //System.out.println("Outer: " + outer + "| Inner: " + inner);
                if (arrayed[outer][inner] == 1) {
                    Coord currentPos = new Coord(outer, inner);
                    bfs(queue, arrayed, currentPos, size);
                    islands++;
                }
            } 
        }
        System.out.println(islands);
    }
    @SuppressWarnings("unchecked")
    public static void bfs(Queue myQueue, int[][] array, Coord current, Coord size) {
        
        myQueue.add(current);
        while (!myQueue.isEmpty()) {
            Coord popped = (Coord) myQueue.poll();
            array[current.x][current.y] = -1;
            Coord left = new Coord(popped.x, popped.y-1);
            if (left.x >= 0 && left.y >= 0 && left.x <= size.x - 1 && left.y <= size.y - 1) {
                if (array[left.x][left.y] == 1) {
                    bfs(myQueue, array, left, size);
                }
            }
            Coord up = new Coord(popped.x-1, popped.y);
            if (up.x >= 0 && up.y >= 0 && up.x <= size.x - 1 && up.y <= size.y - 1) {
                if (array[up.x][up.y] == 1) {
                    bfs(myQueue, array, up, size);
                }
            }
            Coord right = new Coord(popped.x, popped.y+1);
            if (right.x >= 0 && right.y >= 0 && right.x <= size.x - 1 && right.y <= size.y - 1) {
                if (array[right.x][right.y] == 1) {
                    bfs(myQueue, array, right, size);
                }
            }
            Coord down = new Coord(popped.x+1, popped.y);
            if (down.x >= 0 && down.y >= 0 && down.x <= size.x - 1 && down.y <= size.y - 1) {
                if (array[down.x][down.y] == 1) {
                    bfs(myQueue, array, down, size);
                }
            }

        }

    }
}

class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }


}