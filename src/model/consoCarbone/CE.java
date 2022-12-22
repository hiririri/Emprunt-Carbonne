package model.consoCarbone;

/**
 * The enum of House Energy Rating.
 *
 * @author Qinming JIANG
 * @author Shenqi MA
 * @version 1.0
 */
public enum CE {
    /**
     * Level A Energy Rating.
     */
    A(0.005),
    /**
     * Level B Energy Rating.
     */
    B(0.01) ,
    /**
     * Level C Energy Rating.
     */
    C(0.02) ,
    /**
     * Level D Energy Rating.
     */
    D(0.035),
    /**
     * Level E Energy Rating.
     */
    E(0.055),
    /**
     * Level F Energy Rating.
     */
    F(0.08) ,
    /**
     * Level G Energy Rating.
     */
    G(0.1)  ;

    /**
     * The coefficient.
     */
    public final double alpha;

    private CE(double alpha) {
        this.alpha = alpha;
    }
}
