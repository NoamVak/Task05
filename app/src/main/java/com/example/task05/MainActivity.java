package com.example.task05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn,btn2,btn3,btn4;
    EditText eT,eT2,eT3;
    WebView wV;
    String StringUrl;
    String num1,num2,num3;
    String check1,check2,check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        eT=(EditText)findViewById(R.id.eT);
        eT2=(EditText)findViewById(R.id.eT2);
        eT3=(EditText)findViewById(R.id.eT3);
        wV=(WebView)findViewById(R.id.wV);
        wV.getSettings().setJavaScriptEnabled(true);
        wV.setWebViewClient(new MyWebViewClient());

    }
    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public void Click1(View view) {
        check1=eT.getText().toString();
        int a=check1.indexOf('.');
        boolean bol=true;
        if (eT.getText().toString().matches("")||eT.getText().toString().matches("-")||eT.getText().toString().matches("0")){
            Toast.makeText(this, "ilegal action, try again", Toast.LENGTH_SHORT).show();
            bol=false;
            eT.getText().clear();

        }
        if (check1.indexOf('-')==0&&check1.indexOf('.')==1){
            Toast.makeText(this, "invalid input, try again", Toast.LENGTH_SHORT).show();
            bol=false;
            eT.getText().clear();
        }
        else if (a>=1||a==0){
            if (check1.length()-1==a||eT.getText().toString().matches(".")||a==0){
                Toast.makeText(this, "There is nothing before or after the dot, try again", Toast.LENGTH_SHORT).show();
                eT.getText().clear();
            }
            else{
                num1=eT.getText().toString();
                btn.setClickable(false);
                btn4.setClickable(true);
            }
        }

        else if(bol==true){
            num1=eT.getText().toString();
            btn.setClickable(false);
            btn4.setClickable(true);
        }

    }

    public void Click2(View view) {
        check2=eT2.getText().toString();
        int a=check2.indexOf('.');
        boolean bol=true;
        if (eT2.getText().toString().matches("")||eT2.getText().toString().matches("-")){
            Toast.makeText(this, "ilegal action, try again", Toast.LENGTH_SHORT).show();
            eT2.getText().clear();
            bol=false;
        }
        if (check2.indexOf("-")==0&&check2.indexOf(".")==1){
            Toast.makeText(this, "invalid input, try again", Toast.LENGTH_SHORT).show();
            bol=false;
            eT2.getText().clear();
        }
        else if (a>=1||a==0){
            if (check2.length()-1==a||eT2.getText().toString().matches(".")||a==0){
                Toast.makeText(this, "There is nothing before or after the dot, try again", Toast.LENGTH_SHORT).show();
                eT2.getText().clear();
            }
            else{
                num2=eT2.getText().toString();
                btn2.setClickable(false);
            }
        }
        else if(bol==true){
            num2=eT2.getText().toString();
            btn2.setClickable(false);
        }
    }

    public void Click3(View view) {
        check3=eT3.getText().toString();
        int a=check3.indexOf('.');
        boolean bol=true;
        if (eT3.getText().toString().matches("")||eT3.getText().toString().matches("-")){
            Toast.makeText(this, "ilegal action, try again", Toast.LENGTH_SHORT).show();
            eT3.getText().clear();
            bol=false;
        }
        if (check3.indexOf("-")==0&&check3.indexOf(".")==1){
            Toast.makeText(this, "invalid input, try again", Toast.LENGTH_SHORT).show();
            bol=false;
            eT3.getText().clear();
        }
        else if (a>=1||a==0){
            if (check3.length()-1==a||eT3.getText().toString().matches(".")||a==0){
                Toast.makeText(this, "There is nothing before or after the dot, try again", Toast.LENGTH_SHORT).show();
                eT3.getText().clear();
            }
            else{
                num3=eT3.getText().toString();
                btn3.setClickable(false);
            }
        }
        else if(bol==true){
            num3=eT3.getText().toString();
            btn3.setClickable(false);
        }
    }

    public void Start(View view) {
        if(eT.getText().toString().matches("")||num1==null){
        Toast.makeText(this, "no 'a' value, try again", Toast.LENGTH_SHORT).show();
        }
        else if (num2==null&&num3==null){
            num2="0";
            num3="0";
            StringUrl = "https://www.google.com/search?safe=strict&rlz=1C1CHZL_iwIL706IL706&sxsrf=ALeKk03D7KS81jHgLvXCt_X3yqFfxCoAEw%3A1587994970613&ei=WuGmXu_5JJShgAbs76f4Dg&q="+ num1+"x%5E2%2B"+num2+"%2B"+num3+"&oq="+num1+"x%5E2%2B"+num2+"%2B"+num3+"&gs_lcp=CgZwc3ktYWIQAzoECCMQJ1CxRVixRWDIT2gAcAB4AIABoAWIAZoLkgEJMi0xLjAuMS4xmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjvjoOh3ojpAhWUEMAKHez3Ce8Q4dUDCAw&uact=5";
            wV.loadUrl(StringUrl);
        }
        else if (num2==null){
            num2="0";
            if(num3.charAt(0)=='-'){
                StringUrl="https://www.google.com/search?safe=strict&rlz=1C1CHZL_iwIL706IL706&sxsrf=ALeKk03D7KS81jHgLvXCt_X3yqFfxCoAEw%3A1587994970613&ei=WuGmXu_5JJShgAbs76f4Dg&q="+num1+"x%5E2%2B"+num2+"x-"+num3+"&oq="+num1+"x%5E2%2B"+num2+"x-"+num3+"&gs_lcp=CgZwc3ktYWIQAzoECCMQJ1CxRVixRWDIT2gAcAB4AIABoAWIAZoLkgEJMi0xLjAuMS4xmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjvjoOh3ojpAhWUEMAKHez3Ce8Q4dUDCAw&uact=5";
                wV.loadUrl(StringUrl);
            }
            else{
                StringUrl="https://www.google.com/search?safe=strict&rlz=1C1CHZL_iwIL706IL706&sxsrf=ALeKk03D7KS81jHgLvXCt_X3yqFfxCoAEw%3A1587994970613&ei=WuGmXu_5JJShgAbs76f4Dg&q="+num1+"x%5E2%2B"+num2+"x%2B"+num3+"&oq="+num1+"x%5E2%2B"+num2+"x%2B"+num3+"&gs_lcp=CgZwc3ktYWIQAzoECCMQJ1CxRVixRWDIT2gAcAB4AIABoAWIAZoLkgEJMi0xLjAuMS4xmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjvjoOh3ojpAhWUEMAKHez3Ce8Q4dUDCAw&uact=5";
                wV.loadUrl(StringUrl);
            }
        }
        else if (num3==null){
            num3="0";
            if(num2.charAt(0)=='-'){
                StringUrl="https://www.google.com/search?safe=strict&rlz=1C1CHZL_iwIL706IL706&sxsrf=ALeKk03D7KS81jHgLvXCt_X3yqFfxCoAEw%3A1587994970613&ei=WuGmXu_5JJShgAbs76f4Dg&q="+num1+"x%5E2"+num2+"x%2B"+num3+"&oq="+num1+"x%5E2"+num2+"x%2B"+num3+"&gs_lcp=CgZwc3ktYWIQAzoECCMQJ1CxRVixRWDIT2gAcAB4AIABoAWIAZoLkgEJMi0xLjAuMS4xmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjvjoOh3ojpAhWUEMAKHez3Ce8Q4dUDCAw&uact=5";
                wV.loadUrl(StringUrl);
            }
            else{
                StringUrl="https://www.google.com/search?safe=strict&rlz=1C1CHZL_iwIL706IL706&sxsrf=ALeKk03D7KS81jHgLvXCt_X3yqFfxCoAEw%3A1587994970613&ei=WuGmXu_5JJShgAbs76f4Dg&q="+num1+"x%5E2%2B"+num2+"x%2B"+num3+"&oq="+num1+"x%5E2%2B"+num2+"x%2B"+num3+"&gs_lcp=CgZwc3ktYWIQAzoECCMQJ1CxRVixRWDIT2gAcAB4AIABoAWIAZoLkgEJMi0xLjAuMS4xmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjvjoOh3ojpAhWUEMAKHez3Ce8Q4dUDCAw&uact=5";
                wV.loadUrl(StringUrl);
            }
        }
        else{
            if(num2.charAt(0)=='-'&&num3.charAt(0)=='-'){
                StringUrl="https://www.google.com/search?safe=strict&rlz=1C1CHZL_iwIL706IL706&sxsrf=ALeKk03D7KS81jHgLvXCt_X3yqFfxCoAEw%3A1587994970613&ei=WuGmXu_5JJShgAbs76f4Dg&q="+num1+"x%5E2"+num2+"x"+num3+"&oq="+num1+"x%5E2"+num2+"x"+num3+"&gs_lcp=CgZwc3ktYWIQAzoECCMQJ1CxRVixRWDIT2gAcAB4AIABoAWIAZoLkgEJMi0xLjAuMS4xmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjvjoOh3ojpAhWUEMAKHez3Ce8Q4dUDCAw&uact=5";
                wV.loadUrl(StringUrl);
            }
            else if(num2.charAt(0)=='-'){
                StringUrl="https://www.google.com/search?safe=strict&rlz=1C1CHZL_iwIL706IL706&sxsrf=ALeKk03D7KS81jHgLvXCt_X3yqFfxCoAEw%3A1587994970613&ei=WuGmXu_5JJShgAbs76f4Dg&q="+num1+"x%5E2"+num2+"x%2B"+num3+"&oq="+num1+"x%5E2"+num2+"x%2B"+num3+"&gs_lcp=CgZwc3ktYWIQAzoECCMQJ1CxRVixRWDIT2gAcAB4AIABoAWIAZoLkgEJMi0xLjAuMS4xmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjvjoOh3ojpAhWUEMAKHez3Ce8Q4dUDCAw&uact=5";
                wV.loadUrl(StringUrl);
            }
            else if(num3.charAt(0)=='-'){
                StringUrl="https://www.google.com/search?safe=strict&rlz=1C1CHZL_iwIL706IL706&sxsrf=ALeKk03D7KS81jHgLvXCt_X3yqFfxCoAEw%3A1587994970613&ei=WuGmXu_5JJShgAbs76f4Dg&q="+num1+"x%5E2%2B"+num2+"x"+num3+"&oq="+num1+"x%5E2%2B"+num2+"x"+num3+"&gs_lcp=CgZwc3ktYWIQAzoECCMQJ1CxRVixRWDIT2gAcAB4AIABoAWIAZoLkgEJMi0xLjAuMS4xmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjvjoOh3ojpAhWUEMAKHez3Ce8Q4dUDCAw&uact=5";
                wV.loadUrl(StringUrl);
            }
            else{
                StringUrl="https://www.google.com/search?safe=strict&rlz=1C1CHZL_iwIL706IL706&sxsrf=ALeKk03D7KS81jHgLvXCt_X3yqFfxCoAEw%3A1587994970613&ei=WuGmXu_5JJShgAbs76f4Dg&q="+num1+"x%5E2%2B"+num2+"x%2B"+num3+"&oq="+num1+"x%5E2%2B"+num2+"x%2B"+num3+"&gs_lcp=CgZwc3ktYWIQAzoECCMQJ1CxRVixRWDIT2gAcAB4AIABoAWIAZoLkgEJMi0xLjAuMS4xmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjvjoOh3ojpAhWUEMAKHez3Ce8Q4dUDCAw&uact=5";
                wV.loadUrl(StringUrl);
            }
        }
        num1=null;
        num2=null;
        num3=null;
        check1=null;
        check2=null;
        check3=null;
        eT.getText().clear();
        eT2.getText().clear();
        eT3.getText().clear();
        btn.setClickable(true);
        btn2.setClickable(true);
        btn3.setClickable(true);
        btn4.setClickable(false);
    }



}
