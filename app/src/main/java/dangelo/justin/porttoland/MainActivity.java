package dangelo.justin.porttoland;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private int userNumber;
    private int squareNumber;
    private EditText userInput;
    private TextView display;
    private final String SQUARED_KEY = "squared key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.txtUserEntry);
        display = (TextView) findViewById(R.id.txtDisplay);

        if (savedInstanceState != null){
            squareNumber = savedInstanceState.getInt(SQUARED_KEY);
            display.setText("" + squareNumber);
            Log.d("JUSTIN","Save state loaded");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(SQUARED_KEY, squareNumber);
        Log.d("JUSTIN","Save state saved");
    }

    public void onClick(View v){
        try {
            userNumber = Integer.parseInt(userInput.getText().toString());
            Log.d("JUSTIN", "userNumber Parsed");
           squareNumber = (userNumber) * (userNumber);
            Log.d("JUSTIN", "squareNumber calculated");
           display.setText("" + squareNumber);
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
