package ch15.exam01;

public class People {
    private int atdrc_code_se;       //자치구 코드
    private String atdrc_nm;               //자치구 명
    private int year_month;             //년 월
    private int tot_popltn_co;          //총 인구 수
    private int tot_hshld_co;           //세대 수
    private double hshld_popltn_avrg_co;   //세대 당 인구
    private int male_popltn_co;         //남자 인구수
    private int female_popltn_co;       //여자 인구수

    public int getAtdrc_code_se() {
        return atdrc_code_se;
    }

    public String getAtdrc_nm() {
        return atdrc_nm;
    }

    public int getYear_month() {
        return year_month;
    }

    public int getTot_popltn_co() {
        return tot_popltn_co;
    }

    public int getTot_hshld_co() {
        return tot_hshld_co;
    }

    public double getHshld_popltn_avrg_co() {
        return hshld_popltn_avrg_co;
    }

    public int getMale_popltn_co() {
        return male_popltn_co;
    }

    public int getFemale_popltn_co() {
        return female_popltn_co;
    }

    private void setAtdrc_code_se(int atdrc_code_se) {
        this.atdrc_code_se = atdrc_code_se;
    }

    private void setAtdrc_nm(String atdrc_nm) {
        this.atdrc_nm = atdrc_nm;
    }

    private void setYear_month(int year_month) {
        this.year_month = year_month;
    }

    private void setTot_popltn_co(int tot_popltn_co) {
        this.tot_popltn_co = tot_popltn_co;
    }

    private void setTot_hshld_co(int tot_hshld_co) {
        this.tot_hshld_co = tot_hshld_co;
    }

    private void setHshld_popltn_avrg_co(int hshld_popltn_avrg_co) {
        this.hshld_popltn_avrg_co = hshld_popltn_avrg_co;
    }

    private void setMale_popltn_co(int male_popltn_co) {
        this.male_popltn_co = male_popltn_co;
    }

    private void setFemale_popltn_co(int female_popltn_co) {
        this.female_popltn_co = female_popltn_co;
    }

    public People(String atdrc_nm,int atdrc_code_se, int year_month, int tot_popltn_co, int tot_hshld_co, double hshld_popltn_avrg_co
                    , int male_popltn_co, int female_popltn_co)   {
        this.atdrc_nm = atdrc_nm;
        this.atdrc_code_se=atdrc_code_se;
        this.year_month=year_month;
        this.tot_popltn_co=tot_popltn_co;
        this.tot_hshld_co=tot_hshld_co;
        this.hshld_popltn_avrg_co=hshld_popltn_avrg_co;
        this.male_popltn_co=male_popltn_co;
        this.female_popltn_co=female_popltn_co;
    }
    @Override
    public String toString() {
        return String.format("%s (%d), %d: 총인구 %d, 세대수 %d, 평균세대인구 %.2f, 남자 %d, 여자 %d",
                atdrc_nm, atdrc_code_se, year_month, tot_popltn_co, tot_hshld_co,
                hshld_popltn_avrg_co, male_popltn_co, female_popltn_co);
    }
}

