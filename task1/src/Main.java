// Variant 8
// Имплементировать интерфейс Comparator, сравнивающий два массива с одинаковыми типами элементов по количеству элементов в данных массивах.

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Comparator<Integer> comp = (a1, a2) -> {
            if (a1.size() > a2.size())
                return 1;
            else if (a1.size() < a2.size())
                return -1;
            else
                return 0;
        };

        int n1;
        int n2;

        Scanner sc = new Scanner(System.in);

        n1 = sc.nextInt();
        n2 = sc.nextInt();

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        //fill arrays 0 values
        for(int i = 0; i < n1; i++)
            arr1.add(0);

        for(int i = 0; i < n2; i++)
            arr2.add(0);

        System.out.println(comp.compare(arr1, arr2));
    }
}
