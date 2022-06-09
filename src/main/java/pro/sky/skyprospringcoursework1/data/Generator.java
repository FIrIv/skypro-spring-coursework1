package pro.sky.skyprospringcoursework1.data;

public class Generator {
    public int generateFromToRandom (int min, int max) {
        java.util.Random random = new java.util.Random();
        int elem;
        elem = random.nextInt(max-min+1) + min;
        return elem;
    }
}
