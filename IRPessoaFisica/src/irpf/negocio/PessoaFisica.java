package irpf.negocio;
public class PessoaFisica {

	private String nome;
	private String cpf;
	private int idade;
	private int nDependentes;
	private double contPrev;
	private double totalRendimento;

	public PessoaFisica(String n, String c, int i, int d, double p, double r){
		nome = n;
		cpf = c;
		idade = i;
		nDependentes = d;
		contPrev = p;
		totalRendimento = r;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getnDependentes() {
		return nDependentes;
	}

	public void setnDependentes(int nDependentes) {
		this.nDependentes = nDependentes;
	}

	public double getContPrev() {
		return contPrev;
	}

	public void setContPrev(double contPrev) {
		this.contPrev = contPrev;
	}

	public double getTotalRendimento() {
		return totalRendimento;
	}

	public void setTotalRendimento(double totalRendimento) {
		this.totalRendimento = totalRendimento;
	}
}