import java.io.BufferedReader;
import java.io.FileReader;

public class Hash {
    Node[] data;
    Integer[] keys;

    Node[] buckets;

    Integer mod = 15767;
    int max;

    public class Node {
        Integer code;
        String name;
        Integer population;

        Node next;

        public Node(Integer code, String name, Integer population) {
            this.code = code;
            this.name = name;
            this.population = population;
            this.next = null;
        }
    }

    public Hash(String file) {
        keys = new Integer[10000];
        data = new Node[10000];
        buckets = new Node[20000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[i] = new Node(code, row[1], Integer.valueOf(row[2]));
                keys[i++] = code;


            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

    /*public boolean lookup (Integer index) {
        if(index > 99999 || index < 0)
            return false;
        if(data[index] != null)
            return true;
        else return false;
    }*/

    public Integer getHash(Integer code) {
        return code % mod;
    }

    /*public void addBucket(Node node) {
        Integer index = getHash(node.code);
        if (buckets[index] == null)
            buckets[index] = node;
        else {
            Node current = buckets[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    } */

    public void addBucket(Node node) {
        Integer index = getHash(node.code);
        if(buckets[index] == null)
            buckets[index] = node;
        else {
            while(buckets[index+1] != null) {
                index++;
            }
            buckets[++index] = node;
        }
    }

    public void fillBucket() {
        for (int i = 0; i < max + 1; i++)
            addBucket(data[i]);
    }

    public Integer lookup(Integer zipcode) {
        Integer index = getHash(zipcode);
        Integer temp = 0;
        if(buckets[index] == null) {}
        else {
            if(buckets[index].code.equals(zipcode))
                return temp;
            while(buckets[++index] != null) {
                temp++;
                if(buckets[index].code.equals(zipcode))  {
                   return temp;
                }
            }
            System.out.println("not found");
        }
        return null;
    }

    /*public Integer lookup(Integer zipcode) {
        Integer index = getHash(zipcode);
        if (buckets[index] == null)
            return null;

        else {
            Node current = buckets[index];
            while (current.next != null) {
                if (current.code.equals(zipcode))
                    return current.code;
                current = current.next;
            }
            if (current.code.equals(zipcode))
                return current.code;
        }
        System.out.println("Did not find");
       return null;
    }*/

    /*public Boolean lookup (Integer code) {
        for(int i = 0; i < 9675; i++) {
            if(data[i].code.equals(code))
                return true;
        }
        return false;
    }*/

    /*public Boolean BinaryLookup (Integer zipcode) {
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