package com.example.bassel.Service;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class StringAlignUtil extends Format {

    private static final long serialVersionUID = 1L;

    public enum Alignment {
        LEFT, CENTER, RIGHT,
    }


    /** Current justification for formatting */
    private Alignment currentAlignment;

    /** Current max length in a line */
    private int maxChars;


    public StringAlignUtil(Alignment currentAlignment, int maxChars) {
        switch (currentAlignment){
            case LEFT:
            case CENTER:
            case RIGHT:
                this.currentAlignment=currentAlignment;
                break;

            default: throw new IllegalArgumentException("invalid justification arg");
        }
        if(maxChars <0){
            throw  new IllegalArgumentException("max caractere positive");
        }
        this.maxChars=maxChars;
    }

    @Override
    public StringBuffer format(Object input, StringBuffer toAppendTo, FieldPosition pos) {
        String s =input.toString();
        List<String> strings= splitInputString(s);
        ListIterator<String> ilistitr=strings.listIterator();

        while (ilistitr.hasNext()){
            String perdu=ilistitr.next();
            toAppendTo.append(perdu);
            toAppendTo.append("\n");
        }
        return  toAppendTo;
    }

    protected final void pad(StringBuffer to, int howMany) {
        for (int i = 0; i < howMany; i++)
            to.append(' ');
    }

    @Override
    public Object parseObject(String source, ParsePosition pos) {
        return source;
    }

    String format(String s) {
        return format(s, new StringBuffer(), null).toString();
    }




    private List<String> splitInputString(String str) {
        List<String> list = new ArrayList<String>();
        if (str == null)
            return list;
        for (int i = 0; i < str.length(); i = i + maxChars)
        {
            int endindex = Math.min(i + maxChars, str.length());
            list.add(str.substring(i, endindex));
        }
        return list;
    }
}
