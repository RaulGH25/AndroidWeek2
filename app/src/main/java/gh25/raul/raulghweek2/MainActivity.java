package gh25.raul.raulghweek2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonMain;
    private String name;
    private String phone;
    private String email;
    private String description;

    private int dateDay;
    private int dateMonth;
    private int dateYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textName = (TextView) findViewById(R.id.editTextName);

        final TextView textPhone = (TextView) findViewById(R.id.editTextPhone);

        final TextView textEmail = (TextView) findViewById(R.id.editTextEmail);

        final TextView textDescription = (TextView) findViewById(R.id.editTextDescription);

        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);


        // CardView Focus

        final CardView cardView = (CardView) findViewById(R.id.cardView);
        final TextView textViewDateCancel = (TextView) findViewById(R.id.textViewDatePickerCancel);
        final TextView textViewDateOk = (TextView) findViewById(R.id.textViewDatePickerOk);

        textViewDateCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textName.requestFocus();
            }
        });

        textViewDateOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textPhone.requestFocus();
            }
        });


        cardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    cardView.setCardElevation(getResources().getDimension(R.dimen.datePickerElevationHighLight));
                }
                else{
                    cardView.setCardElevation(getResources().getDimension(R.dimen.datePickerElevation));
                }
            }
        });



        // Bundle

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            name = (String) bundle.get("nameExtra");
            phone = (String) bundle.get("phoneExtra");
            email = (String) bundle.get("emailExtra");
            description = (String) bundle.get("descriptionExtra");
            dateDay = (int) bundle.get("dateDayExtra");
            dateMonth = (int) bundle.get("dateMonthExtra");
            dateYear = (int) bundle.get("dateYearExtra");

            textName.setText(name);
            textPhone.setText(phone);
            textEmail.setText(email);
            textDescription.setText(description);
            datePicker.updateDate(dateYear,dateMonth,dateDay);
        }








        // Action Button

        buttonMain = (Button) findViewById(R.id.buttonMain);

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = textName.getText().toString();

                phone = textPhone.getText().toString();

                email = textEmail.getText().toString();

                description = textDescription.getText().toString();

                dateDay = datePicker.getDayOfMonth();
                dateMonth = datePicker.getMonth();
                dateYear = datePicker.getYear();

                Intent mainIntent = new Intent(getApplicationContext(), SecondActivity.class);
                mainIntent.putExtra("nameExtra", name);
                mainIntent.putExtra("phoneExtra", phone);
                mainIntent.putExtra("emailExtra", email);
                mainIntent.putExtra("descriptionExtra", description);
                mainIntent.putExtra("dateDayExtra", dateDay);
                mainIntent.putExtra("dateMonthExtra", dateMonth);
                mainIntent.putExtra("dateYearExtra", dateYear);
                startActivity(mainIntent);
            }
        });





    }
}
