package com.example.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int WHOLE_NOTE = 1700;
    private static final int HALF_NOTE = WHOLE_NOTE/2;

    //buttons
    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;

    private Button highButtonA;
    private Button highButtonBb;
    private Button highButtonB;
    private Button highButtonC;
    private Button highButtonCs;
    private Button highButtonD;
    private Button highButtonDs;
    private Button highButtonE;
    private Button highButtonF;
    private Button highButtonFs;
    private Button highButtonG;
    private Button highButtonGs;

    private Button longScaleButton;
    private Button scaleButton;
    private Button customButton;
    private Button ttlsButton;
    private Button ttlsLong;
    private Button ttlscustom;
    private Button silscra;

    private CheckBox ttlsToggle;
    Boolean checkBoxState;

    //sounds
    private SoundPool soundPool;
    private int noteA;
    private int noteB;
    private int noteBb;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;

    private Map<Integer, Integer> noteMap;

    private int highNoteA;
    private int highNoteB;
    private int highNoteBb;
    private int highNoteC;
    private int highNoteCs;
    private int highNoteD;
    private int highNoteDs;
    private int highNoteE;
    private int highNoteF;
    private int highNoteFs;
    private int highNoteG;
    private int highNoteGs;

    public static final float DEFAULT_VOL = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE = 1.0f;


    private NumberPicker numberPicker;
    private NumberPicker notePicker;
    private NumberPicker ttlssel;
    private int currentCustomNote;
    private int currentCustomNumber;
    private int currenTtls;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {

        noteMap = new HashMap<>();
        //key is button ID and value is noteID
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gs, noteGs);

        noteMap.put(R.id.button_synth_highA, highNoteA);
        noteMap.put(R.id.button_synth_highB, highNoteB);
        noteMap.put(R.id.button_synth_highBb, highNoteBb);
        noteMap.put(R.id.button_synth_highC, highNoteC);
        noteMap.put(R.id.button_synth_highCs, highNoteCs);
        noteMap.put(R.id.button_synth_highD, highNoteD);
        noteMap.put(R.id.button_synth_highDs, highNoteDs);
        noteMap.put(R.id.button_synth_highE, highNoteE);
        noteMap.put(R.id.button_synth_highF, highNoteF);
        noteMap.put(R.id.button_synth_highFs, highNoteFs);
        noteMap.put(R.id.button_synth_highG, highNoteG);
        noteMap.put(R.id.button_synth_highGs, highNoteGs);




    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCs = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDs = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFs = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGs = soundPool.load(this, R.raw.scalegs, 1);

        highNoteA = sound(R.raw.scalehigha);
        highNoteB = sound(R.raw.scalehighb);
        highNoteBb = sound(R.raw.scalehighbb);
        highNoteC = sound(R.raw.scalehighc);
        highNoteCs = sound(R.raw.scalehighcs);
        highNoteD = sound(R.raw.scalehighd);
        highNoteDs = sound(R.raw.scalehighds);
        highNoteE = sound(R.raw.scalehighe);
        highNoteF = sound(R.raw.scalehighf);
        highNoteFs = sound(R.raw.scalehighfs);
        highNoteG = sound(R.raw.scalehighg);
        highNoteGs = sound(R.raw.scalehighgs);





    }

    private int sound(int scale) {
        return soundPool.load(this, scale, 1);
    }


    private void setListeners() {

        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);

        highButtonA.setOnClickListener(noteListener);
        highButtonBb.setOnClickListener(noteListener);
        highButtonB.setOnClickListener(noteListener);
        highButtonC.setOnClickListener(noteListener);
        highButtonCs.setOnClickListener(noteListener);
        highButtonD.setOnClickListener(noteListener);
        highButtonDs.setOnClickListener(noteListener);
        highButtonE.setOnClickListener(noteListener);
        highButtonF.setOnClickListener(noteListener);
        highButtonFs.setOnClickListener(noteListener);
        highButtonG.setOnClickListener(noteListener);
        highButtonGs.setOnClickListener(noteListener);


        customButton.setOnClickListener(this);
        longScaleButton.setOnClickListener(this);
        scaleButton.setOnClickListener(this);
        ttlsButton.setOnClickListener(this);
        ttlsLong.setOnClickListener(this);
        ttlscustom.setOnClickListener(this);
        silscra.setOnClickListener(this);


    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);

        highButtonA = findViewById(R.id.button_synth_highA);
        highButtonBb = findViewById(R.id.button_synth_highBb);
        highButtonB = findViewById(R.id.button_synth_highB);
        highButtonC = findViewById(R.id.button_synth_highC);
        highButtonCs = findViewById(R.id.button_synth_highCs);
        highButtonD = findViewById(R.id.button_synth_highD);
        highButtonDs = findViewById(R.id.button_synth_highDs);
        highButtonE = findViewById(R.id.button_synth_highE);
        highButtonF = findViewById(R.id.button_synth_highF);
        highButtonFs = findViewById(R.id.button_synth_highFs);
        highButtonG = findViewById(R.id.button_synth_highG);
        highButtonGs = findViewById(R.id.button_synth_highGs);


        longScaleButton = findViewById(R.id.button_synth_long);
        scaleButton = findViewById(R.id.button_synth_scale);
        customButton = findViewById(R.id.button_synth_numbernote);
        ttlsButton = findViewById(R.id.button_synth_twinkle);
        ttlsLong = findViewById(R.id.button_synth_twinklelong);
        ttlscustom = findViewById(R.id.button_synth_ttlscustom);
        silscra = findViewById(R.id.button_synth_silscra);

       // ttlsToggle=(CheckBox)findViewById(R.id.checkBox_synth_middlettls);
        ttlsToggle = findViewById(R.id.checkBox_synth_middlettls);

        numberPicker = findViewById(R.id.numberPicker_synth_numbersel);
        setupNumberPicker();
        notePicker = findViewById(R.id.numberPicker_synth_notesel);
        setupNotePicker();
        ttlssel = findViewById(R.id.numberPicker_synth_ttlssel);
        setupTtlsPicker();




    }

    private void setupTtlsPicker() {
        if (ttlssel != null) {
            ttlssel.setMinValue(0);
            ttlssel.setMaxValue(5);
            ttlssel.setWrapSelectorWheel(true);
            ttlssel.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    String text = "Changed from " + oldVal + " to " + newVal;
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    currenTtls = newVal;

                }
            });
        }


    }

    private void setupNotePicker() {
        if (notePicker != null) {
            final String[] values = {"A", "B Flat", "B", "C", "C Sharp", "D", "D Sharp", "E", "F", "F Sharp", "G", "G Sharp",
                    "High A", "High B Flat", "High B", "High C", "High C Sharp", "High D", "High D Sharp", "High E", "High F", "High F Sharp", "High G", "High G Sharp"};

            notePicker.setMinValue(0);
            notePicker.setMaxValue(values.length - 1);
            notePicker.setDisplayedValues(values);
            notePicker.setWrapSelectorWheel(true);
            notePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    String text = "Changed from " + values[oldVal] + " to " + values[newVal];
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    currentCustomNote = newVal;
                }
            });
        }

    }

    private void setupNumberPicker() {
        if (numberPicker != null) {
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(10);
            numberPicker.setWrapSelectorWheel(true);
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    String text = "Changed from " + oldVal + " to " + newVal;
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    currentCustomNumber = newVal;

                }
            });
        }
    }


    @Override
    public void onClick(View view) {
        //one method to handle the clicks of all buttons
        //but don't forget to tell the buttons who is doing the listening

        switch(view.getId()){
            case R.id.button_synth_long:
                playLong();
                break;
            case R.id.button_synth_scale:
                playScale();
                break;
            case R.id.button_synth_numbernote:
                playCustomNote();
                break;
            case R.id.button_synth_twinkle:
                playTwinkle();
                break;
            case R.id.button_synth_twinklelong:
                playFullTwinkle();
                break;
            case R.id.button_synth_ttlscustom:
                playCustomTwinkle();
                break;
            case R.id.button_synth_silscra:
                playScrapes();
                break;



        }

    }

    private void playScrapes() {
        Song scrapes = new Song();

        scrapes.add(new Note(noteD, WHOLE_NOTE/4));

        scrapes.add(new Note(highNoteB, WHOLE_NOTE/4));
        scrapes.add(new Note(noteE, WHOLE_NOTE/4));
        scrapes.add(new Note(highNoteB, WHOLE_NOTE/4));
        scrapes.add(new Note(noteE, WHOLE_NOTE/4));

        scrapes.add(new Note(noteE, WHOLE_NOTE/4));
        scrapes.add(new Note(noteC, WHOLE_NOTE/4));
        scrapes.add(new Note(noteE, WHOLE_NOTE/4));
        scrapes.add(new Note(noteC, WHOLE_NOTE/4));

        scrapes.add(new Note(highNoteB, WHOLE_NOTE/4));
        scrapes.add(new Note(noteG, WHOLE_NOTE/4));
        scrapes.add(new Note(highNoteB, WHOLE_NOTE/4));
        scrapes.add(new Note(noteG, WHOLE_NOTE/4));

        scrapes.add(new Note(noteFs, WHOLE_NOTE/4));
        scrapes.add(new Note(noteD, WHOLE_NOTE/4));
        scrapes.add(new Note(noteFs, WHOLE_NOTE/4));
        scrapes.add(new Note(noteD, WHOLE_NOTE/4));

        scrapes.add(new Note(noteG, WHOLE_NOTE/4));
        scrapes.add(new Note(noteE, WHOLE_NOTE/4));
        scrapes.add(new Note(noteG, WHOLE_NOTE/4));
        scrapes.add(new Note(noteE, WHOLE_NOTE/4));

        scrapes.add(new Note(noteE, WHOLE_NOTE/4));
        scrapes.add(new Note(noteC, WHOLE_NOTE/4));
        scrapes.add(new Note(noteE, WHOLE_NOTE/4));
        scrapes.add(new Note(noteC, WHOLE_NOTE/4));

        scrapes.add(new Note(highNoteB, WHOLE_NOTE/4));
        scrapes.add(new Note(noteG, WHOLE_NOTE/4));
        scrapes.add(new Note(highNoteB, WHOLE_NOTE/4));
        scrapes.add(new Note(noteG, WHOLE_NOTE/4));

        scrapes.add(new Note(noteFs, WHOLE_NOTE/2));

        scrapes.add(new Note(highNoteG,0));
        scrapes.add(new Note(noteG, WHOLE_NOTE/8));
        scrapes.add(new Note(highNoteFs, 0));
        scrapes.add(new Note(noteFs, WHOLE_NOTE/4));
        scrapes.add(new Note(highNoteE, 0));
        scrapes.add(new Note(noteE, WHOLE_NOTE/8 + WHOLE_NOTE/2));


        scrapes.add(new Note(highNoteE, 0));
        scrapes.add(new Note(noteE, WHOLE_NOTE/8));
        scrapes.add(new Note(highNoteFs, 0));
        scrapes.add(new Note(noteFs, WHOLE_NOTE/4 + WHOLE_NOTE/8 + WHOLE_NOTE/2));

        scrapes.add(new Note(highNoteE, 0));
        scrapes.add(new Note(noteE, WHOLE_NOTE/8));
        scrapes.add(new Note(highNoteC, 0));
        scrapes.add(new Note(noteC, WHOLE_NOTE/4 + WHOLE_NOTE/8 + WHOLE_NOTE/2));

        scrapes.add(new Note(highNoteG, 0));
        scrapes.add(new Note(noteG, WHOLE_NOTE/8));
        scrapes.add(new Note(highNoteA, 0));
        scrapes.add(new Note(noteA, WHOLE_NOTE/4));
        scrapes.add(new Note(highNoteB, 0));
        scrapes.add(new Note(noteB, WHOLE_NOTE/8 + WHOLE_NOTE/2));

        scrapes.add(new Note(highNoteG,0));
        scrapes.add(new Note(noteG, WHOLE_NOTE/8));
        scrapes.add(new Note(highNoteFs, 0));
        scrapes.add(new Note(noteFs, WHOLE_NOTE/4));
        scrapes.add(new Note(highNoteE, 0));
        scrapes.add(new Note(noteE, WHOLE_NOTE/8 + WHOLE_NOTE/2));


        scrapes.add(new Note(highNoteE, 0));
        scrapes.add(new Note(noteE, WHOLE_NOTE/8));
        scrapes.add(new Note(highNoteFs, 0));
        scrapes.add(new Note(noteFs, WHOLE_NOTE/4 + WHOLE_NOTE/8 + WHOLE_NOTE/2));

        scrapes.add(new Note(highNoteE, 0));
        scrapes.add(new Note(noteE, WHOLE_NOTE/8));
        scrapes.add(new Note(highNoteA, 0));
        scrapes.add(new Note(noteA, WHOLE_NOTE/4 + WHOLE_NOTE/8 + WHOLE_NOTE/2));

        scrapes.add(new Note(highNoteG, 0));
        scrapes.add(new Note(noteG, WHOLE_NOTE/8));
        scrapes.add(new Note(highNoteA, 0));
        scrapes.add(new Note(noteA, WHOLE_NOTE/4));
        scrapes.add(new Note(highNoteB, 0));
        scrapes.add(new Note(noteB, WHOLE_NOTE/8 + WHOLE_NOTE/2));



        scrapes.add(new Note(highNoteC, WHOLE_NOTE/8));
        scrapes.add(new Note(highNoteB, WHOLE_NOTE/4));
        scrapes.add(new Note(highNoteA, WHOLE_NOTE/8));





















        playSong(scrapes);


        

    }


    private void playCustomTwinkle(){

        Song scale = new Song();



        scale.add(new Note(highNoteE, WHOLE_NOTE/2));
        scale.add(new Note(highNoteE, WHOLE_NOTE/2));
        scale.add(new Note(noteD, WHOLE_NOTE/2));
        scale.add(new Note(noteD, WHOLE_NOTE/2));
        scale.add(new Note(noteCs, WHOLE_NOTE/2));
        scale.add(new Note(noteCs, WHOLE_NOTE/2));
        scale.add(new Note(noteB));

        playTwinkle();
        for(int i = 0 ; i < ttlssel.getValue() ; i++){
            playSong(scale);
        }
        playTwinkle();
    }

    private void playFullTwinkle() {
        Song scale = new Song();



        scale.add(new Note(highNoteE, WHOLE_NOTE/2));
        scale.add(new Note(highNoteE, WHOLE_NOTE/2));
        scale.add(new Note(noteD, WHOLE_NOTE/2));
        scale.add(new Note(noteD, WHOLE_NOTE/2));
        scale.add(new Note(noteCs, WHOLE_NOTE/2));
        scale.add(new Note(noteCs, WHOLE_NOTE/2));
        scale.add(new Note(noteB));

        playTwinkle();
        playSong(scale);
        playSong(scale);
        playTwinkle();
    }

    private void playTwinkle() {
        Song scale = new Song();

        scale.add(new Note(noteA, WHOLE_NOTE/2));
        scale.add(new Note(noteA, WHOLE_NOTE/2));
        scale.add(new Note(highNoteE, WHOLE_NOTE/2));
        scale.add(new Note(highNoteE, WHOLE_NOTE/2));
        scale.add(new Note(highNoteFs, WHOLE_NOTE/2));
        scale.add(new Note(highNoteFs, WHOLE_NOTE/2));
        scale.add(new Note(highNoteE));
        scale.add(new Note(noteD, WHOLE_NOTE/2));
        scale.add(new Note(noteD, WHOLE_NOTE/2));
        scale.add(new Note(noteCs, WHOLE_NOTE/2));
        scale.add(new Note(noteCs, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteA));
        playSong(scale);
    }

    private void playCustomNote() {


        Note[] notes = {new Note(noteA), new Note(noteB), new Note(noteBb), new Note(noteC), new Note(noteCs), new Note(noteD),
                new Note(noteDs), new Note(noteE), new Note(noteF), new Note(noteFs), new Note(noteG), new Note(noteGs), new Note(highNoteA),
                new Note(highNoteB), new Note(highNoteBb), new Note(highNoteC), new Note(highNoteCs), new Note(highNoteD), new Note(highNoteDs), new Note(highNoteE),
                new Note(highNoteF), new Note(highNoteFs), new Note(highNoteG), new Note(highNoteGs)};

        Song scale = new Song();
        for(int i = 0 ; i < currentCustomNumber ; i++){
            scale.add(notes[currentCustomNote]);
        }
        playSong(scale);


    }
    //E, F Sharp, G, A, B, C Sharp, D, E

    private void playLong() {
        playNote(noteE);
        delay(HALF_NOTE);
        playNote(noteFs);
        delay(HALF_NOTE);
        playNote(noteG);
        delay(HALF_NOTE);
        playNote(highNoteA);
        delay(HALF_NOTE);
        playNote(highNoteB);
        delay(HALF_NOTE);
        playNote(highNoteCs);
        delay(HALF_NOTE);
        playNote(highNoteD);
        delay(HALF_NOTE);
        playNote(highNoteE);

    }

    private void playScale() {
        //play all notes one at a time with delay in between
        Song scale = new Song();

        scale.add(new Note(noteA));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteB, Note.WHOLE_NOTE*2));
        scale.add(new Note(noteC));
        scale.add(new Note(noteCs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteDs));
        scale.add(new Note(noteE, Note.WHOLE_NOTE*2));
        scale.add(new Note(noteF));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteG));
        scale.add(new Note(noteGs));

        playSong(scale);



    }

    private void playSong(Song current) {
        for(Note n : current.getNotes()){
            playNote(n);
            delay(n.getDelay());
        }
    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
            soundPool.play(note, DEFAULT_VOL, DEFAULT_VOL, DEFAULT_PRIORITY, loop, DEFAULT_RATE);
    }
    private void playNote(int note){
        playNote(note, 0);
    }
    private void playNote(Note note){
        playNote(note.getNoteId(), 0);
    }



    //make an inner class that handles the button clicks

    private class KeyboardNoteListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //get id of button that was clicked
            //use map to figure out what note
            //play note
            int id = view.getId();
            int note = noteMap.get(id);
            playNote(note);
        }
    }
}
