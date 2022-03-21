import java.util.ArrayList;

@FunctionalInterface
public interface Comparator<T>
{
    int compare(ArrayList<T> arr1, ArrayList<T> arr2);
}
