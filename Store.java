package vrp;

public class Store{
    int demand;
    int recyclables;
    int x,y;

    public Store(int demand){
        this.demand = demand;        
    }
    public Store(int demand, int x, int y){
        this.demand = demand;
        this.x = x;
        this.y = y;
    }
    public Store(int demand, int recyclables){
        this.demand = demand;
        this.recyclables = recyclables;

        @override
        public String toString(){
            return "Store [demand=" + demand + ", recyclables=" + recyclables + "]";
        }
    }
}