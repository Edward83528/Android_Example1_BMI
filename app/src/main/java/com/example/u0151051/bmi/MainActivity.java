//檔案路徑
package com.example.u0151051.bmi;
// 1.android.app.Activity 2.android.os.Bundle;幾乎所有應用程式都會用到這兩個package

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

//程式主體 宣告一個MainActivity 的公開類別這個類別繼承Activity
public class MainActivity extends AppCompatActivity {
    //宣告元件
    EditText et3, et4;
    Button btn;
    TextView tv1, tv2, tv3, tv4;

    // Android載入畫面的方法
    /*
     * Bundle型別的內容與Android的記憶體管理有關
	 * 當android應用程式啟動或換到背景等待或關閉時都會用到savedInstanceState這個實體來處理記憶體相關事宜,當然也可自訂參數
	 * android將其應用程式的介面稱為view,而負責控制各種動作行為的程式主體,稱活動Activity,
	 * 一個android應用程式必定會對應一個或以上的活動 onCreate方法則是每個活動初始化都會呼叫的方法,也是生命週期的第一個方法
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// 保持父類別的onCreate方法
        setContentView(R.layout.activity_main);// 設定螢幕顯示畫面讀取畫面的xml(R.layout.activity_main)
        findbyid();
    }

    //設定元件
    void findbyid() {
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);
        // 設定按鈕,透過Activity 類碟中內建的findViewById方法從資源檔找出元件實體,在轉型成button
        btn = (Button) findViewById(R.id.button);
        // 事件驅動方式(把監聽器設定給button)
        btn.setOnClickListener(c);
    }

    // 觸發事件函式(設定監聽器)
    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // DecimalFormat可以的四捨五入類別
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            double h = Double.parseDouble(et3.getText().toString()) / 100;
            double w = Double.parseDouble(et4.getText().toString());
            double bmi = w / (h * h);
            tv3.setText("你的BMI是:" + decimalFormat.format(bmi));
            if (bmi > 25) {
                tv4.setText(R.string.advice_heavy);
            } else if (bmi < 20) {
                tv4.setText(R.string.advice_light);
            } else {
                tv4.setText(R.string.advice_average);
            }

        }
    };
}
