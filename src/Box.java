public class Box implements Runnable {
    private final Carro carro;

    public Box(Carro carro) {
        this.carro = carro;
    }

    @Override
    public void run() {
        int velocidade = carro.getVelocidadeAtual();

        System.out.println(carro.getNome() + " entrou no box com a velocidade igual de:" + velocidade + " km/h.");

        if (velocidade > 60) {
            penalidade();
        } else {
            passarBox();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void passarBox() {
        System.out.println(carro.getNome() + " está no box");
        pausa(2000);
        System.out.println(carro.getNome() + " saiu do box.");
    }

    private void penalidade() {
        System.out.println(carro.getNome() + " foi penalizado por ultrapassar o limite acima de 60km");
    }

    private void pausa(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
