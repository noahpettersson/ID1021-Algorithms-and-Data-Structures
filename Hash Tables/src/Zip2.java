import java.io.BufferedReader;
import java.io.FileReader;

public class Zip2 {
    Node[] data;
    int max;
    public class Node {
        String code;
        String name;
        Integer population;

        public Node(String code, String name, Integer population) {
            this.code = code;
            this.name = name;
            this.population = population;
        }
    }
    public Zip2(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Boolean lookup (String code) {
        for(int i = 0; i < 9675; i++) {
            if(data[i].code.equals(code))
                return true;
        }
        return false;
    }

    public Boolean BinaryLookup (String zipcode) {
        Integer low = 0;
        Integer high = 9674;

        while(true) {
            Integer mid = (high + low) / 2;
            if(data[mid].code.equals(zipcode))
                return true;

            if(data[mid].code.compareTo(zipcode) < 0 && mid < high) {
                low = mid + 1;
                continue;
            }
            if(data[mid].code.compareTo(zipcode) > 0 && mid > low) {
                high = mid - 1;
                continue;
            }
            break;
        }
        return false;
    }
}