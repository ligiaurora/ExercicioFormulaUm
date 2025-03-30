import java.util.Random;

public class Carro implements Runnable {
    private String nome;
    private int velocidade;
    private int velocidadeAtual;
    private boolean correndo;

    public Carro(String nome) {
        this.nome = nome;
        this.velocidade = new Random().nextInt(101) + 100;
        this.correndo = true;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (correndo) {
            int acao = random.nextInt(5) + 1;

            switch (acao) {
                case 1 -> correr();
                case 2 -> pararPorProblema();
                case 3, 4, 5 -> new Thread(new Box(this)).start();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void correr() {
        int variacao = new Random().nextInt(21) - 10;
        velocidadeAtual = velocidade + variacao;
        System.out.println(nome + " está correndo a " + velocidadeAtual + " km/h");
    }

    private void pararPorProblema() {
        System.out.println(nome + "Fim de prova por problemas técnicos");
        correndo = false;
    }

    public String getNome() {
        return nome;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public boolean isCorrendo() {
        return correndo;
    }
}
