
public class PriorityQueue {
	/*DEFINIZIONE:La coda di priorità è un struttura dati basata su una struttura chiamata HEAP
	 * HEAP:è una struttura dati di elemanti che rispettano una condizione di ordinamento parziale che è la seguente
	 * Vi=1....n-1   si ha che V((i-1)/2)<V(i) dove n=dimensione della struttura dati (numero di elementi)
	 * Ogni elemento in poszione i è più piccolo di ogni elemento in posizione 2i+2 e 2i+1
	 * NB:in tale relazione di ordinamento il valore più piccolo della struttura dati è sempre in posizione iniziale
	 * L'estrazione in una coda di priorità avviene sempre nella posizione iniziale dove giace il primo elemento che è il più piccolo*/
 
	//IMPLEMENTAZIONE CODA PRIORITA' CON ARRAY
		private double[] A;//crea struttura dati ovvero array
		private int top = 0;////indica prima poszione libera per effettuare inserimento
		private int size = 10;//dimensione dell'array
			
		public PriorityQueue() {//costruttore
			A = new double[size];
		}
		
		public PriorityQueue(int k) {//costruttore che prende in input la dimesione dell'array da creare
			size = k;
			A = new double[size];
		}

		public boolean isFull() { //metodo che ci dice se array è pieno
			if(top==size)
				return true;
			else
				return false;
		}
		
		public boolean isEmpty() {//ci dice se array è vuoto o meno
			if(top==0)
				return true;
			else 
				return false;
		}
		
		public void insert(double v) {//METODO DI INSERIMENTO DI UN ELEMENTO
			// Il controllo iniziale non è necessario se viene effettuato prima di chiamare il metodo 
			if (this.isFull()) //se struttura è piena 
				System.out.println("Errore: heap pieno");
			else
			A[top] = v;//inserisce elemento in posizione top
			int i = top-1;//variabile che servirà nel ciclo per ordirare il vettore dopo inserimento
			while (i>0 && A[i] < A[(i-1)/2]) {//se le condzione di ordinamento parziale dell'heap non sono rispettate
				swap(A,i,(i-1)/2);//scambia elementi in modo che relazione d'ordine sia rispettata
				i = (i-1)/2;
			}
			 top++;//dopo inserimento di aggiorna posizione disponibile
		}
		/*COMPLESSITà DEL METODO insert(double v)
		 * O(log2(n))=è il costo di UN SOLO inserimento.Si inserisce un elemento in poszione n , poi lo si confronta con quello in poszione n/2 , poi con quello in posizione n/4
		 * e così via . Lo spazio su cui si opera va sempre a dimmezzarsi
		 * NB: creare una lista inserendo n elementi costa O(n*log2(n))
		 *  O(1)= nel caso migliore ,ovvero quando non ci sono confronti da fare*/
			
		public double deleteMin() {//METODO DI ELIMINAZIONE DEL PRIMO ELEMENTO IN POSIZIONE O
			if (this.isEmpty()) {//se la struttura è vuota
				System.out.println("Errore: heap vuoto");
				return 0;
			}
			
			double x = A[0];// si salva elemento da eliminare
			A[0] = A[--top];//si sposta elemento in posizione finale al posto iniziale che si libera con estrazione 
			int i = 0;//variabile che serve per il ciclo nella scansione dell'array al fine di riordinare nuovamente la struttura dopo estrazione
			while ( ((2*i+1)<top && (A[i]>A[2*i+1])) || ((2*(i+1))<top && (A[i]>A[2*(i+1)])) )//fino a quando
				//inidice di confronto deve essere minore della posizione top         
				//e se non si rispettano entrambe le condizioni di ordinamento
				if ((2*(i+1))>=top || A[2*i+1] < A[2*(i+1)]) {
					//se la poszione di confronto non esiste
					//oppure se i due elementi di confronto non rispettano condizione ordine
					swap(A,i,2*i+1);// si scambiano i due elementi
					i = 2*i+1;
				}
				else {
					swap(A,i,2*(i+1));
					i = 2*(i+1);
				}
			return x;//restituisce elemento eliminato
		}
		/*COMPLESSITA' DEL MOTODO deleteMin
		* O(log2(n))=è il costo di UN SOLA estrazione nel caso peggiore.Si elimina un elemento in poszione 0 , poi lo si confronta con quello in posizione 1,2 , poi con quello in posizione 1 con quello in posizione 
		 * 3,4 e così via . Lo spazio su cui si opera va sempre a raddoppiare all'aumentare della poszione di confronto
		 * NB: svuotare una lista eliminando n elementi costa O(n*log2(n))
		 * O(1)= nel caso migliore ,ovvero quando non ci sono confronti da fare*/
		
		
		private static void swap(double[] A, int i, int j) {//FUNZIONE SCAMBIA DI DUE ELEMENTI
			double tmp = A[i]; A[i] = A[j]; A[j] = tmp;
		}
		
		public String toString() {
			String s = "["; 
			for (int i=0; i< top; i++)
				s = A[i] + " ";
			s = s + "]";
			return s;
		}		
        public void print(){ // METODO DI STAMPA
	      for(int i=0;i<top;i++)// ciclo che scandisce elementi dell'array
		    System.out.print(A[i]+" ");
	      System.out.println();
	      
}
}


