import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void move() {
        System.out.println(name + " está se movendo");
    }

    public void eat() {
        System.out.println(name + " tá com fome");
    }

    public void reproduce() {
        System.out.println(name + " vai se reproduzir");
    }
}

class Plant {
    protected String type;
    protected int age;

    public Plant(String type, int age) {
        this.type = type;
        this.age = age;
    }

    public void grow() {
        System.out.println("A " + type + " A planta está crescendo");
    }
}

class Lobo extends Animal {
    public Lobo(String name, int age) {
        super(name, age);
    }

    @Override
    public void move() {
        System.out.println("Lobo " + super.name + " Está com fome");
    }
}

class Raposa extends Animal {
    public Raposa(String name, int age) {
        super(name, age);
    }

    @Override
    public void move() {
        System.out.println("A Raposa " + super.name + " Quer comer");
    }
}

class Forest {
    private List<Animal> animals;
    private List<Plant> plants;

    public Forest() {
        animals = new ArrayList<>();
        plants = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void SimuladorEcossistema(int numCycles) {
        Random rand = new Random();
        for (int cycle = 0; cycle < numCycles; cycle++) {
            System.out.println("Cycle " + (cycle + 1) + ":");
            for (Animal animal : animals) {
                animal.move();
                if (rand.nextBoolean()) {
                    animal.eat();
                }
                if (rand.nextBoolean()) {
                    animal.reproduce();
                    addAnimal(new Animal(animal.getClass().getSimpleName(), 0));
                }
            }
            for (Plant plant : plants) {
                plant.grow();
            }
            System.out.println("--------");
        }
    }

    public void simulateEcosystem(int i) {
    }
}

public class SimuladorEcossistema {
    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.addAnimal(new Lobo("Alpha", 3));
        forest.addAnimal(new Raposa("Vermelha", 1));
        forest.addPlant(new Plant("Trepadeiras", 5));
        forest.addPlant(new Plant("Bamboo", 2));

        forest.simulateEcosystem(5);
    }
}

class forest {
    protected List<Animal> animals;
    protected List<Plant> plants;

    public forest() {
        animals = new ArrayList<>();
        plants = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void simuladorEcossistema(int numCycles) {
        Random rand = new Random();
        for (int cycle = 0; cycle < numCycles; cycle++) {
            System.out.println("Cycle " + (cycle + 1) + ":");
            List<Animal> newAnimals = new ArrayList<>();
            for (Animal animal : animals) {
                animal.move();
                if (rand.nextBoolean()) {
                    animal.eat();
                }
                if (rand.nextBoolean()) {
                    animal.reproduce();
                    newAnimals.add(new Animal(animal.getClass().getSimpleName(), 0));
                }
            }
            animals.addAll(newAnimals); // Adicionar os novos animais após a iteração
            for (Plant plant : plants) {
                plant.grow();
            }
            System.out.println("--------");
        }
    }
}
