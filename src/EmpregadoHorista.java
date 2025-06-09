public class EmpregadoHorista extends Empregado implements Pagavel {
    private double salarioHora, horasTrabalhadas;

    public EmpregadoHorista(String nome, String sobrenome, String numeroSeguroSocial, double salarioHora,
            double horasTrabalhadas) {
        super(nome, sobrenome, numeroSeguroSocial);
        setSalarioHora(salarioHora);
        setHorasTrabalhadas(horasTrabalhadas);
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setSalarioHora(double salarioHora) {
        if (salarioHora <= 0.0) {
            throw new IllegalArgumentException("Salário por hora deve ser maior que zero.");
        }
        this.salarioHora = salarioHora;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        if (horasTrabalhadas < 0.0) {
            throw new IllegalArgumentException("Horas trabalhadas deve ser maior do que 0");
        }
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calculaPagamento() {
        if (horasTrabalhadas <= 40) {
            return salarioHora * horasTrabalhadas;
        } else {
            return (salarioHora * 40) + ((horasTrabalhadas - 40) * salarioHora * 1.5);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Empregado Horista: %s %s\nNúmero do Seguro Social: %s\nSalário por Hora: $%,.2f\nHoras Trabalhadas: %.2f",
                getNome(), getSobrenome(), getNumeroSeguroSocial(), getSalarioHora(), getHorasTrabalhadas());
    }

}