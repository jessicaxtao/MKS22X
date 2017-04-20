public class Driver{

    public static void main(String [] args){
	MyLinkedList a= new MyLinkedList();
	System.out.println(a.toString() + "\nSize: "+a.size());
	for(int i = 0; i < 20; i++) {
	    a.add(i);
	}
	    a.remove(3);

	System.out.println(a);

    }

}
