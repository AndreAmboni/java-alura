public class Gerente extends Funcionario {

	 @Override
	 public double getBonificacao() {
		 System.out.println("Bonifica��o do gerente");
		return super.getSalario();
	}
}