public class TestaConstrutor {
	public static void main(String[] args) {
		Conta conta = new Conta(1337, 10025);
		System.out.println("A agencia � " + conta.getAgencia() + " e a conta � " + conta.getConta());
		
		Conta outraConta = new Conta(-20, 10);
		System.out.println("A agencia � " + outraConta.getAgencia() + " e a conta � " + outraConta.getConta());
		
		System.out.println(Conta.getTotal());
	}
}
