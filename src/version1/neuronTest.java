package version1;

public class neuronTest {
    public static void main(String[] args) {
        //bpComp.train(1.5, 10);

        // untrained model query
        //bpComp.untrainedQuery();    // changes when trained, find a better point to pick weight

        // training
        bpComp.train(1.5, 10);

        // trained model query
        bpComp.query(1,1);
    }
}