import java.io.*;
import java.util.Scanner;

public class DosyaProjem {

    String  kullaniciAdi,sifre;
    ;
    int deneme=0;
    int maxDeneme=3;

    public DosyaProjem(String kullaniciAdi, String sifre, int deneme, int maxDeneme) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.deneme = deneme;
        this.maxDeneme = maxDeneme;
    }

    public  void dosyaOlusturma(){
        Scanner input=new Scanner(System.in);
        System.out.print("Lütfen dosya ismini giriniz:");
        String dosyaAdi=input.nextLine();
        File dosya=new File(dosyaAdi);
        try {
            if(dosya.createNewFile()){
                System.out.println("Dosya başarılı bir şekilde oluşturuldu.");
            }else{
                System.out.println("Bu dosya sistemde mevcuttur");
            }
        }catch (IOException e){
            System.out.println("Dosya oluştuma hatası: "+e.getMessage());
        }
        try{
            FileWriter writer=new FileWriter(dosya);
            System.out.println("Notunuzu giriniz. Çıkmak için (q) tuşuna basınız.");
            String not;
            while (true){
                not=input.nextLine();
                if(not.equals("q")){
                    System.out.println("Başarılı bir şekilde çıkış yapıldı.");
                    break;

                }
                writer.write(not + "\n");
            }
            writer.close();
            System.out.println("Dosya yazma işlemi başarılı bir şekilde gerçekleşmiştir.");
        }catch (IOException e){
            System.out.println("Dosya yazma hatası"+e.getMessage());
        }

    }
    public  void kullaniciBilgileri(){
        Scanner input=new Scanner(System.in);
        while (deneme<maxDeneme){
            System.out.print("Lütfen kullanıcı adınızı giriniz:");
            this.kullaniciAdi=input.nextLine();
            System.out.print("Lütfen şifrenizi giriniz:");
            this.sifre=input.nextLine();
            if(this.kullaniciAdi.equals("ismail_5845") && this.sifre.equals("45255")){
                System.out.println("Sisteme başarılı bir şekilde giriş yaptınız.");
                dosyaOlusturma();

                break;

            }else{
                System.out.println("Kullanıcı adı  veya şifre hatası.Lütfen tekrar deneyiniz.");
                this.deneme++;
                int kalanDeneme=this.maxDeneme-this.deneme;
                System.out.println("Kalan deneme hakkınız:"+kalanDeneme);
                if(kalanDeneme==0){
                    System.out.println("Şifreniz kullanım dışı olmuştur.Lütfen en kısa sürede bizimle iletişime geçiniz.");
                }

            }
        }


    }

    public void dosyaOkuma(){
        System.out.println("===============================");
        System.out.println("Dosyayı okuma işemi");
        try {
            File dosya =new File("java.txt");
            FileReader reader=new FileReader(dosya);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String satir;
            while((satir=bufferedReader.readLine())!=null){
                System.out.println(satir);
            }
        }catch (FileNotFoundException e){
            System.out.println("Dosya bulunamadı");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("Dosya okunurken hata meydana geldi"+e.getMessage());
        }


    }

    public static void main(String[] args) {
        DosyaProjem dosyam=new DosyaProjem("ismail_5845","45255",0,3);
        dosyam.kullaniciBilgileri();
        dosyam.dosyaOkuma();


    }
}
