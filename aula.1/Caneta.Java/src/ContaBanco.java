public class ContaBanco {
    public int Numconta;
    protected String Tipo;
    private String Dono;
    private float Saldo;
    private boolean Status;

    public void estadoatual() {
        System.out.println("--------------");
        System.out.println("Numconta: " + this.Numconta);
        System.out.println("Tipo de conta: " + this.Tipo);
        System.out.println("Dono: " + this.Dono);
        System.out.println("qual seu Saldo: " + this.Saldo);
        System.out.println("Status: " + this.Status);
    }

    public void AbrirConta(String T) {

        this.setTipo(T);
        this.setStatus(true);
        if (T == "CC") {
            this.setSaldo(50);
        } else if (T == "CP") {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso!");
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta com dinheiro,nao popde ser fechada");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta tá em debito,nao pode ser fechada");
        } else {
            this.setStatus(false);
            System.out.println("Conta Fechada com Sucesso");
        }
    }

    public void Sacar(float V) {
        if (this.getStatus()) {
            if (this.getSaldo() >= V) {
                this.setSaldo(this.getSaldo() - V);
                System.out.println("Saque Realizado na conta de " + this.getDono);
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Impossivel sacar de uma conta fechada");
        }
    }

    public void Depositar(float V) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + V);
            System.out.println("deposito realizado na conta de" + this.getDono);
        } else {
            System.out.println("Impossivel depositar em uma conta fechada");
        }
        // this.Saldo = this.Saldo + V;

    }

    public void PagarMensal() {
        int V;
        if (this.getTipo().equals("CC")) {
            V = 12;
        } else if (this.getTipo.equals("CP")) {
            V = 20;
        }
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - V);
            System.out.println("mensalidade paga com sucesso por " + this.getDono);
        } else {
            System.out.println("Impossivel Pagar uma conta fechada");
        }
    }

    public ContaBanco() {
        this.Saldo = 0;
        this.Status = false;
    }

    public int getNumconta() {
        return this.Numconta;
    }

    public void setNumconta(int N) {
        this.Numconta = N;
    }

    public String getTipo() {
        return this.Tipo;
    }

    public void setTipo(String T) {
        this.Tipo = T;
    }

    public String getDono() {
        return this.Dono;
    }

    public void setDono(String D) {
        this.Dono = D;

    }

    public float getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(Saldo S) {
        this.Saldo = S;
    }

    public boolean getStatus() {
        return this.Status;
    }

    public void setStatus(Status S) {
        this.Status = S;
    }

    public static void main(String[] args) {
        ContaBanco p1 = new ContaBanco();
        p1.setNumconta(1111);
        p1.setDono("Jorge");
        p1.estadoatual();
    }

}