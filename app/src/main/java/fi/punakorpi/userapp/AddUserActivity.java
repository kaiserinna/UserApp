package fi.punakorpi.userapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddUserActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private RadioGroup degreeProgram;

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
    }

    public void addUser(View view) {
        String firstNameTxt = firstName.getText().toString();
        String lastNameTxt = lastName.getText().toString();
        String emailTxt = email.getText().toString();
        String degreeProgramTxt;
        int checkedId = degreeProgram.getCheckedRadioButtonId();
        if (checkedId == R.id.seRadioButton) {
            degreeProgramTxt = "Software Engineering";
        } else if (checkedId == R.id.imRadioButton) {
            degreeProgramTxt = "Industrial Management";
        } else if (checkedId == R.id.ceRadioButton) {
            degreeProgramTxt = "Computational Engineering";
        } else if (checkedId == R.id.eeRadioButton) {
            degreeProgramTxt = "Electrical Engineering";
        } else {
            return;
        }
        User u = new User(firstNameTxt, lastNameTxt, emailTxt, degreeProgramTxt);
        UserStorage.getInstance().addUserToStorage(u);
    }
}