package gh25.raul.raulghweek2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button button2;
    private String name;
    private String date;
    private String phone;
    private String email;
    private String description;

    private int dateDay;
    private int dateMonth;
    private int dateYear;

    String[] monthsStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Bundle bundle = getIntent().getExtras();

        name = (String) bundle.get("nameExtra");
        final TextView textName = (TextView) findViewById(R.id.TextViewName2b);
        textName.setText(name);

        phone = (String) bundle.get("phoneExtra");
        final TextView textPhone = (TextView) findViewById(R.id.TextViewPhone2b);
        textPhone.setText(phone);

        email = (String) bundle.get("emailExtra");
        final TextView textEmail = (TextView) findViewById(R.id.TextViewEmail2b);
        textEmail.setText(email);

        description = (String) bundle.get("descriptionExtra");
        final TextView textDescription = (TextView) findViewById(R.id.TextViewDescription2b);
        textDescription.setText(description);


        dateDay = (int) bundle.get("dateDayExtra");
        dateMonth = (int) bundle.get("dateMonthExtra");
        dateYear = (int) bundle.get("dateYearExtra");
        monthsStr = getResources().getStringArray(R.array.monthsStr);
        date = String.valueOf(dateDay) + " / " + monthsStr[dateMonth] + " / " + String.valueOf(dateYear);
        final TextView textDate = (TextView) findViewById(R.id.TextViewDate2b);
        textDate.setText(date);



        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(getApplicationContext(),MainActivity.class);
                secondIntent.putExtra("nameExtra",name);
                secondIntent.putExtra("phoneExtra",phone);
                secondIntent.putExtra("emailExtra",email);
                secondIntent.putExtra("descriptionExtra",description);
                secondIntent.putExtra("dateDayExtra",dateDay);
                secondIntent.putExtra("dateMonthExtra",dateMonth);
                secondIntent.putExtra("dateYearExtra",dateYear);
                startActivity(secondIntent);
            }
        });

    }
}
