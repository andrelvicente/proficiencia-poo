public class Fatura implements Pagavel {
    private final String numeroPeca, descricaoPeca;
    private int quantidade;
    private double precoItem;

    public Fatura(String numeroPeca, String descricaoPeca, int quantidade, double precoItem) {
        this.numeroPeca = numeroPeca;
        this.descricaoPeca = descricaoPeca;
        setQuantidade(quantidade);
        setPrecoItem(precoItem);
    }

    public String getNumeroPeca() {
        return numeroPeca;
    }

    public String getDescricaoPeca() {
        return descricaoPeca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
    }

    public void setPrecoItem(double precoItem) {
        if (precoItem < 0.0) {
            throw new IllegalArgumentException("Preço do item não pode ser negativo.");
        }
        this.precoItem = precoItem;
    }

    @Override
    public double calculaPagamento() {
        return quantidade * precoItem;
    }

    @Override
    public String toString() {
        return String.format("Fatura:\nNúmero da peça: %s (%s)\nQuantidade: %d\nPreço por item: $%.2f",
                numeroPeca, descricaoPeca, quantidade, precoItem);
    }
}
