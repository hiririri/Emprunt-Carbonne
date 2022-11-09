package consoCarbone;

public class ServicePublics extends ConsoCarbone {
    public static ServicePublics instance;

    public static ServicePublics creatServicePublics() {
        return (ServicePublics.instance == null) ? new ServicePublics() : null;
    }

    private ServicePublics() {
        this.calculImpact();
    }

    @Override
    public int compareTo(ConsoCarbone o) {
        return 0;
    }

    @Override
    public void calculImpact() {
        this.impact = 1.5 * 1750;
    }
}
