public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addNewToy(1, "Xbox", 10, 30);
        toyStore.addNewToy(2, "Playstation 5", 5, 40);
        toyStore.addNewToy(3, "Nintendo Switch", 3, 60);

        toyStore.changeWeight(1, 25);

        Toy prizeToy = (Toy) toyStore.play();
        if (prizeToy != null) {
            toyStore.savePrizeToyToFile(prizeToy, "prize_toys.txt");
            System.out.println("Поздравляем! Вы выиграли - " + prizeToy.getName());
        } else {
            System.out.println("Все игрушки кончились!");
        }
    }
}
