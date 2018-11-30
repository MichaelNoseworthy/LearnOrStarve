package com.learnorstarve.game;



/**
 * Created by mehol on 2018-11-30.
 */

public class HighscoreSorter  {

    public String HighscoreArray[] = new String[]{
        "King ", "30",
        "Queen ", "25",
        "Princess ", "20",
        "Prince ", "15",
        "Knight ", "10",
        "Archer ", "5",
        "Peasant ", "1",
        "Peasant ", "1",
        "Peasant ", "1",
        "Peasant ", "1"};

    public int scores[] = new int[10];
    public String names[] = new String[10];

    public void initialize() {
        for (int i = 0; i < scores.length; i++) {
            names[i] = HighscoreArray[2 * i];
            scores[i] = Integer.getInteger(HighscoreArray[2 * i - 1]);
        }
        insertionSort(scores,names,10);
    }

    void insertionSort(int arrInt[], String arrString[], int n)
    {
        int i, key, j;
        String keys;
        int arraylength = n;
        for (i = 1; i < n; i++)
        {
            key = arrInt[i];
            keys = arrString[i];
            j = i - 1;

		/* Move elements of arr[0..i-1], that are
		greater than key, to one position ahead
		of their current position */
            while (j >= 0 && arrInt[j] > key)
            {
                arrInt[j + 1] = arrInt[j];
                arrString[j + 1] = arrString[j];
                j = j - 1;
            }
            arrInt[j + 1] = key;
            arrString[j + 1] = keys;
        }


        for (int k = 0; k < (arraylength / 2); k++) {
            int temporary = arrInt[k];
            arrInt[k] = arrInt[(arraylength - 1) - k];
            arrInt[(arraylength - 1) - k] = temporary;
            String temporary2 = arrString[k];
            arrString[k] = arrString[(arraylength - 1) - k];
            arrString[(arraylength - 1) - k] = temporary2;
        }
    }

    public boolean checkList(int arrInt[], String arrString[], int n, int key, String myname) {

        int k = key;
        String name = myname;
        int temporaryInt1;
        String temporaryString1;
        boolean continueOn = true;

        boolean ifFound = false;
        for (int i = 0; i < n; i++)
        {
            if (arrInt[i] <= k)
            {
                ifFound = true;
            }
        }

        if (ifFound == true)
        {

            temporaryInt1 = arrInt[0];
            temporaryString1 = arrString[0];

            for (int i = 9; i > 0; i--)
            {
                arrInt[i] = arrInt[i - 1];
                arrString[i] = arrString[i - 1];
            }

            arrInt[0] = k;
            arrString[0] = name;
            return true;
        }
        return false;

    }
}
