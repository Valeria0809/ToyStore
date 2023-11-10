import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addNewToy(int id, String name, int quantity, double weightPercentage) {
        Toy newToy = new Toy(id, name, quantity, weightPercentage);
        toys.add(newToy);
    }

    public void changeWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeightPercentage(newWeight);
                return;
            }
        }
    }
    public Object play() {
        double randomValue = Math.random() * 100;
        double cumulativeWeight = 0;

        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeightPercentage();
            if (randomValue <= cumulativeWeight) {
                Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1, toy.getWeightPercentage());
                toy.decreaseQuantity();
                return prizeToy;
            }
        }
        System.out.println("Нет доступных игрушек для игры!");
        return null;
    }
    public void savePrizeToyToFile(Toy prizeToy, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("ID призовой игрушки: " + prizeToy.getId() +
                    ", Имя: " + prizeToy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

