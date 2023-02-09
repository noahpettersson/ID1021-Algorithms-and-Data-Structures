import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;
    public class Node {
        String name;
        Integer population;

        public Node(String name, Integer population) {
            this.name = name;
            this.population = population;
        }
    }
    public Zip(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean lookup (Integer index) {
        if(index > 99999 || index < 0)
            return false;
        if(data[index] != null)
            return true;
        else return false;
    }

    /*public Boolean lookup (Integer code) {
        for(int i = 0; i < 9675; i++) {
            if(data[i].code.equals(code))
                return true;
        }
        return false;
    }

    public Boolean BinaryLookup (Integer zipcode) {
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
    }*/
}