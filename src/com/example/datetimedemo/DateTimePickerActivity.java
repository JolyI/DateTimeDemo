package com.example.datetimedemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
public class DateTimePickerActivity extends Activity {

	/** Called when the activity is first created. */
	private Button startDateTime;

	private String initStartDateTime = "2013年9月3日 14:44"; // 初始化开始时间
	private String time;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startDateTime = (Button) findViewById(R.id.inputDate);
		
		time =getLocalTime();
		startDateTime.setText(time);

		startDateTime.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
						DateTimePickerActivity.this, time);
				dateTimePicKDialog.dateTimePicKDialog(startDateTime);

			}
		});

	}
	//获取本地时间
	private String getLocalTime(){
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		String dateStr =dateFormat.format(new Date());
		Log.i("iii", "------获取到的系统时间为:"+dateStr);
		return dateStr;
	}
}
	

