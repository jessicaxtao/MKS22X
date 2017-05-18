public interface Frontier {

    public void add(Location a);
    public Location next();
    public Location peek();
    public int size();
    public boolean hasNext();
 
}
