package irpf.negocio;

import java.util.List;

public interface Cadastro {
	
	public void Add(PessoaFisica pessoa);
	
	public void update(String nome, String cpf, int idade, int nDependentes, double previdencia, double rendimento);
	
	public void delete(String cpf);
	
	public PessoaFisica getPessoa(String cpf);
	
	public List<PessoaFisica> getLista();
	
}
