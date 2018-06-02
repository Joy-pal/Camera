package com.example.joy.camera;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    final int request=1;
    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        if (!hasCamera()) {
            button.setEnabled(false);
        }
    }
       public boolean hasCamera(){
return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
        }




    public void click(View view){
           Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
           startActivityForResult(intent,request);
 }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==request&&requestCode==RESULT_OK){
            Bundle extra=data.getExtras();
            Bitmap bitmap=(Bitmap)extra.get("data");
            imageView.setImageBitmap(bitmap);
        }
    }





}
