package irpf.userInterface;

import java.util.List;
import java.util.Scanner;

import irpf.negocio.Cadastro;
import irpf.negocio.CalculaImposto;
import irpf.negocio.PessoaFisica;
import irpf.persistencia.PessoaFisicaDAO;

public class IRPFConsole {
	
	private static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		Cadastro lista = new PessoaFisicaDAO();
		int acao = 1;
		while (acao != 0) {

			acao = definirAcao();
			if(acao!=0){
				switch (acao) {
				case 1:
					PessoaFisica pessoa = CriaPessoaFisica();
					lista.Add(pessoa);
					break;

				case 2:
					ListarPessoas(lista);
					break;
				case 3:
					CalcularIRPF(lista);
					break;
				default:
					System.out.println("Numero invalido");
					break;
				}
			}
			
			System.out.println("-------------------------------------------");
		}
	}
	
	public static int definirAcao() {

		System.out.println("Digite o numero correpondente a ação que deseja executar");
		System.out.println("0 - Sair");
		System.out.println("1 - Adicionar pessoa fisica");
		System.out.println("2 - Listar Pessoas");
		System.out.println("3 - Calcular IRPF");
		return ler.nextInt();
	}

	public static PessoaFisica CriaPessoaFisica() {
		System.out.println("Nome:");
		String nome = ler.next();
		System.out.println("CPF:");
		String cpf = ler.next();		
		System.out.println("Idade:");
		int idade = ler.nextInt();
		System.out.println("Numero de dependentes:");
		int numDependentes = ler.nextInt();
		System.out.println("Contribuição para previdencia:");
		double previdencia = ler.nextDouble();
		System.out.println("Rendimento Total:");
		double rendimentoTotal = ler.nextDouble();
		
		return new PessoaFisica(nome,cpf,idade,numDependentes,previdencia,rendimentoTotal);
		
	}

	public static void ListarPessoas(Cadastro lista) {
		if(!(lista.getLista() == null|| lista.getLista().isEmpty())){
			for(PessoaFisica pf:lista.getLista()){
				System.out.println("Nome:"+pf.getNome()
						+ ","
						+ "CPF:"+pf.getCpf()
						+ ","
						+ "Idade:"+pf.getIdade()
						+ ","
						+ "N° Dependentes:"+pf.getnDependentes()
						+ ","
						+ "Contr.Previdencia:"+pf.getContPrev()
						+ ","
						+ "Rentimento Total:"+pf.getTotalRendimento());
			}
		}else{
			System.out.println("Não há pessoas cadastradas");
		}			
	}
	public static void CalcularIRPF(Cadastro lista){
		
		int acao = 1;
		while(acao != 0){
			acao = definirAcaoCalculo();
			if(acao!= 0){
				System.out.println("Digite o cpf da pessoa qie deseja realizar o calculo:");
				String cpf = ler.next();
				PessoaFisica pessoa = lista.getPessoa(cpf);
				if(!(pessoa == null)){
					CalculaImposto calcula = new CalculaImposto(pessoa);
					
					switch (acao) {
					case 1:
						System.out.println("Declaração simples de "+pessoa.getNome()+": R$"+calcula.decSimples() );
						break;
					case 2:
						System.out.println("Declaração simples de "+pessoa.getNome()+": R$"+calcula.decCompleta() );
						break;
					default:
						System.out.println("Numero invalido");
						break;
					}
				}else{
					System.out.println("cpf inválido");
				}
				System.out.println("-------------------------------------------");
			}			
		}		
	}
	
	public static int definirAcaoCalculo() {
		System.out.println("Digite o numero correpondente ao tipo de calculo que deseja executar");
		System.out.println("0 - Voltar para o menu principal");
		System.out.println("1 - Declaração Simples");
		System.out.println("2 - Declaração Completa");
		return ler.nextInt();
	}
}
