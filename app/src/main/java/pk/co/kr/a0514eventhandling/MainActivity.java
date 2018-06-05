package pk.co.kr.a0514eventhandling;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView imgView;

    //타이머를 위한 변수
    int idx;
    CountDownTimer timer;


    TextView display;
    EditText input;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main.xml 파일의 내용을 읽어서 메모리에 로드하는 메소드
        setContentView(R.layout.activity_main);

        display = (TextView)findViewById(R.id.display);
        input = (EditText)findViewById(R.id.input);
        //EditText의 글자가 변경될 때 수행할 내용
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = input.getText().toString();
                display.setText(str);
            }
        });


        btn = (Button)findViewById(R.id.btn);
        imgView = (ImageView)findViewById(R.id.img);

        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (btn.getText().equals("시작")) {
                    btn.setText("중지");
                    timer = new CountDownTimer(100000000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(idx % 5 == 0 ){
                                imgView.setImageResource(R.drawable.a1);
                            }
                            else if(idx % 5 == 1){
                                imgView.setImageResource(R.drawable.a2);
                            }
                            else if(idx % 5 == 2){
                                imgView.setImageResource(R.drawable.a3);
                            }
                            else if(idx % 5 == 3){
                                imgView.setImageResource(R.drawable.a4);
                            }
                            else if(idx % 5 == 4){
                                imgView.setImageResource(R.drawable.a5);
                            }
                            idx = idx + 1;
                        }

                        @Override
                        public void onFinish() {
                            idx = 0;

                        }
                    };
                    //타이머 시작
                    timer.start();
                }
                else{
                    btn.setText("시작");
                    timer.cancel();
                    Toast.makeText(MainActivity.this,"타이머 종료", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}



























