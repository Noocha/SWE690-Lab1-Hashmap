package com.nattagan.ap;

public class Sale {
    String index;
    String sId;
    String name;
    String size;

    public Sale(String value) {

        String replaceString = value.replace("(","");
        replaceString = replaceString.replace(");","");
        replaceString = replaceString.replace("'","");
        String[] ary = replaceString.split(",");

        if (ary.length == 4) {
            this.index = ary[0].toString();
            this.sId = ary[1].toString();
            this.name = ary[2].toString();
            this.size = ary[3].toString();
        } else if (ary.length == 3) {
            this.index = ary[0].toString();
            this.sId = ary[1].toString();
            this.name = ary[2].toString();
        }
    }
}
