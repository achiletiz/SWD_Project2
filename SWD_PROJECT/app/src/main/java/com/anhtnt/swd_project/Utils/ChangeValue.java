package com.anhtnt.swd_project.Utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeValue {
    public static String formatDecimalPrice(Float number) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(number) + " đ";
    }
    public  static String getTime(){
        Date thoiGian = new Date();
        SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
        String showTime = dinhDangThoiGian.format(thoiGian.getTime());
        return  showTime;

    }
}
