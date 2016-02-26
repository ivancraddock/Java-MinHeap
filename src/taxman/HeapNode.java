package taxman;

public class HeapNode implements Comparable<HeapNode> {
    private int id;
    private int income;
   
    public HeapNode(int t_id, int t_income){
        this.id = t_id;
        this.income = t_income;
    }
   
    public int getId(){
        return this.id;
    }
   
    public int getIncome(){
        if (this.income <= 0)
            return 0;
        return this.income;
    }

    @Override
    public int compareTo(HeapNode that) {
        return this.income - that.income;
    }
   
    public String toString(){
        return(""+this.id+"; "+this.income);
       
    }
}