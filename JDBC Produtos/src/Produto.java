public class Produto {
    private String nome;
    private double preco;
    private int qntd;

    public Produto(String nome, double preco, int qntd){
        this.nome = nome;
        this.preco = preco;
        this.qntd = qntd;

    }

    public Produto(){}

    public String getNome(){
        return this.nome;

    }
    public void setNome(String nome){
        this.nome = nome;

    }

    public double getPreco(){
        return this.preco;

    }
    public void setPreco(double preco) {
        this.preco = preco;

    }

    public int getQntd(){
        return this.qntd;

    }
    public void setQntd(int qntd){
        this.qntd = qntd;

    }

}
