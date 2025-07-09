package ch15.exam01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class PeopleDemo {
    static List<People> peoples = new ArrayList<>();

    public static void readFromFile() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("C:/Users/cyci/Downloads/seoul_people.csv"), "EUC-KR" // 또는 "UTF-8"
                )
        );

        String sLine;
        boolean isFirstLine = true;

        while ((sLine = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }

            StringTokenizer st = new StringTokenizer(sLine, ",");
            if (st.countTokens() != 8) continue;

            String atdrc_nm = st.nextToken().trim();
            int atdrc_code_se = Integer.parseInt(st.nextToken().trim());
            int year_month = Integer.parseInt(st.nextToken().trim());
            int tot_popltn_co = Integer.parseInt(st.nextToken().trim());
            int tot_hshld_co = Integer.parseInt(st.nextToken().trim());
            double hshld_popltn_avrg_co = Double.parseDouble(st.nextToken().trim());
            int male_popltn_co = Integer.parseInt(st.nextToken().trim());
            int female_popltn_co = Integer.parseInt(st.nextToken().trim());

            peoples.add(new People(atdrc_nm, atdrc_code_se, year_month,
                    tot_popltn_co, tot_hshld_co, hshld_popltn_avrg_co,
                    male_popltn_co, female_popltn_co));
        }

        reader.close();
    }

    public static void main(String[] args) {
//        try {
//            readFromFile();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (People p : peoples) {
//            System.out.println(p);
//        }
        //전체 출력

    }

}