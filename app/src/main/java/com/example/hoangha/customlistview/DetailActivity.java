package com.example.hoangha.customlistview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoangha.customlistview.Utils.DetailUtils;

public class DetailActivity extends AppCompatActivity {

    //    @BindView(R.id.tvTitle)
    TextView tvTitle;

    //    @BindView(R.id.tvContent)
    TextView tvContent;

    //    @BindView(R.id.tvAddress)
    TextView tvAddress;

    //    @BindView(R.id.etComments)
    EditText etComments;

    //    @BindView(R.id.tvTime)
    TextView tvTime;

    //    @BindView(R.id.btnOk)
    Button btnOk;

    private String EXTRA = "Content";
    private DetailUtils detailUtils;
    private ImageView ivImage;
    private String url;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        ButterKnife.bind(this);

        getExtra();

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvContent = (TextView) findViewById(R.id.tvContent);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        btnOk = (Button) findViewById(R.id.btnOk);
//        tvTime = (TextView) findViewById(R.id.tvTime);

        setUpView();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: inplement push data to firebase here!
            }
        });

    }


    public void getExtra() {
        Intent intent = new Intent();
//        if (intent.hasExtra(EXTRA)) {
//            detailUtils = intent.getExtras().getParcelable(EXTRA);
//        }

        detailUtils =  getIntent().getParcelableExtra(EXTRA);
        Toast.makeText(this, "xx", Toast.LENGTH_SHORT).show();
    }

    private void setUpView() {

        tvTitle.setText(detailUtils.getTvTitle());
        tvContent.setText(detailUtils.getTvContent());
        tvAddress.setText(detailUtils.getTvAddress());
//        tvTime.setText(detailUtils.getTvTime());

//        Glide.with(ivImage.getContext())
//                .load(detailUtils.getUrl())
//                .into(ivImage);
        int resId = getResources().getIdentifier("i" + detailUtils.getUrl(), "drawable", getPackageName());

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext()
                ,resId);
        ivImage.setImageDrawable(drawable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
