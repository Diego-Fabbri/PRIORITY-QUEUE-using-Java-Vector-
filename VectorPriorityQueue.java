
import java.util.Vector;
/*IMPLEMENTAZIONE DELLA CODA DI PRIORITA' FACENDO USO DEI VECTOR
 * NB:valgono le stesse consideraioni dell'implementazione con array solo che le linee di codice si adattano alla nuova struttura dati*/
public class VectorPriorityQueue {

		private Vector<Double> A;
		private int top = 0;// prima poszione disponibile per inserimento
			
		public VectorPriorityQueue() {//costruttore
			A = new Vector<Double>();
		}
						
		public void insert(double v) {//METODO INSERIMENTO DI UN NODO DI CONTENUTO V
			A.add(v);//aggiunge il nodo alla coda di priorit�
			int i = top-1;//variabile che servira nel ciclo per scandire i vettori
			while (i>0 && A.get(i) < A.get((i-1)/2)) {//fino a quando gli elementi non rispettano la condizione di ordinamento
				swap(A,i,(i-1)/2);//si scambiano tali elementi in modo da ordinare il vettore
				i = (i-1)/2;//si riparte dalla posizione dove � avvenuto lo scambio 
			}
			//usciti dal ciclo la coda � ordinata
			top++;//si aggiorna prima poszione disponibile per inserimento
		}
			
		public double deleteMin() {//METODO DI ELIMINAZIONE DEL PRIMO ELEMENTO IN POSZIONE O
			if (A.isEmpty()) {//se la coda � vuota
				System.out.println("Errore: heap vuoto");
				return 0;
			}
			double x = A.get(0);// si salva elemento da eliminare
			A.set(0, A.get(--top));//si sposta elemento in posizione finale al posto iniziale che si libera con estrazione
			int i = 0;//variabile che serve per il ciclo di scansione dell'array al fine di riordinare nuovamente la struttura dopo estrazione
			while ( ((2*i+1)<top && (A.get(i) > A.get(2*i+1))) || ((2*(i+1))<top && (A.get(i) > A.get(2*(i+1)))) ) {//fino a quando
				//inidice di confronto deve essere minore della posizione top         
				//e se non si rispettano entrambe le condizioni di ordinamento
				if ((2*(i+1)) >= top || A.get(2*i+1) < A.get(2*(i+1))) {
					//se la poszione di confronto non esiste
					//oppure se i due elementi di confronto non rispettano condizione ordine
					swap(A,i,2*i+1);// si scambiano i due elementi
					i = 2*i+1;
				}
				else {
					swap(A,i,2*(i+1));
					i = 2*i+2;
				}
			}
			return x;//restituisce elemento eliminato
		}
		
		private void swap(Vector<Double> A, int i, int j) {//FUNZIONE CHE SCAMBIA DUE ELEMENTI
			double tmp = A.get(i); A.set(i,A.get(j)); A.set(j,tmp);
		}
		
		public String toString() {//METODO DI STAMPA DELLA CODA DI PRIORITA'
			return A.toString();
		}
		
}

