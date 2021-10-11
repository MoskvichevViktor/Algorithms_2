package lesson_2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortService {
    private static final int NOTEBOOKS_COUNT = 10000;

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
        BigDecimal price = BigDecimal.valueOf((random.nextInt(31) * 50 + 500));
        int memory = (random.nextInt(6) + 1) * 4;
        int brandNameCount = Notebook.BrandName.values().length;
        Notebook.BrandName brandName = Notebook.BrandName.values()[random.nextInt(brandNameCount)];

        return new Notebook(price, memory, brandName);
    }

    private static void displayNotebooks(List<Notebook> list){
        for(Notebook n: list){
            System.out.printf("%10s, %10s, %10s\n", n.getPrice(), n.getMemory(), n.getBrandName());
        }
    }

}
