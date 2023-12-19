import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static double[][] list = {
            {45.171112, 5.695952},
            {45.183152, 5.699386},
            {45.174115, 5.711106},
            {45.176123, 5.722083},
            {45.184301, 5.719791},
            {45.184252, 5.730698},
            {45.170588, 5.716664},
            {45.193702, 5.691028},
            {45.165641, 5.739938},
            {45.178718, 5.744940},
            {45.176857, 5.762518},
            {45.188512, 5.767172},
            {45.174017, 5.706729},
            {45.174458, 5.687902},
            {45.185110, 5.733667},
            {45.185702, 5.734507},
            {45.184726, 5.734666},
            {45.184438, 5.733735},
            {45.184902, 5.735256},
            {45.174812, 5.698095},
            {45.169851, 5.695723},
            {45.180943, 5.698965},
            {45.176205, 5.692165},
            {45.171244, 5.689872}
    };

    public static void main(String[] args) {
        System.out.println(calculateDistance(list[0][0], list[0][1], list[1][0], list[1][1]));
//        System.out.println(list[0][0]);
//        System.out.println(list[0][1]);
//        System.out.println(list[1][0]);
//        System.out.println(list[1][1]);
//        System.out.println(list.length);
        AllDistances();
        isVisited();
        System.out.println(list3[23][12]);
        System.out.println(MinValue(0));
        resolutionChemin();


    }

    public static Double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);
        return (Math.sqrt(x * x + y * y) * 6371);
    }

    static Double[][] list3 = new Double[list.length][list.length];

    public static void AllDistances() {
        int i;
        int j;
        for (i = 0; i < list.length; i++) {
            for (j = 0; j < list.length; j++) {
                list3[i][j] = (calculateDistance(list[i][0], list[i][1], list[j][0], list[j][1]));
                System.out.println("index : " + i + " num: " + j + "    " + list3[i][j]);
            }
        }
    }

    public static int MinValue(int index) {
        Double maxVal = Double.MAX_VALUE;
        Double minVal = Double.MIN_VALUE;
        int i;
        int indexOfNextPoint = 0;
        for (i = 1; i < list.length; i++) {
            if (list3[index][i] < maxVal && !isVisited[i])
                maxVal = list3[index][i];
            if (list3[index][i] > minVal && !isVisited[i]) {
                minVal = list3[index][i];
            }
            if (list3[index][i].equals(maxVal)) {
                indexOfNextPoint = i;
            }
        }

        return indexOfNextPoint;

    }

    static Boolean[] isVisited = new Boolean[list.length];

    public static void isVisited() {
        for (int i = 0; i < list.length; i++) {
            isVisited[i] = false;
//            System.out.println(isVisited[i]);
//        }
        }
    }

    static ArrayList<Integer> chemin = new ArrayList<Integer>();

    public static void resolutionChemin() {
        int point = 0;
        Double distance = 0.0;
        isVisited[point] = true;
        chemin.add(point + 1);
        int nextpoint;
        for (int i = 0; i < list.length - 1; i++) {
            nextpoint = MinValue(point);
            MinValue(nextpoint);
            isVisited[nextpoint] = true;
            chemin.add(nextpoint + 1);
            distance = distance + calculateDistance(list[point][0], list[point][1], list[nextpoint][0], list[nextpoint][1]);
            point = nextpoint;
        }
        System.out.println(chemin);
        System.out.println(distance);
        System.out.println(Arrays.toString(isVisited));
    }
}













