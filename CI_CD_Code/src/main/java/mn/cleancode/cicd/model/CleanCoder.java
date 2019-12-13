package mn.cleancode.cicd.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_cleancoder")
public class CleanCoder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "coderName")
    private String coderName;

    @Column(name = "canCode")
    private boolean canCode;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoderName() {
        return coderName;
    }

    public void setCoderName(String coderName) {
        this.coderName = coderName;
    }

    public boolean isCanCode() {
        return canCode;
    }

    public void setCanCode(boolean canCode) {
        this.canCode = canCode;
    }
}
