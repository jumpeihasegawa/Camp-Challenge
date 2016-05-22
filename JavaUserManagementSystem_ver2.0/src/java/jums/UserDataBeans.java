package jums;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 *
 * @author hayashi-s
 */
public class UserDataBeans implements Serializable {

    private String name;
    private int year;
    private int month;
    private int day;
    private String tell;
    private int type;
    private String comment;
    //検索したユーザーIDを表示するため
    private int userID;
    //検索した登録日時を表示するため
    private Timestamp newDate;

    public UserDataBeans() {
        this.name = "";
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.tell = "";
        this.type = 0;
        this.comment = "";
        //検索したユーザーIDを表示するため
        this.userID = 0;
        //検索した登録日時を表示するため
        this.newDate = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //空文字(未入力)の場合空文字をセット
        if (name.trim().length() == 0) {
            this.name = "";
        } else {
            this.name = name;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(String year) {
        //初期選択状態の場合0をセット
        if (year.equals("")) {
            this.year = 0;
        } else {
            this.year = Integer.parseInt(year);
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(String month) {
        if (month.equals("")) {
            this.month = 0;
        } else {
            this.month = Integer.parseInt(month);
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(String day) {
        if (day.equals("")) {
            this.day = 0;
        } else {
            this.day = Integer.parseInt(day);
        }
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        if (tell.trim().length() == 0) {
            this.tell = "";
        } else {
            this.tell = tell;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null) {
            this.type = 0;
        } else {
            this.type = Integer.parseInt(type);
        }

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if (comment.trim().length() == 0) {
            this.comment = "";
        } else {
            this.comment = comment;
        }
    }

    //検索したユーザーIDを表示するため
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }

    public ArrayList<String> chkproperties() {
        ArrayList<String> chkList = new ArrayList<String>();
        if (this.name.equals("")) {
            chkList.add("name");
        }
        if (this.year == 0) {
            chkList.add("year");
        }
        if (this.month == 0) {
            chkList.add("month");
        }
        if (this.day == 0) {
            chkList.add("day");
        }
        if (this.tell.equals("")) {
            chkList.add("tell");
        }
        if (this.type == 0) {
            chkList.add("type");
        }
        if (this.comment.equals("")) {
            chkList.add("comment");
        }

        return chkList;
    }

    public void UD2DTOMapping(UserDataDTO udd) {
        udd.setName(this.name);
        if (this.year != 0 || this.month != 0 || this.day != 0) {
            Calendar birthday = Calendar.getInstance();
            if (this.month == 0 || this.day == 0) {
                birthday.set(this.year, 0, 1);
            } else {
                birthday.set(this.year, (this.month) - 1, this.day);
            }
            udd.setBirthday(birthday.getTime());
        } else {
            udd.setBirthday(null);
        }
        udd.setTell(this.tell);
        udd.setType(this.type);
        udd.setComment(this.comment);
        udd.setUserID(this.userID);
    }

    //表示用に変換
    public void DTO2UDMapping(UserDataDTO udd) {
        this.setName(udd.getName());
        String Birthday = udd.getBirthday().toString();
        String[] Y_M_D = Birthday.split("-");
        this.setYear(Y_M_D[0]);
        this.setMonth(Y_M_D[1]);
        this.setDay(Y_M_D[2]);
        this.setTell(udd.getTell());
        this.setType(String.valueOf(udd.getType()));
        this.setComment(udd.getComment());
        this.setUserID(udd.getUserID());
        this.setNewDate(udd.getNewDate());
   }
}
