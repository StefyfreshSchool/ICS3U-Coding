package week11;

public class APDriver {
    public static void main(String[] args) {
        int[] a = {0, 0, 0, 1000, 2, 444, 2, 8};
        Sound s = new Sound(a);
        s.trimSilenceFromBeginning();

    }
}
