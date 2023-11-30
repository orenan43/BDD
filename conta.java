import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

// A classe Conta é usada para implementar os passos do teste Cucumber
public class Conta {

    private ContaSteps conta; // Objeto para manipular as operações da conta
    private int saque; // Variável para armazenar o valor do saque

    // Método para configurar o estado inicial do cliente especial com saldo suficiente
    @Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
    public void um_cliente_especial_com_saldo_atual_de_reais_cenario1(int saldo) throws Throwable {
        conta = new ContaSteps(saldo, true); // Cria uma conta com o saldo fornecido e marca como cliente especial
    }

    // Método para realizar um saque com um valor específico
    @When("^For solicitado um saque no valor de (\\d+) reais$")
    public void for_solicitado_um_saque_no_valor_de_reais_cenario1(int saque) throws Throwable {
        this.setSaque(saque); // Armazena o valor do saque na variável
        conta.saque(saque); // Chama o método 'saque' da classe ContaSteps
    }

    // Método para verificar se o saldo após o saque é o esperado
    @Then("^Deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais_cenario1(int saldoEsperado) throws Throwable {
        assertEquals(saldoEsperado, conta.getSaldo()); // Verifica se o saldo atual é igual ao saldo esperado
        assert conta.getSaldo() == saldoEsperado; // Outra forma de verificar o saldo esperado
    }

    // Implementação específica para um cenário diferente
    @Given("^Um cliente especial com saldo atual de -3000 reais$")
    public void um_cliente_especial_com_saldo_atual_de_3000_reais() throws Throwable {
        conta = new ContaSteps(-3000, true); // Cria uma conta com saldo inicial de -3000 para um cliente especial
    }

    @When("^For solicitado um saque no valor de 1000 reais$")
    public void for_solicitado_um_saque_no_valor_de_1000_reais() throws Throwable {
        this.setSaque(1000); // Armazena o valor do saque na variável
        conta.saque(1000); // Chama o método 'saque' da classe ContaSteps
    }

    @Then("^Deve efetuar o saque e atualizar o saldo da conta para -4000 reais$")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_4000_reais() throws Throwable {
        assertEquals(-4000, conta.getSaldo()); // Verifica se o saldo atual é igual a -4000
        assert conta.getSaldo() == -4000; // Outra forma de verificar o saldo esperado
    }

    // Métodos getter e setter para a variável 'saque'
    public int getSaque() {
        return saque;
    }

    public void setSaque(int saque) {
        this.saque = saque;
    }
}
