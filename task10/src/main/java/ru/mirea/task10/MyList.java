package ru.mirea.task10;

import org.springframework.stereotype.Component;
import ru.mirea.task10.sort.SortingAlgorithm;

import java.util.List;

@Component
public class MyList {
    private SortingAlgorithm sortAlgorithm;

    public MyList(SortingAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public SortingAlgorithm getSortAlgorithm() {
        return sortAlgorithm;
    }

    public void setSortAlgorithm(SortingAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }
}
