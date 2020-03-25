package svmc.toandx.journeydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import svmc.toandx.journeydiary.object.Event;

public class MainActivity extends AppCompatActivity {

    private ListView eventList;
    private Button btnAdd;
    private ArrayList<Event> event;
    private EventAdapter eventAdapter;
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventList=findViewById(R.id.list);
        btnAdd=findViewById(R.id.addBtn);
        eventName=new ArrayList<>();
        eventAdapter=new EventAdapter(this,eventName);
        eventList.setAdapter(eventAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddEventActivity.class);
                startActivityForResult(intent,100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==100)
        {
            String name=data.getStringExtra("name");
            eventName.add(name);
            eventAdapter.notifyDataSetChanged();
            eventList.invalidateViews();
        }
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventList=findViewById(R.id.list);
        btnAdd=findViewById(R.id.addBtn);
        event=new ArrayList<>();
        eventAdapter=new EventAdapter(this,event);
        eventList.setAdapter(eventAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddEventActivity.class);
                startActivityForResult(intent,100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if((requestCode==100) && (resultCode==100))
        {
            String name=data.getStringExtra("name");
            String time=data.getStringExtra("time");
            event.add(new Event(name,time));
            eventAdapter.notifyDataSetChanged();
            eventList.invalidateViews();
        }
    }
}
