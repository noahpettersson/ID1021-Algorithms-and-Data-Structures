public class Naive {
    public static void main(String[] args) {
        Map map = new Map("trains.csv");
        Paths path = new Paths();

        System.out.println("-----------------");
        printNeighbord("Göteborg", map);
        System.out.println("-----------------");

        String[] d = {"Göteborg", "Norrköping", "Stockholm", "Gävle", "Sundsvall", "Umeå", "Kiruna"};
        for(int i = 0; i < d.length; i++){
            String from = "Malmö";
            String to = d[i];
            Integer max = 10000;
            long t0 = System.nanoTime();
            Integer dist = path.shortest(map.lookup(from), map.lookup(to), max);
            long time = (System.nanoTime() - t0)/1_000;
            System.out.println("Malmö - " + d[i] + ": shorest: " + dist + " min (" + time + " us)");
        }

    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer distance = shortest(conn.city, to, max - conn.distance);
                if((distance != null) && ((shrt == null) || (shrt > distance + conn.distance)))
                    shrt = distance + conn.distance;
            }
        }
        return shrt;
    }

    public static void printNeighbord(String name, Map map) {
        for(City c : map.cities) {
            if((c != null) && (c.name.compareTo(name) == 0)) {
                for(Connection con : c.neighbors) {
                    if(con == null)
                        break;
                    System.out.println(con.city.name);
                }
                break;
            }
        }
    }
}