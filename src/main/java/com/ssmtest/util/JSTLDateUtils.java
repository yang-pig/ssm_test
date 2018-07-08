package com.ssmtest.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class JSTLDateUtils extends TagSupport {

private static final long serialVersionUID = -3354015192721342312L;


        private String value;

        private String patten;

        public int doStartTag() throws JspException{


            String timeStr = value + "000";
            long time = Long.valueOf(timeStr);
            Date timeDate = new Date(time);


            SimpleDateFormat dateformat =new SimpleDateFormat(patten);

            String s = dateformat.format(timeDate);
            try {
                pageContext.getOut().write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.doStartTag();
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getpatten() {
            return patten;
        }

        public void setpatten(String patten) {
            this.patten = patten;
        }


}