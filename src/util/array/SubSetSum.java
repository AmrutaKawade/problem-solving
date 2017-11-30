package util.array;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
	private static List<Integer> solution = new ArrayList<>();
    
    static void getSolution(boolean[][] part, List<Integer> arr, int i, int j) {
        if(!part[i][j] || i==0)
            return;

        if(part[i][j-1])
            getSolution(part,arr,i,j-1);
        else {
            getSolution(part,arr,i-arr.get(j-1),j-1);
            solution.add(arr.get(j-1));
        }
    }

    static List<Integer> getSubsetSum(List<Integer> arr, int sum) {
        if (!solution.isEmpty())
            solution.removeAll(solution);
        
        int n = arr.size();

        boolean[][] part = new boolean[sum+1][n+1];

        for(int i=1;i<sum+1;i++)
            part[i][0] = false;

        for(int j=0;j<n+1;j++)
            part[0][j] = true;

        for(int i=1;i<sum+1;i++) {
            for(int j=1;j<n+1;j++) {
                part[i][j] = part[i][j-1];
                if(i >= arr.get(j-1))
                    part[i][j] = part[i][j] || part[i-arr.get(j-1)][j-1];
            }
        }

//        printMatrix(part);
        
        while(sum > 0 && !part[sum][n])
            sum--;
        if(sum > 0)
            getSolution(part,arr,sum,n);
        else
            return null;

        return solution;
    }

    static void printMatrix(boolean[][] mat) {
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    static void printArray(List<Integer> arr) {
        for(Integer i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        //int[] arr = {60, 60, 60, 60, 60, 45, 45, 45, 45, 45, 45, 30, 30, 30, 30, 30, 30, 30, 5};
//        int[] arr = {4, 6, 8, 10};
    	int[] arr = {3, 34, 4, 12, 5, 2};
        List<Integer> durationList = new ArrayList<>();
        durationList.add(9);
        //durationList.add(240);
        List<Integer> arrayList = getArray(arr);
        printArray(arrayList);
        Integer count = 1;
        Integer durationCount = 0;
        while (!arrayList.isEmpty()) {
            if (durationCount == durationList.size())
                durationCount = 0;
            List<Integer> tempSol = getSubsetSum(arrayList,durationList.get(durationCount++));
            if (null == tempSol) {
                System.out.println("Following talks cannot fit in track - ");
                printArray(arrayList);
                arrayList.removeAll(arrayList);
                break;
            }else if (!tempSol.isEmpty()) {
                System.out.println("Track" + count + " - ");
                printArray(tempSol);
                for (Integer sol : tempSol) {
                    arrayList.remove(sol);
                }
                count++;
            } else {
                break;
            }
        }
    }

    private static List<Integer> getArray(int[] arr) {
        List<Integer> arrayList = new ArrayList<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            arrayList.add(arr[i]);
        }
        return arrayList;
    }
}
