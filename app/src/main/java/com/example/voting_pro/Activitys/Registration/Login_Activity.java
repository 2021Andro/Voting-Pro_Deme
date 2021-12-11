package com.example.voting_pro.Activitys.Registration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.voting_pro.Activitys.Home_Activity;
import com.example.voting_pro.Custom_Classes.MyApp;
import com.example.voting_pro.Custom_Classes.User_Info;
import com.example.voting_pro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hbb20.CountryCodePicker;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class Login_Activity extends AppCompatActivity {

    private EditText etName, etEmailId, etPhoneNumber;
    private CountryCodePicker codePicker;
    private String name, emailId, phoneNumber;
    private ProgressBar progressBar;

    private CircleImageView profileImage;
    private int IMAGE_CODE = 1;
    private Uri imageUri;
    private boolean pickImage = false;
    private User_Info userInfo;
    private FirebaseFirestore myStore;
    private FirebaseFirestore fireStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myStore = FirebaseFirestore.getInstance();

        etName = findViewById(R.id.etName_Login);
        etEmailId = findViewById(R.id.etEmailId_Login);
        etPhoneNumber = findViewById(R.id.etPhoneNumber_Login);
        codePicker = findViewById(R.id.ccp_Login);
        profileImage = findViewById(R.id.profileImage_Login);
        progressBar = findViewById(R.id.progressBar_Login);

        progressBar.setVisibility(View.GONE);

        codePicker.registerCarrierNumberEditText(etPhoneNumber);

        // getting current user
        // checking user was login or not
        MyApp.myUser = FirebaseAuth.getInstance().getCurrentUser();

        if (MyApp.myUser != null) {
            startActivity(new Intent(getApplicationContext(), Home_Activity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        progressBar.setVisibility(View.GONE);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // selection image for profile
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

                intent.setType("image/*");

                startActivityForResult(Intent.createChooser(intent, "title"), IMAGE_CODE);


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == IMAGE_CODE) {

            if (resultCode == RESULT_OK) {

                imageUri = data.getData();

                profileImage.setImageURI(imageUri);

                pickImage = true;

            }
            if (resultCode == RESULT_CANCELED) {

                TastyToast.makeText(getApplicationContext(), "Select image from your profile", TastyToast.LENGTH_LONG, TastyToast.INFO).show();
                profileImage.setImageResource(R.drawable.login_image);

                pickImage = false;

            }


        }


    }

    // on user click login button
    public void buttonLogin(View view) {


        if (isViewsAreEmpty()) {

            userInfo = new User_Info(imageUri.toString(), name, emailId, phoneNumber);

            Intent intent = new Intent(getApplicationContext(), ManageOtp_Activity.class);

            intent.putExtra(MyApp.PASSING_USER_INFO_OBJECT_KEY, userInfo);

            startActivity(intent);

        }


    }

    // checking initialization of views
    private boolean isViewsAreEmpty() {

        boolean result = true;

        name = etName.getText().toString().trim();
        emailId = etEmailId.getText().toString().trim();
        phoneNumber = codePicker.getFullNumberWithPlus().trim();

        if (name.isEmpty()) {

            etName.setError("Enter Your Name");
            result = false;

        } else if (emailId.isEmpty()) {

            etEmailId.setError("Enter Your Email Id");
            result = false;

        } else if (!isEmailValid(emailId)) {

            etEmailId.setError("Enter Your Correct Email Id");
            result = false;

        } else if (phoneNumber.isEmpty()) {

            etPhoneNumber.setError("Enter Your Phone Number");
            result = false;

        } else if (phoneNumber.length() != 13) {

            etPhoneNumber.setError("Enter Your Correct Length Of Phone Number");
            result = false;

        } else if (!pickImage) {

            TastyToast.makeText(getApplicationContext(), "Select image from your profile", TastyToast.LENGTH_LONG, TastyToast.INFO).show();
            result = false;

        }

        return result;
    }

    // Cheking is email valid or not
    public static boolean isEmailValid(String email) {

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
}