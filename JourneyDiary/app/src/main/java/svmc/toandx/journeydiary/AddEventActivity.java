package svmc.toandx.journeydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddEventActivity extends AppCompatActivity {

    private Button btnAdd;
    private String name,time;
    private int hour,min,year,month,date;
    private EditText etName;
    private TextView tvTime;
    private Calendar calendar;
    private Context mContext;
    private SimpleDateFormat sdf;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        btnAdd=findViewById(R.id.btnAdd);
        etName=findViewById(R.id.etEventName1);
        tvTime=findViewById(R.id.tv_click_time);
        sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        mContext=this;
        calendar=Calendar.getInstance();
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hour=calendar.get(Calendar.HOUR);
                min=calendar.get(Calendar.MINUTE);
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                date=calendar.get(Calendar.DATE);
                DatePickerDialog datePickerDialog=new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        calendar.set(Calendar.YEAR,year);
                        calendar.set(Calendar.MONTH,month);
                        calendar.set(Calendar.DATE,date);
                    }
                },year,month,date);
                datePickerDialog.show();
                TimePickerDialog timePickerDialog=new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int min) {
                        calendar.set(Calendar.HOUR,hour);
                        calendar.set(Calendar.MINUTE,min);
                    }
                },hour,min,true);
                timePickerDialog.show();
                tvTime.setText(sdf.format(calendar.getTime()));
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent();
                intent.putExtra("name",etName.getText().toString());
                //intent.putExtra("name",etName.getText());
                intent.putExtra("time",sdf.format(calendar.getTime()));
                setResult(100,intent);
                finish();
            }
        });
    }
}
