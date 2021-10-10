import java.util.Vector;

public class Group {
    private int size;
    private int g;

    public Group(int size) {
        this.size = size;
        findOptimalG();
    }

    public void findOptimalG() {
        Vector<Integer> subgroup = new Vector<>();
        Pair<Integer, Integer> bestG = new Pair<>(0, 0);


        for (int i = 0; i < size; i++) {
            subgroup.clear();

            while(true) {
                int groupSize = subgroup.size();
                Integer number = pow(i, groupSize);

                if(subgroup.contains(number)) {

                    if(groupSize > bestG.getSecond()) {

                        bestG = new Pair<>(i, groupSize);
                    }
                    break;
                }
                subgroup.add(number);
            }

            if(bestG.getSecond() == getSize() - 1) break;
        }
        g = bestG.getFirst();
    }

    public int getG() {
        return g;
    }

    public int getSize() {
        return size;
    }

    public int generatePublicKey(int privateKey) {
        return pow(getG(), privateKey);
    }

    public int pow(int a, int b) {
        int temp = a;
        for (int i = 0; i < b; i++) {
            temp = (temp * a) % size;
        }
        return temp;
    }
}
