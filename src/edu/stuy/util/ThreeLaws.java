package edu.stuy.util;

/**
 *
 * @author Isaac Asimov
 *
 */
public interface ThreeLaws {

    /**
     * 1. A robot may not injure a human being or, through inaction, allow a human being to come to harm.
     */
    public void FirstLaw();

    /**
     * 2. A robot must obey the orders given it by human beings, except where such orders would conflict with the First Law.
     */
    public void SecondLaw();

    /**
     * 3. A robot must protect its own existence as long as such protection does not conflict with the First or Second Law.
     */
    public void ThirdLaw();

    /**
     * 0. A robot may not harm humanity, or, by inaction, allow humanity to come to harm.
     */
    public void oneDividedByZero_Law();

}
