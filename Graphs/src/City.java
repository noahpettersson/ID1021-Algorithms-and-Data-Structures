public class City {
    String name;
    Connection[] neighbors;

    public City(String name) {
        this.name = name;
        this.neighbors = new Connection[10];
    }

    public void addConnection (City city, Integer distance) {
        for(int i = 0; i < neighbors.length; i++)
            if(neighbors[i] == null){
                neighbors[i] = new Connection(city, distance);
                return;
            }

        System.out.println("Array is full");
    }
}
