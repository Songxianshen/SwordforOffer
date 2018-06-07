package datastrcture.problem_04;

public class solution {
    public boolean find(int [][] array, int num){
        if (array == null){
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;
        while(row < array.length && column > 0){
            if(array[row][column] == num){
                return true;
            }
            if(array[row][column] > num){
                column --;
            }else {
                row ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] array = new int[][]{
                {1, 2, 8, 9 },
                {2, 4, 9, 12 },
                {4, 7, 10, 13 },
                {6, 8, 11, 15 }
        };
        solution test = new solution();
        System.out.println(test.find(array,1515));
    }
}
