public class Paths {
    City[] path;
    int sp;
    public Paths() {
        path = new City[54];
        sp = 0;
    }
    public Integer shortest(City from, City to, Integer max) {
        //if (max != null){
            if(max < 0)
                return null;
        //}
        if (from == to)
            return 0;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        //System.out.println("max: " + max);
        path[sp++] = from;
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer distance = shortest(conn.city, to, max - conn.distance);
                if((distance != null) && ((shrt == null) || (shrt > distance + conn.distance)))
                    shrt = distance + conn.distance;
                if((shrt != null) && (max > shrt)){
                    //System.out.println("max from: " + from.name + " set to: " + to.name + " max " + max);
                    max = shrt;
                }

            }
        }
        path[sp--] = null;
        return shrt;
    }

}