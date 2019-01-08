package com.safe.keyboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SafeKeyboard safeKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText safeEdit = findViewById(R.id.safeEditText);
        LinearLayout keyboardContainer = findViewById(R.id.keyboardViewPlace);
        @SuppressLint("InflateParams") View view = LayoutInflater.from(this).inflate(R.layout.layout_keyboard_containor, null);
        safeKeyboard = new SafeKeyboard(getApplicationContext(), keyboardContainer, safeEdit,
                R.layout.layout_keyboard_containor, view.findViewById(R.id.safeKeyboardLetter).getId());
        safeKeyboard.setDelDrawable(this.getResources().getDrawable(R.drawable.keyboard_delete));
        safeKeyboard.setShiftDrawable(this.getResources().getDrawable(R.drawable.keyboard_shift));
        initData();
    }

    private void initData(){//2403
       int i= stringToAscii("ॣ");
       Log.d("ॣ"+i,"ॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣ\nॣॣ                        ॣॣ\nॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣॣ");
    }
    // 当点击返回键时, 如果软键盘正在显示, 则隐藏软键盘并是此次返回无效
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (safeKeyboard.isShow()) {
                safeKeyboard.hideKeyboard();
                return false;
            }//
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    public static List<String> getNumChars(){
        String json="[\n" +
                "    \"9\",\n" +
                "    \"8\",\n" +
                "    \"7\",\n" +
                "    \"6\",\n" +
                "    \"5\",\n" +
                "    \"4\",\n" +
                "    \"3\",\n" +
                "    \"2\",\n" +
                "    \"1\",\n" +
                "    \"0\"\n" +
                "]";
        List<String> numList=new Gson().fromJson(json,new TypeToken<List<String>>(){}.getType());
        Log.d("数字字符----》",numList.get(0));
        return numList;
    }
    public static List<String> getSymbolChars(){
        String json=
                "[\n" +
                "    \"!\",\n" +
                "    \"@\",\n" +
                "    \"#\",\n" +
                "    \"$\",\n" +
                "    \"%\",\n" +
                "    \"&\",\n" +
                "    \"^\",\n" +
                "    \"(\",\n" +
                "    \")\",\n" +
                "    \"*\",\n" +
                "    \"'\",\n" +
                "    \"\\\"\",\n" +
                "    \"=\",\n" +
                "    \"_\",\n" +
                "    \":\",\n" +
                "    \";\",\n" +
                "    \"?\",\n" +
                "    \"~\",\n" +
                "    \"|\",\n" +
                "    \"+\",\n" +
                "    \"-\",\n" +
                "    \"\\\\\",\n" +
                "    \"/\",\n" +
                "    \"[\",\n" +
                "    \"]\",\n" +
                "    \"{\",\n" +
                "    \"}\",\n" +
                "    \",\",\n" +
                "    \".\",\n" +
                "    \"<\",\n" +
                "    \">\"\n" +
                "]";

        List<String> symbolList=new Gson().fromJson(json,new TypeToken<List<String>>(){}.getType());
        Log.d("符号字符----》",symbolList.get(0));
        return symbolList;
    }
    public static List<String> getLetterChars(){
        String json=
                "[\n" +
                        "    \"a\",\n" +
                        "    \"b\",\n" +
                        "    \"c\",\n" +
                        "    \"d\",\n" +
                        "    \"e\",\n" +
                        "    \"f\",\n" +
                        "    \"g\",\n" +
                        "    \"h\",\n" +
                        "    \"i\",\n" +
                        "    \"j\",\n" +
                        "    \"k\",\n" +
                        "    \"l\",\n" +
                        "    \"m\",\n" +
                        "    \"n\",\n" +
                        "    \"o\",\n" +
                        "    \"p\",\n" +
                        "    \"q\",\n" +
                        "    \"r\",\n" +
                        "    \"s\",\n" +
                        "    \"t\",\n" +
                        "    \"u\",\n" +
                        "    \"v\",\n" +
                        "    \"w\",\n" +
                        "    \"x\",\n" +
                        "    \"y\",\n" +
                        "    \"z\"\n" +
                        "]";

        List<String> letterList=new Gson().fromJson(json,new TypeToken<List<String>>(){}.getType());
        Log.d("英文字符----》",letterList.get(0));
        return letterList;
    }

    /**
     * 字符串转ascii码
     * @param str
     * @return
     */
    public static int stringToAscii(String str){
        char[] chars = str.toCharArray();
        int code = 0;
        for (int i = 0; i < chars.length; i++) {
            Log.d("ASCII码"+chars[i]+" -> ",(int)chars[i]+"");
            code=chars[i];
        }
        return code;
    }
}
