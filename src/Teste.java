public class Teste {

    public static void main(String[] args) {
        Empregado[] empregados = criarEmpregados();

        processarEmpregadosIndividualmente(empregados);
        processarEmpregadosPolimorficamente(empregados);
    }

    private static Empregado[] criarEmpregados() {
        return new Empregado[] {
            new EmpregadoAssalariado("John", "Smith", "111-11-1111", 800.00),
            new EmpregadoHorista("Karen", "Price", "222-22-2222", 16.75, 40.0),
            new EmpregadoComissionado("Sue", "Jones", "333-33-3333", 10000.00, 0.06),
            new EmpregadoMisto("Bob", "Lewis", "444-44-4444", 10000.00, 0.06, 300.00)
        };
    }

    private static void processarEmpregadosIndividualmente(Empregado[] empregados) {
        System.out.println("Empregados Processados Individualmente: \n");
        for (Empregado emp : empregados) {
            System.out.println(emp + "\n");
        }
    }

    private static void processarEmpregadosPolimorficamente(Empregado[] empregados) {
        System.out.println("Empregados Processados Polimorficamente: \n");
        for (Empregado emp : empregados) {
            if (emp instanceof EmpregadoMisto) {
                EmpregadoMisto em = (EmpregadoMisto) emp;
                em.setSalarioBase(em.getSalarioBase() * 1.10);
            }
            System.out.println(emp + "\n");
        }
    }
}