package metier;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte {
	
	protected int code;
	protected double solde;
	protected List<Operation> operation=new ArrayList<>();
	
	
	public Compte(int code, double solde) {
		super();
		this.code = code;
		this.solde = solde;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void  verser(double mt) {
		Versement v = new Versement(operation.size()+1 , new Date()  ,mt);	
		operation.add(v);
		solde+=mt;
	}
	
	public  abstract void retirer(double mt);

	public void virement(double mt, Compte cp1) {
	
		retirer(mt);
		cp1.verser(mt);
	}
	
	public double ConsulterSolde() {
		return solde;
	}
	
	public abstract void UpdateSolde();
	
	public List<Operation> getOperation() {
		return operation;
		
	}
	public double TotalVersement() {
		double somme =0;
		
		for (Operation o : operation) {
			if(o instanceof Versement) 
				somme = somme+o.getMontant();	
		}
		return somme;
	}
	public double TotalRetrait() {
		double somme =0;
		
		for (Operation o : operation) {
			if(o instanceof Retrait) 
				somme = somme+o.getMontant();	
		}
		return somme;
	}
	
}
