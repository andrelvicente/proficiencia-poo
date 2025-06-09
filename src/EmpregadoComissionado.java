public class EmpregadoComissionado extends Empregado implements Pagavel {
    private double vendasBrutasSemanais, taxaComissao;

    public EmpregadoComissionado(String nome, String sobrenome, String numeroSeguroSocial,
            double vendasBrutasSemanais, double taxaComissao) {
        super(nome, sobrenome, numeroSeguroSocial);
        setVendasBrutasSemanais(vendasBrutasSemanais);
        setTaxaComissao(taxaComissao);
    }

    public double getVendasBrutasSemanais() {
        return vendasBrutasSemanais;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setVendasBrutasSemanais(double vendasBrutasSemanais) {
        if (vendasBrutasSemanais < 0.0) {
            throw new IllegalArgumentException("Vendas brutas semanais deve ser maior ou igual a zero.");
        }
        this.vendasBrutasSemanais = vendasBrutasSemanais;
    }

    public void setTaxaComissao(double taxaComissao) {
        if (taxaComissao <= 0.0 || taxaComissao >= 1.0) {
            throw new IllegalArgumentException("Taxa de comissão deve ser maior que zero e menor que 1.");
        }
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double calculaPagamento() {
        return vendasBrutasSemanais * taxaComissao;
    }

    @Override
    public String toString() {
        return String.format(
                "Empregado Comissionado: %s %s\nNúmero do Seguro Social: %s\nVendas Brutas Semanais: $%,.2f\nTaxa de Comissão: %.2f",
                getNome(), getSobrenome(), getNumeroSeguroSocial(), getVendasBrutasSemanais(), getTaxaComissao());
    }
}
