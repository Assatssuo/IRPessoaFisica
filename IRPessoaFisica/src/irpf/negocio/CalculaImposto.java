package irpf.negocio;

public class CalculaImposto {
	private PessoaFisica pessoa;

	public CalculaImposto(PessoaFisica pessoa){
		this.pessoa = pessoa;
	}
	
	public double decSimples(){
		double base = pessoa.getTotalRendimento() - pessoa.getContPrev();
		base = base*0.95;
		double x = (base-12000)*0.15;
		
		if(base <= 12000){
			return 0.0;
		} else if (base > 12000 && base < 24000){
			return x;
		} else {
			return x + (base-24000)*0.275;
		}
	}
	
	public double decCompleta(){
		double base = pessoa.getTotalRendimento() - pessoa.getContPrev();
		if(pessoa.getIdade()< 65){
			if(pessoa.getnDependentes() <= 2){
				base = base*0.02;
			} else if (pessoa.getnDependentes() <= 5 ){
				base = base*0.035;
			} else {
				base = base*0.05;
			}
		} else {
			if(pessoa.getnDependentes() <= 2){
				base = base*0.03;
			} else if (pessoa.getnDependentes() <= 5 ){
				base = base*0.045;
			} else {
				base = base*0.06;
			}
		}
		
		double x = (base-12000)*0.15;
		if(base <= 12000){
			return 0.0;
		} else if (base > 12000 && base < 24000){
			return x;
		} else {
			return x + (base-24000)*0.275;
		}
	}
	
	
}