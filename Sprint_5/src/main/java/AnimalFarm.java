import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AnimalFarm {
    //Подготовка
    private final List<String> farmAnimals;
    public AnimalFarm(List<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    //Первое задание
    public HashMap<String, Integer> countedAnimals() {
        HashMap<String, Integer> tableAnimal = new HashMap<String, Integer>();

        for(int i = 0; i < this.farmAnimals.size(); i++) {
            String[] splitString = this.farmAnimals.get(i).split(" ");
            if (splitString[0] != "NOT_DEFINED") {
                if(!tableAnimal.containsKey(splitString[0])) {
                    int count = 1;
                    for (int j = i + 1; j < this.farmAnimals.size(); j++) {
                        if(this.farmAnimals.get(j) == splitString[0]) {
                            count = count + 1;
                        }
                    }
                    tableAnimal.put(splitString[0], count);
                }
            } else {
                System.out.println("Please correct string " + Animal.NOT_DEFINED + ". Incorrect input data.");
            }
        }
        return tableAnimal;
    }

    //Второе задание
    public HashSet<String> uniqueNames() {
        //мы должны взять список, сплитнуть его и вытащить вторую часть и положить его отдельно в список
        String[] splitFarmAnimals = this.farmAnimals.toString().split(" ");
        //че делать после разделения, как забрать то, что нужно... пробую так:
        HashSet<String> listOfUniqueNames = new HashSet<>();
        for (int i = 0; i < splitFarmAnimals.length; i++) {
            if (i % 2 != 0) {
                if(splitFarmAnimals[i] != "N") {
                    listOfUniqueNames.add(splitFarmAnimals[i]);
                } else {
                    System.out.println("Please correct string " + splitFarmAnimals[i] + ". Incorrect input data.");
                }
            }
        }
        //вернуть уникальные имена
        return listOfUniqueNames;
    }

    //Третье задание: методы для разных вариантов добавления нового животного на ферму

    //когда передали и вид, и имя
    public void addVarOne(String typeOfAnimal, String name) {
        this.farmAnimals.add(typeOfAnimal + " " + name);
    }
    //когда передали только вид
    public void addVarTwo(String typeOfAnimal) {
        String name = "N";
        this.farmAnimals.add(typeOfAnimal + " " + name);
    }
    //когда передали только имя животного
    public void addVarThree(String name) {
        String typeOfAnimal = String.valueOf(Animal.NOT_DEFINED);
        this.farmAnimals.add(typeOfAnimal + " " + name);
    }
    //Четвертое задание
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String farmAnimal : farmAnimals) {
            String printFarmAnimal = farmAnimal.replace(" ", ":");
            stringBuilder.append(printFarmAnimal).append("\n");
        }
        return stringBuilder.toString();
    }
}
