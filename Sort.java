
public class Sort {
	//METODO DI ORDINAMENTO HEAP SORT
	public static void heapSort(double[] A) {
		//prende un generico vettore e lo riordina in un HEAP
		PriorityQueue H = new PriorityQueue(A.length);// si crea nuovo vettore di uguale dimensione di quello A da ordinare
		for (int i=0; i<A.length; i++)//si scandiscono elementi del vettore
			H.insert(A[i]);//copia elementi del vettore A nel nuovo vettore H e poi dopo ogni inserimento riordina
		                   //NB: chiama metodo insert della classe PriorityQueue
		System.out.print("Heap:          ");
		System.out.println(H);//stama il vettore H riodrinato , scrittura ammissibile si � implementato metodo toString
		
		for (int i=0; i<A.length; i++) {//scandisce il vettore A che andava ordinato
			A[i] = H.deleteMin(); // copia nel vettore A gli elementi ordinati del vettore H , facendo riferimento alla funzione deleteMin della classe 
			                     // coda di priorit� che elimina la testa del vettore ordinato e lo restituisce. Cosi facendo a fine ciclo il vettore A sar� ordinato
		}
	}
	
	public static void print(double[] A) {// METODO DI STAMPA 
		System.out.print("[");;
		for (int i=0; i<A.length; i++)
			System.out.print(A[i] + ", ");
		System.out.println("]");

	}
	
}
