public class Main {
    public static void main(String[] args) {
        Zip zip = new Zip("/Users/noahpettersson/IdeaProjects/Hash Tables/postnummer.csv");
        Hash hash = new Hash("/Users/noahpettersson/IdeaProjects/Hash Tables/postnummer.csv");
        Zip2 zip2 = new Zip2("/Users/noahpettersson/IdeaProjects/Hash Tables/postnummer.csv");

        int k = 1000000;
        int t = 0;
        /*for(int i = 0; i < k; i++) {
            double t1 = System.nanoTime();
            zip.BinaryLookup(99499);
            t += (System.nanoTime() - t1);
        }
        System.out.println("Binary: " + t/k);*/

        /*t = 0;
        for(int i = 0; i < k; i++) {
            double t1 = System.nanoTime();
            zip.lookup(11115);
            t += (System.nanoTime() - t1);
        }
        System.out.println("lookup: " + t/k);*/
        hash.fillBucket();
        hash.collisions(11497);
        System.out.println(hash.lookup(86241));






    }
}