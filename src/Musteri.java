public class Musteri extends  MusteriCls implements MusteriAbs {

    protected double miktarIBANEURO;
    protected String IBANEURO;
    protected String parola;

    public Musteri(int hesapNo, String adSoyad, String IBANTR, double miktarIBANTR, double miktarIBANEURO, String IBANEURO, String parola) {
        super(hesapNo, adSoyad, IBANTR, miktarIBANTR);
        this.miktarIBANEURO = miktarIBANEURO;
        this.IBANEURO = IBANEURO;
        this.parola = parola;
    }

    public double getMiktarIBANEURO() {
        return miktarIBANEURO;
    }

    public void setMiktarIBANEURO(double miktarIBANEURO) {
        this.miktarIBANEURO = miktarIBANEURO;
    }

    public String getIBANEURO() {
        return IBANEURO;
    }

    public void setIBANEURO(String IBANEURO) {
        this.IBANEURO = IBANEURO;
    }

    protected String getParola() {
        return parola;
    }


}
