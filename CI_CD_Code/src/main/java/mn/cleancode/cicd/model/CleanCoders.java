package mn.cleancode.cicd.model;

import java.util.ArrayList;
import java.util.List;

public class CleanCoders {
    private List<CleanCoder> cleanCoders;

    public List<CleanCoder> getCleanCoderList() {
        if (cleanCoders == null) {
            cleanCoders = new ArrayList<>();
        }
        return cleanCoders;
    }

    public void setCleanCoderList(List<CleanCoder> cleanCoders) {
        this.cleanCoders = cleanCoders;
    }

}
