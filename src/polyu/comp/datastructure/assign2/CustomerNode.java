package polyu.comp.datastructure.assign2;

/**
 * Created by huanganna on 10/10/16.
 */
public class CustomerNode {

    public String name;
    public CustomerNode next;

    public CustomerNode(String name){
        this.name = name;
        next = null;
    }

    public CustomerNode(String name,CustomerNode next){
        this.name = name;
        this.next = next;
    }

    public String toString(){
        return name;
    }

}
