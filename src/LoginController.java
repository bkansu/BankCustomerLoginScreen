public class LoginController {
    boolean loginControl(Bank bank, int id, String pass){

        boolean flag = false;
        for (int i = 0; i < bank.getMusteriList().size(); i++) {
            if(bank.getMusteriList().get(i).getHesapNo()==id){
                if(bank.getMusteriList().get(i).getParola().equals(pass)){
                    flag = true;
                }

            }
        }
        return flag;

    }
}
