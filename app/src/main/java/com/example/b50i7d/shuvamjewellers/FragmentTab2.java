package com.example.b50i7d.shuvamjewellers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Dell on 9/13/2016.
 */
public class FragmentTab2 extends Fragment {
    Button button;
    ImageView imageView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.list_item_layout, container, false);
        button = (Button)rootView.findViewById(R.id.cameraButton);
        imageView = (ImageView)rootView.findViewById(R.id.cameraImage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bp);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
