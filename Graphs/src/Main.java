public class Main {
    public static void main(String[] args) {
        Map map = new Map("/Users/noahpettersson/IdeaProjects/Graphs/trains.csv");
        //System.out.println(map.cities[257].name);

        for(int i = 0; i < map.cities.length; i++) {
            if(map.cities[i] != null) {
                System.out.println(map.cities[i].name);
            }

        }
    }
}