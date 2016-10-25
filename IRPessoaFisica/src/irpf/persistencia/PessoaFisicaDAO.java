package irpf.persistencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import irpf.negocio.Cadastro;
import irpf.negocio.PessoaFisica;

public class PessoaFisicaDAO implements Cadastro {

	private List<PessoaFisica> pessoas;
	
	public PessoaFisicaDAO(){
		pessoas = new ArrayList<PessoaFisica>();
	}
	
	public void Add(PessoaFisica pessoa){
		pessoas.add(pessoa);
	}
	
	public void update(String nome, String cpf, int idade, int nDependentes, double previdencia, double rendimento){
		PessoaFisica pessoa = getPessoa(cpf);
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		pessoa.setnDependentes(nDependentes);
		pessoa.setContPrev(previdencia);
		pessoa.setTotalRendimento(rendimento);
	}
	
	public void delete(String cpf){
		Iterator<PessoaFisica> i = pessoas.iterator();
		while (i.hasNext()) {
		   PessoaFisica s = i.next();
		   if(s.getCpf().equals(cpf)){
			   i.remove();
		   }		   
		}
	}
	
	public PessoaFisica getPessoa(String cpf){
		Iterator<PessoaFisica> i = pessoas.iterator();
		while (i.hasNext()) {
		   PessoaFisica pFisica = i.next();
		   if(pFisica.getCpf().equals(cpf)){
			   return pFisica;
		   }		   
		}
		return null;
	}
	
	public List<PessoaFisica> getLista(){
		return pessoas;
	}
	
	
}