package metier;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		try {
		
		Compte cp1 = new CompteCourant(1,8000,500);
		Compte cp2 = new CompteCourant(2,3000,5.5);

		cp1.verser(5000);
		cp1.retirer(500);
		cp1.virement(400, cp1);
		
		cp1.verser(8000);
		cp1.retirer(2000);
		
		System.out.println("Solde du compte cp1 =" +cp1.ConsulterSolde());
		System.out.println("Solde du compte cp2 =" +cp2.ConsulterSolde());
		
		System.out.println("-----------------------------");
		
		
		
		
		List<Operation> listOperation = cp1.getOperation();
		
		for (Operation op : listOperation) {
			if(op instanceof Versement)
			System.out.println(op.getNumero()+"---"+op.getDateOperation()+"---"+op.getMontant());
			
		}
		System.out.println("Total de versement du compte cp1 =" +cp1.TotalVersement());
		System.out.println("Total de versement du compte cp2 =" +cp2.TotalVersement());
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}
}
