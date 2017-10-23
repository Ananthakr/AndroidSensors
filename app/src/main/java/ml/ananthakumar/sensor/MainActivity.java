package ml.ananthakumar.sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager mySensorManager;
    public TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);
        mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> myList = mySensorManager.getSensorList(Sensor.TYPE_ALL);
        //remove existing text
        display.setText("");
        for(Sensor s : myList){
            display.append("\n"+s.getName()+"\t - \t"+s.getVendor());
        }
    }
}
