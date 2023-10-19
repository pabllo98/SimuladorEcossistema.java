import java.util.ArrayList;
import java.util.List;

// Classe base para elementos do ecossistema
class EcossistemaElement {
    private String nome;

    public EcossistemaElement(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

// Classe para animais
class Animal extends EcossistemaElement {
    protected int idade;
    protected int energia;

    public Animal(String nome) {
        super(nome);
        this.idade = 0;
        this.energia = 100;
    }

    public void envelhecer() {
        idade++;
        energia -= 5;
    }

    public void mover() {
        energia -= 10;
    }

    public void comer(Planta planta) {
        energia += 20;
    }

    // Outros métodos e comportamentos de animais podem ser adicionados
}

// Classe para plantas
class Planta extends EcossistemaElement {
    protected int tamanho;

    public Planta(String nome) {
        super(nome);
        this.tamanho = 10;
    }

    public void crescer() {
        tamanho += 5;
    }

    // Outros métodos e comportamentos de plantas podem ser adicionados
}

// Classe para fenômenos naturais
class FenomenoNatural {
    public void ocorrer(List<EcossistemaElement> elementos) {
        // Implemente o comportamento do fenômeno natural aqui
    }
}

// Classe para o terreno da floresta
class Terreno {
    private List<EcossistemaElement> elementos;

    public Terreno() {
        elementos = new ArrayList<>();
    }

    public void adicionarElemento(EcossistemaElement elemento) {
        elementos.add(elemento);
    }

    public void removerElemento(EcossistemaElement elemento) {
        elementos.remove(elemento);
    }

    public void simularDia() {
        for (EcossistemaElement elemento : elementos) {
            if (elemento instanceof Animal) {
                Animal animal = (Animal) elemento;
                animal.envelhecer();
                animal.mover();
            } else if (elemento instanceof Planta) {
                Planta planta = (Planta) elemento;
                planta.crescer();
            }
        }

        FenomenoNatural fenomeno = new FenomenoNatural();
        fenomeno.ocorrer(elementos);
    }
}

public class SimuladorEcossistema {
    public static void main(String[] args) {
        Terreno floresta = new Terreno();

        Animal lobo = new Animal("Lobo");
        Animal coelho = new Animal("Coelho");
        Planta arvore = new Planta("Árvore");

        floresta.adicionarElemento(lobo);
        floresta.adicionarElemento(coelho);
        floresta.adicionarElemento(arvore);

        for (int dia = 1; dia <= 30; dia++) {
            System.out.println("Dia " + dia);
            floresta.simularDia();
        }
    }
}