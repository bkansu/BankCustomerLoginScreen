public abstract class MusteriCls {
    protected int hesapNo;
    protected String adSoyad;
    protected String IBANTR;
    protected double miktarIBANTR;

    public MusteriCls(int hesapNo, String adSoyad, String IBANTR, double miktarIBANTR) {
        this.hesapNo = hesapNo;
        this.adSoyad = adSoyad;
        this.IBANTR = IBANTR;
        this.miktarIBANTR = miktarIBANTR;
    }

    public int getHesapNo() {
        return hesapNo;
    }

    public void setHesapNo(int hesapNo) {
        this.hesapNo = hesapNo;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getIBANTR() {
        return IBANTR;
    }

    public void setIBANTR(String IBANTR) {
        this.IBANTR = IBANTR;
    }

    public double getMiktarIBANTR() {
        return miktarIBANTR;
    }

    public void setMiktarIBANTR(double miktarIBANTR) {
        this.miktarIBANTR = miktarIBANTR;
    }
}
