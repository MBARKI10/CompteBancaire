package metier;

import java.util.Date;

public class CompteEpargne extends Compte{
	
	public double taux;

	@Override
	public void retirer(double mt) {
         if(mt>solde) throw new RuntimeException("solde insuffisant") ;
		
		Retrait r = new Retrait(operation.size()+1, new Date(), mt);
		
		operation.add(r);
		solde=solde-mt;
		
	}

	public CompteEpargne(int code, double solde, double taux) {
		super(code, solde);
		this.taux = taux;
	}

	@Override
	public void UpdateSolde() {
		solde =+ solde*(1+taux/1000);
		
	}

}
