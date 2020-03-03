import java.util.Arrays;

public class ArrayList{
    private int[] data;
    private int last; //index of the last element

    //set initial capacity to 10
    public ArrayList(){
        data = new int[100];      // 23 53465 2435 6446 2324 null null null null
        last = -1;
    }

    //returns the number of elements in the list (not the capacity)
    public int size(){
        return last+1;
    }

    //Precondition: 0 <= index <= last
    //return the element at that index
    public int get(int index){
        return data[index];
    }

    //Precondition:  0 <= index <= last
    //sets the value at index to the newValue
    public void set(int index, int newValue){
        data[index] = newValue;
    }

    //Precondition:  0 <= index <= last
    //value at index is removed from the list – all elements shift down
    //returns removed value
    public int remove(int index){
        int x = this.get(index);
        for(int i = index; i < last; i++){    // 0 1 2 4 5 null
            this.set(i, this.get(i+1));
        }
        last--;
        return x;
    }

    //Precondition:  0 <= index <= last+1
    //Inserts newValue at index.  Everything from index on gets shifted up
    public void add(int index, int newValue){
        last++;
        for(int i = last; i > index; i--){          // 0 1 2 4 3 4 5 null null null
            this.set(i, this.get(i-1));
        }
        this.set(index, newValue);
    }

    //adds newValue to the end of the list
    public void add(int newValue){
        this.set(last+1, newValue);
        last++;
    }

    //private method means "not accessible outside the class"
    //This is intentional.
    //This method should double the capacity

    /*private void resize(){

    }*/

    //returns, for example, "[3, 6, 7, 9]"
    //This will be helpful for your debugging
    public String toString(){
        String[] s = new String[this.size()];
        if(this.size() == 0){
            return "[]";
        }
        for(int i = 0; i < this.size(); i++){
            s[i] = Integer.toString(this.get(i));
        }
        //s[this.size() + 1] = Integer.toString(this.get(this.size()));
        return Arrays.toString(s);
    }

    //returns true if two lists have exactly the same elements
    //in exactly the same order
    public boolean equals(ArrayList otherList){
        for(int i = 0; i < this.size(); i++){
            if(otherList.get(i) != this.get(i)){
                return false;
            }
        }
        return true;
    }

}