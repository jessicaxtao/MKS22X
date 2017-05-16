public class StackFrontier implements Frontier{

    Stack<Location> frontier;

    public StackFrontier(){
	frontier = new Stack<Location>();
    }

    public void add(Location z){
	frontier.push(z);
    }

    public Location next(){
	return frontier.pop();
    }

}
