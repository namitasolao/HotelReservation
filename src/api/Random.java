package api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Random {
//    public static void main(String args[]){
//
//        String oldDate = "2017-01-29";
//        System.out.println("Date before Addition: "+oldDate);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();
//        try{
//            c.setTime(sdf.parse(oldDate));
//        }catch(ParseException e){
//            e.printStackTrace();
//        }
//
//        c.add(Calendar.DAY_OF_MONTH, 7);
//
//        String newDate = sdf.format(c.getTime());
//        System.out.println("Date after Addition: "+newDate);
//    }
    public static void main(String args[]) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date checkOutDate = new SimpleDateFormat("MM/dd/yyyy").parse("01/03/2020");

        System.out.println("1 "+checkOutDate);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(checkOutDate);
        c2.add(Calendar.DAY_OF_MONTH, 7);

        Date output = (c2.getTime());

        System.out.println("dvd"+(output));

        //System.out.println(checkOutDate);
        //checkOutDate = new SimpleDateFormat("dd/mm/yyy").parse(String.valueOf(checkOutDate));
    }
}


