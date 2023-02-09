import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    public City[] cities;
    private final int mod = 541;
    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                City one = lookup(row[0]);
                City two = lookup(row[1]);
                Integer dist = Integer.valueOf(row[2]);
                one.addConnection(two, dist);
                two.addConnection(one, dist);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    public City lookup(String name){
        Integer index = hash(name);

        while (cities[index] != null) {
            if (cities[index].name.equals(name)) {
                return cities[index];
            }

            index = index + 1 % mod;
        }
        City city = new City(name);
        cities[index] = city;
        return city;
    }

}