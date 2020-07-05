import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank banka = new Bank();
        Musteri  Ismail = new Musteri(326785,   "IsmailBorazan","TR610003",350.00,8000.00,"EU610003","12hrst34");
        Musteri  Kamile = new Musteri(400129,   "KamileHursitogulları","TR610003",350.00,8000.00,"EU610003","IsmB1982");
        Musteri  Zebercet = new Musteri(388000,   "ZebercetBak","TR610003",350.00,8000.00,"EU610003","Zb123456");
        Musteri  NazGul = new Musteri(201005,   "NazGulUcan","TR610003",350.00,8000.00,"EU610003","Mordor99");

        banka.musteriList.add(Ismail);
        banka.musteriList.add(Kamile);
        banka.musteriList.add(Zebercet);
        banka.musteriList.add(NazGul);

        LoginController loginController = new LoginController();
        int id;
        String pass;
        int kalanDenemeHakki = 2;
        System.out.println("-------------------------------------------");
        Scanner scan = new Scanner(System.in);
       while (true) {
           int choise;
           System.out.println("Giris yapmak icin lutfen id giriniz");
           id = scan.nextInt();
           System.out.println("Giris yapmak icin lutfen sifre giriniz");
           pass = scan.next();
           if (loginController.loginControl(banka,id, pass)) {
               System.out.println("Giris BASARILI!!");
               int whoAmI=90;
               System.out.println("Hesap Bilgileriniz : ");
               for (int i = 0; i < banka.getMusteriList().size(); i++) {
                   if(banka.getMusteriList().get(i).getHesapNo() == id ){
                       whoAmI = i;
                       System.out.println("Hesap no : "+banka.getMusteriList().get(i).getHesapNo());
                       System.out.println("Isim - Soyisim : "+banka.getMusteriList().get(i).getAdSoyad());
                       System.out.println("IBAN TR : "+banka.getMusteriList().get(i).getIBANTR());
                       System.out.println("TL birikim miktari : "+banka.getMusteriList().get(i).getMiktarIBANTR());
                       System.out.println("IBAN EURO : "+banka.getMusteriList().get(i).getIBANEURO());
                       System.out.println("Doviz birikim miktari : "+banka.getMusteriList().get(i).getMiktarIBANEURO());
                   }

               }
               System.out.println( " EFT yapmak icin (1) - Cikis yapmak icin farkli bir rakam tuslayiniz... ");
               choise = scan.nextInt();
               if(choise==1){
                   int whom;
                   for (int i = 0; i < banka.getMusteriList().size(); i++) {
                       if(i!=whoAmI){
                           System.out.println(banka.getMusteriList().get(i).getAdSoyad() + " icin " + i+ " tuslayiniz...");
                       }
                   }
                    whom = scan.nextInt();
                    int tlOrUsd;
                    double amount;
                    System.out.println("TL icin 1'i Doviz icin 2'yi tuslayin...");
                   tlOrUsd = scan.nextInt();
                   System.out.println("Transfer Miktarini Giriniz...");
                   amount = scan.nextDouble();
                   if(tlOrUsd == 1){
                       if(amount>banka.getMusteriList().get(whoAmI).getMiktarIBANTR()){
                           while(amount>banka.getMusteriList().get(whoAmI).getMiktarIBANTR()){
                               System.out.println("Bakiyeniz Yetersiz, Lutfen en fazla "+banka.getMusteriList().get(whoAmI).getMiktarIBANTR()+ " TL olacak sekilde giris yapiniz..");
                               amount = scan.nextDouble();
                           }
                       }

                       banka.getMusteriList().get(whoAmI).setMiktarIBANTR(banka.getMusteriList().get(whoAmI).getMiktarIBANTR()-amount);
                       banka.getMusteriList().get(whom).setMiktarIBANTR(banka.getMusteriList().get(whom).getMiktarIBANTR()+amount);
                   }
                   else{

                       if(amount>banka.getMusteriList().get(whoAmI).getMiktarIBANEURO()){
                           while(amount>banka.getMusteriList().get(whoAmI).getMiktarIBANEURO()){
                               System.out.println("Bakiyeniz Yetersiz, Lutfen en fazla "+banka.getMusteriList().get(whoAmI).getMiktarIBANEURO()+ " TL olacak sekilde giris yapiniz..");
                               amount = scan.nextDouble();
                           }
                       }

                       banka.getMusteriList().get(whoAmI).setMiktarIBANEURO(banka.getMusteriList().get(whoAmI).getMiktarIBANEURO()-amount);
                       banka.getMusteriList().get(whom).setMiktarIBANEURO(banka.getMusteriList().get(whom).getMiktarIBANEURO()+amount);
                   }
                   System.out.println("Isleminiz Basariyla Gerceklesmistir !! ");
                   System.out.println("Islem sonrasi hesap durumunuz : ");

                   int i = whoAmI;
                   System.out.println("Hesap no : "+banka.getMusteriList().get(i).getHesapNo());
                   System.out.println("Isim - Soyisim : "+banka.getMusteriList().get(i).getAdSoyad());
                   System.out.println("IBAN TR : "+banka.getMusteriList().get(i).getIBANTR());
                   System.out.println("TL birikim miktari : "+banka.getMusteriList().get(i).getMiktarIBANTR());
                   System.out.println("IBAN EURO : "+banka.getMusteriList().get(i).getIBANEURO());
                   System.out.println("Doviz birikim miktari : "+banka.getMusteriList().get(i).getMiktarIBANEURO());

                   System.out.println("Guvenliginiz icin sistem her islem sonrasi hesabinizdan otomatik olarak cikis yapmaktadir.");
                   System.out.println("Yeniden islem yapmak istiyorsaniz lutfen tekrar giris yapiniz...");
                   System.out.println("Tekrar Giris Yapmak Icin (1) - Cikmak icin(0) tuslayin");
                   int out = scan.nextInt();
                   if(out!=1){
                       System.exit(0);
                   }
                   System.out.println(" --------------------------------------------------- ");

               }
               else{
                   System.exit(0);
               }


           } else {
               if (kalanDenemeHakki >= 0) {

                   System.out.println("Hesap No veya Sifre Yanlis!!" + kalanDenemeHakki + " deneme hakkiniz kaldi.");
                   kalanDenemeHakki--;
               } else {
                   System.out.println("24 Saatligine Erisim Kisitlamasi Cezasi Aldiniz Lutfen 24 saat bekleyiniz...");
                   long start = System.currentTimeMillis();
                   Thread.sleep(86400000);
                   kalanDenemeHakki = 2;
               }
           }
       }
    }
}
