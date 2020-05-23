package metier;

import java.util.Date;

public class CompteCourant extends Compte{
	
	public double decouvert;

	@Override
	public void retirer(double mt) {
		if(mt>solde+decouvert) throw new RuntimeException("solde insuffisant") ;
		
		Retrait r = new Retrait(operation.size()+1, new Date(), mt);
		
		operation.add(r);
		solde=solde-mt;
		
	}

	@Override
	public void UpdateSolde() {
		// TODO Auto-generated method stub
		
	}

	public CompteCourant() {
		super();
	}

	public CompteCourant(int code, double solde, double decouvert) {
		super(code, solde);
		this.decouvert = decouvert;
	}
	
	

}
