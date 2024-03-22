package fi.punakorpi.userapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private RadioGroup degreeProgram;
    private CheckBox degreeB;
    private CheckBox degreeM;
    private CheckBox degreeL;
    private CheckBox degreePhd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editLastName);
        email = findViewById(R.id.editEmail);
        degreeProgram = findViewById(R.id.radioDegreeProgram);
        degreeB = findViewById(R.id.bcCheckBox);
        degreeM = findViewById(R.id.msCheckBox);
        degreeL = findViewById(R.id.lciCheckBox);
        degreePhd = findViewById(R.id.phdCheckBox);
    }

    public void addUser(View view) {
        String firstNameTxt = firstName.getText().toString();
        String lastNameTxt = lastName.getText().toString();
        String emailTxt = email.getText().toString();
        String degreeProgramTxt;
        int checkedDPId = degreeProgram.getCheckedRadioButtonId();
        if (checkedDPId == R.id.seRadioButton) {
            degreeProgramTxt = "Software Engineering";
        } else if (checkedDPId == R.id.imRadioButton) {
            degreeProgramTxt = "Industrial Management";
        } else if (checkedDPId == R.id.ceRadioButton) {
            degreeProgramTxt = "Computational Engineering";
        } else if (checkedDPId == R.id.eeRadioButton) {
            degreeProgramTxt = "Electrical Engineering";
        } else {
            return;
        }

        String degreeTxt = getString();
        User u = new User(firstNameTxt, lastNameTxt, emailTxt, degreeProgramTxt, degreeTxt);
        UserStorage.getInstance().addUserToStorage(u);
        UserStorage.getInstance().saveUsersToFile(Context context);
    //TODO; miten saan contextin mainista tähän tonne välitettäväksi?
    }

    @NonNull
    private String getString() {
        ArrayList<String> degree = new ArrayList<>();
        if (degreePhd.isChecked()) {
            degree.add("Doctoral degree");
        } if (degreeL.isChecked()) {
            degree.add("Licenciate");
        } if (degreeM.isChecked()) {
            degree.add("M.Sc. degree");
        } if (degreeB.isChecked()) {
            degree.add("B.Sc. degree");
        }

        StringBuilder degreeStringBuilder = new StringBuilder();
        for (int i = 0; i < degree.size(); i++) {
            //    if (i < 1) {
            if (i == 0) {
                degreeStringBuilder.append(degree.get(i));
            } else {
                degreeStringBuilder.append(", ").append(degree.get(i));
            }
        }
        return degreeStringBuilder.toString();
    }
}