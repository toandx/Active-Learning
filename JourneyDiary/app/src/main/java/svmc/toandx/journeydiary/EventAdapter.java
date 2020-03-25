package svmc.toandx.journeydiary;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import svmc.toandx.journeydiary.object.Event;

/*public class EventAdapter extends ArrayAdapter {
    private final Activity context;
    private ArrayList<String> event_name;
    public EventAdapter(Activity context, ArrayList<String> name)
    {
        super(context,R.layout.event_list_view,name);
        this.context=context;
        this.event_name=name;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.event_list_view, null,true);
        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.eventName);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(event_name.get(position));
        return rowView;

    };
}*/
public class EventAdapter extends ArrayAdapter {
    private final Activity context;
    private ArrayList<Event> value;
    public EventAdapter(Activity context, ArrayList<Event> value)
    {
        super(context,R.layout.event_list_view,value);
        this.context=context;
        this.value=value;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.event_list_view, null,true);
        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.eventName);
        TextView timeTextView = (TextView) rowView.findViewById(R.id.eventTime);
        //this code sets the values of the objects to values from the arrays
        timeTextView.setText(value.get(position).time);
        nameTextField.setText(value.get(position).name);
        return rowView;

    };
}
