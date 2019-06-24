package com.example.objetos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.frosquivel.magicalcamera.MagicalCamera;
import com.frosquivel.magicalcamera.MagicalPermissions;


public class CameraActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_take_photo, next, back;
    ImageView imageView_photo;
    MagicalCamera magicalCamera;
    MagicalPermissions magicalPermissions;
    Intent intentComunication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        next = findViewById(R.id.btn_camera_next);
        back = findViewById(R.id.btn_camera_back);


        imageView_photo = findViewById(R.id.img_photo);
        btn_take_photo = findViewById(R.id.btn_take_photo);
        String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        magicalPermissions = new MagicalPermissions(this, permissions);
        magicalCamera = new MagicalCamera(this, 50, magicalPermissions);
        next.setOnClickListener(this);
        back.setOnClickListener(this);


        btn_take_photo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_camera_back:

                intentComunication = new Intent(this, ImagesActivity.class);
                startActivity(intentComunication);
                finish();


                break;
            case R.id.btn_camera_next:

                intentComunication = new Intent(this, InternetActivity.class);
                startActivity(intentComunication);
                finish();


                break;
            case R.id.btn_take_photo:
                magicalCamera.takePhoto();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        //CALL THIS METHOD EVER
        magicalCamera.resultPhoto(requestCode, resultCode, data);

        //this is for rotate picture in this method
        //magicalCamera.resultPhoto(requestCode, resultCode, data, MagicalCamera.ORIENTATION_ROTATE_180);

        //with this form you obtain the bitmap (in this example set this bitmap in image view)
        imageView_photo.setImageBitmap(magicalCamera.getPhoto());

        //if you need save your bitmap in device use this method and return the path if you need this
        //You need to send, the bitmap picture, the photo name, the directory name, the picture type, and autoincrement photo name if           //you need this send true, else you have the posibility or realize your standard name for your pictures.
        String path = magicalCamera.savePhotoInMemoryDevice(magicalCamera.getPhoto(), "myPhotoName", "myDirectoryName", MagicalCamera.JPEG, true);

        if (path != null) {
            Toast.makeText(CameraActivity.this, "The photo is save in device, please check this path: " + path, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CameraActivity.this, "Sorry your photo dont write in devide, please contact with fabian7593@gmail and say this error", Toast.LENGTH_SHORT).show();
        }
    }
}
