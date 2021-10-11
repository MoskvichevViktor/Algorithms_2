package lesson_2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortService {
    private static final int NOTEBOOKS_COUNT = 5000;

    public static void main(String[] args) {

        List<Notebook> notebooks = generateListNotebooks();

        notebooks = SortNotebookSelection.sort(notebooks);

        displayNotebooks(notebooks);

    }

    private static ArrayList<Notebook> generateListNotebooks(){
        ArrayList<Notebook> arrayList = new ArrayList<>();
        for (int i = 0; i < NOTEBOOKS_COUNT; i++) {
            arrayList.add(createNotebook());
        }
        return arrayList;
    }


    private static Notebook createNotebook(){
        Random random = new Random();
        BigDecimal price = BigDecimal.valueOf((random.nextInt(26) * 100 + 500));
        int memory = (random.nextInt(4) + 1) * 6;
        int producersCount = Notebook.BrandName.values().length;
        Notebook.BrandName producer = Notebook.BrandName.values()[random.nextInt(producersCount)];

        return new Notebook(price, memory, producer);
    }

    private static void displayNotebooks(List<Notebook> list){
        for(Notebook n: list){
            System.out.printf("%10s, %10s, %10s\n", n.getPrice(), n.getMemory(), n.getBrandName());
        }
    }

}
