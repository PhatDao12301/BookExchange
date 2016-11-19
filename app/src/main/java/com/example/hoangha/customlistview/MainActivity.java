package com.example.hoangha.customlistview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hoangha.customlistview.Utils.DetailUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ListView lvNote;
    private NoteAdapter mNoteAdapter;
    List<DetailUtils> notes;
    ArrayList<DetailUtils> arrayNotes;
    private DetailUtils mDetailUtils;
    private String EXTRA = "Content";
    private int RESULT_CODE = 13;
//    private StaggeredGridLayoutManager mLayoutManager;
    //Drawable drawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNote = (ListView) findViewById(R.id.lvNote);

        final String[] titles = {"Note1", "Note2", "Note3", "Note4", "Note5", "Note6"
                , "Note7", "Note8", "Note9", "Note10", "Note11", "Note12", "Note13"};
        String[] contents = {"adad", "ssae", "sadf", "afdg", "addi", "asl", "add1"
                , "aeds1", "asdf1", "agd1", "asdi1", "asdl1", "dfaf"};
        String[] times = {"november 4", "october 3", "november 6", "november 18", "november 4"
                , "october 3", "november 6", "november 18", "november 6", "november 18", "november 4"
                , "october 3", "november 6"};
        String[] address = {"2669 Mill Street", "08 Loop Rd, Falls Mills, VA, 24613"
                , "5881 Mcclellan Dr", "17 Fieldside Dr"
                , "2669 Mill Street", "08 Loop Rd, Falls Mills, VA, 24613"
                , "5881 Mcclellan Dr", "17 Fieldside Dr", "2669 Mill Street", "08 Loop Rd, Falls Mills, VA, 24613"
                , "5881 Mcclellan Dr", "17 Fieldside Dr", "2669 Mill Street"};


        arrayNotes = new ArrayList<>();
        Drawable drawable;
        int resId;

        for (int i = 0; i < titles.length; i++) {

            //image
            resId = getResources().getIdentifier("i" + i, "drawable", getPackageName());
            drawable = ContextCompat.getDrawable(getApplicationContext(), resId);

            arrayNotes.add(new DetailUtils(titles[i], contents[i], drawable, times[i]
                    , address[i], String.valueOf(i), 0));
        }

        notes = arrayNotes;

        mNoteAdapter = new NoteAdapter(MainActivity.this, notes);
        lvNote.setAdapter(mNoteAdapter);

        lvNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDetailUtils = (DetailUtils) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(EXTRA, mDetailUtils);

                startActivityForResult(intent, RESULT_CODE);
            }
        });

    }

    public void AddItem(View view) {
        int resId = getResources().getIdentifier("sample", "drawable", getPackageName());
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), resId);

        //After adding new note, clicking on new item (line 56) makes an error: "id out of range".
        // because titles[position] not exist.
        arrayNotes.add(new DetailUtils("Note New", "Content new", drawable, "", ""));
        mNoteAdapter.notifyDataSetChanged();
        //Method2: mNoteAdapter.addNote(new Note("Note New","Content new",drawable));
    }


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(MainActivity.this, "loaded", Toast.LENGTH_SHORT).show();
//    }
}
