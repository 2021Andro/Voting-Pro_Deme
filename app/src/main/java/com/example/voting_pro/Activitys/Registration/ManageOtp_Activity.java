package com.example.voting_pro.Activitys.Registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.voting_pro.Activitys.Home_Activity;
import com.example.voting_pro.Custom_Classes.MyApp;
import com.example.voting_pro.Custom_Classes.User_Info;
import com.example.voting_pro.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.concurrent.TimeUnit;

public class ManageOtp_Activity extends AppCompatActivity {


    private EditText etOtp;
    private String phoneNumber, otpId;
    private ProgressBar progressBar;
    private Button btnSubmit;
    private User_Info userInfo;
    private String enterOtp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_otp);


        etOtp = findViewById(R.id.etOtp_MO);

        progressBar = findViewById(R.id.progressBar_MO);

        btnSubmit = findViewById(R.id.btnSubmitOtp_MO);

        progressBar.setVisibility(View.GONE);

        userInfo = (User_Info) getIntent().getSerializableExtra(MyApp.PASSING_USER_INFO_OBJECT_KEY);

        phoneNumber = userInfo.getPhone_Number();

        initiateOtp();

    }

    // getting otp
    private void initiateOtp() {


        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(MyApp.myAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                otpId = s;

                                visibleViews();

                            }

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {


                                visibleViews();

                                signInWithPhoneAuthCredential(phoneAuthCredential);

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {


                                visibleViews();

                                Log.d(MyApp.TAG, "Verification Failed : Exception => " + e.getMessage());

                                TastyToast.makeText(getApplicationContext(), "Verification Failed : Exception => " + e.getMessage(), TastyToast.LENGTH_LONG, TastyToast.SUCCESS).show();


                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);


    }

    // request from login
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {


        MyApp.myAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {


                            Intent intent = new Intent(ManageOtp_Activity.this, Home_Activity.class);
                            startActivity(intent);

                            finish();

                        } else {

                            visibleViews();


                            Log.w(MyApp.TAG, "signInWithCredential:failure", task.getException());


                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {


                                visibleViews();

                                // The verification code entered was invalid
                                Log.d(MyApp.TAG, "The verification code entered was invalid");

                                TastyToast.makeText(getApplicationContext(), "The verification code entered was invalid", TastyToast.LENGTH_LONG, TastyToast.SUCCESS).show();

                            }


                        }
                    }
                });


    }

    private void saveUserInfo(String userId) {




        Log.d(MyApp.TAG, "signInWithCredential:success");

        TastyToast.makeText(getApplicationContext(), "Your signIn is successful", TastyToast.LENGTH_LONG, TastyToast.SUCCESS).show();



    }

    private boolean isViewsAreEmpty() {

        enterOtp = etOtp.getText().toString().trim();

        boolean result = true;

        if (enterOtp.isEmpty()) {

            etOtp.setError("Enter your otp");
            result = false;

        } else if (enterOtp.length() != 6) {

            etOtp.setError("Enter your correct otp");
            result = false;


        }

        return result;
    }

    private void buttonSubmitOtp(View view) {

        if (isViewsAreEmpty()) {


            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otpId, enterOtp);

            signInWithPhoneAuthCredential(credential);

        }


    }

    // invisible views
    private void invisibleViews() {

        progressBar.setVisibility(View.VISIBLE);
        etOtp.setVisibility(View.INVISIBLE);
        btnSubmit.setVisibility(View.INVISIBLE);

    }

    // visible views
    private void visibleViews() {

        progressBar.setVisibility(View.INVISIBLE);
        etOtp.setVisibility(View.VISIBLE);
        btnSubmit.setVisibility(View.VISIBLE);

    }

}