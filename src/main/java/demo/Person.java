package demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    private  int pId;
    private Name n;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public Name getN() {
        return n;
    }

    public void setN(Name n) {
        this.n = n;
    }


}
