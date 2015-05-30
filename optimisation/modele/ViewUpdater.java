package optimisation.modele;

public class ViewUpdater implements Runnable {

	private Modele modele;
	
	public ViewUpdater(Modele m){
		modele = m;
	}

	@Override
	public void run() {
		while(true){
			if(modele.hasNext()){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
				modele.miseAJour();
			}
		}
	}
}
